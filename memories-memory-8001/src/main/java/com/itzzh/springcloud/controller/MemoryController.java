package com.itzzh.springcloud.controller;

import com.itzzh.springcloud.entities.Memory;
import com.itzzh.springcloud.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/memory")
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @RequestMapping("/memories")
    public String memories(Map<String,Object> map){
        //获取数据，做多不超过50个
        List<Memory> memoryList = memoryService.findAllMemories();
        map.put("memoryList",memoryList);
        return "memories";
    }

    @RequestMapping("/getById/{id}")
    public String queryMemoryById(@PathVariable("id") Long memoryId, Map<String,Object> map) {
        Memory memory = memoryService.queryMemoryById(memoryId);
        map.put("memory",memory);
        return "memoryDetail";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Memory queryMemoryById(@PathVariable("id") Long memoryId ) {
        Memory memory = memoryService.queryMemoryById(memoryId);
        return memory;
    }

    @RequestMapping("/list")
    public String queryMemories(Map<String,Object> map) {
        List<Memory> memoryList = memoryService.findAllMemories();
        map.put("memoryList",memoryList);
        return "memoryList";
    }

    @ResponseBody
    @RequestMapping("/addMemoryUI")
    public String addMemoryUI() {
        //获取当前时刻，时间格式为yyyy-MM-dd HH:mm:ss
        String moment = new Date().toLocaleString();
        // TODO 获取位置信息、获取当地当时天气情况
        return moment;
    }

    @RequestMapping("/addMemory")
    public String addMemory(Memory memory, @RequestParam("memory_pic") MultipartFile memory_pic) throws Exception{
        //原始名称
        String originalFilename = memory_pic.getOriginalFilename();
        //上传图片
        if(memory_pic != null && originalFilename!=null && originalFilename.length()>0) {
            //存储图片的物理路径,设置tomcat的图片虚拟目录为此目录。
            String pic_path = "E:/Codes/img/upload/";
            //新的图片名称
            String newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
            //新的图片
            File newFile = new File(pic_path+newFileName);
            //将内存中的数据写入磁盘中
            //TODO intellij中每次获取的都是相对路径，写入失败不晓得怎么回事。FileNotFoundException
            memory_pic.transferTo(newFile);
            //将新图片名称写入到memory中
            memory.setPicture(newFileName);
        }
        //TODO 存取位置，天气和对应用户的信息。
        memoryService.addMemory(memory);
        return "redirect:/memory/memories";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMemory(@PathVariable("id") Long memoryId) {
        //根据id查询到相应的记忆，再做修改
        Memory memory = memoryService.queryMemoryById(memoryId);
        //删除指定的记忆，
        memoryService.deleteMemory(memory);
        return "redirect:/memory/list"; //得返回上一级才行
    }

    @RequestMapping("/update/{id}")
    public String editMemoryUI(@PathVariable("id") Long memoryId,Map<String,Object> map) throws Exception {
        //现根据id，查询到对应的记忆
        Memory memory = memoryService.queryMemoryById(memoryId);
        if(memory == null) {
//            throw new CustomException("没有查询到对应的记忆片段"); //Custom是之前自定义的异常处理类。
            throw new RuntimeException("先用这个代替");
        }
        //获取当前时刻，时间格式为yyyy-MM-dd HH:mm:ss
        String moment = new Date().toLocaleString();
        map.put("moment",moment);

        //放置数据进行回显
        map.put("memory",memory);
        return "editMemoryUI";
    }

    @RequestMapping("/editMemory")
    public String editMemory(Model model,
                             Long memoryId,
                             String oldPictureName,
                             @Valid Memory memory,
                             BindingResult bindingResult,
                             MultipartFile memory_pic) throws Exception{

        //获取校验的错误信息
        if(bindingResult.hasErrors()) {
            //取出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for(ObjectError objectError:allErrors) {
                //输出错误信息
                System.out.println(objectError.getDefaultMessage());
            }
            //将错误信息传到页面
            model.addAttribute("allErrors",allErrors);
            //跳会到修改页面进行错误显示
            return "editMemoryUI";
        }

        //原始名称
        String originalFilename = memory_pic.getOriginalFilename();
        //上传图片
        if(memory_pic != null && originalFilename!=null && originalFilename.length()>0) {
            //存储图片的物理路径,设置tomcat的图片虚拟目录为此目录。
            String pic_path = "E:\\Codes\\img\\upload\\";
            //新的图片名称
            String newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
            //新的图片
            File newFile = new File(pic_path+newFileName);
            //将内存中的数据写入磁盘中
            memory_pic.transferTo(newFile);
            //将新图片名称写入到memory中
            memory.setPicture(newFileName);
        }else {
            //保留原来的图片名称，写入到memory中
            memory.setPicture(oldPictureName);
        }

        //调用service完成更新商品信息，页面需要将商品的信息传到此方法上
        memoryService.updateMemory(memoryId, memory);

        return "redirect:/memory/list";
    }

}