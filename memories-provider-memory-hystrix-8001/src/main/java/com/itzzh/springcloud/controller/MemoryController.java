package com.itzzh.springcloud.controller;


import com.itzzh.springcloud.entities.Memory;
import com.itzzh.springcloud.service.MemoryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemoryController {

    @Autowired
    private MemoryService service;

    @Autowired
    private DiscoveryClient client;

    /* 添加*/
    @RequestMapping(value = "/memory/add",method= RequestMethod.POST )
    public boolean addMemory(@RequestBody Memory memory){
        return service.addMemory(memory);
    }

    /* 删除*/
    @RequestMapping(value = "/memory/delete",method = RequestMethod.POST)
    public boolean deleteMemory(@RequestBody Memory memory){
        return service.deleteMemory(memory);
    }

    /* 修改*/
    @RequestMapping(value = "/memory/update",method = RequestMethod.POST)
    public boolean updateMemory(@RequestBody Memory memory){
        return service.updateMemory(memory);
    }

    /* 查询单个*/
    @HystrixCommand(fallbackMethod="processHystrix_Get") //hystrix熔断
    @RequestMapping(value = "/memory/get/{id}",method = RequestMethod.GET)
    public Memory getMemory(@PathVariable("id") Long id){
        Memory memory = service.getMemoryById(id);
        if(null == memory)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return memory;
    }
    public Memory processHystrix_Get(@PathVariable("id") Long id) //熔断处理，返回一个自定义的对象
    {
        Memory memory = new Memory();
        memory.setMemoryId(id);
        memory.setPicture("C9069425CCA8DA535AA9BC8FC81F4675.jpg");
        memory.setDescription( "该ID："+id+"没有没有对应的信息,null--@HystrixCommand");
        return memory;
    }

    /* 查询全部*/
    @RequestMapping(value = "/memory/list",method = RequestMethod.GET)
    public List<Memory> getAllMemories(){
        return service.getAllMemories();
    }

    /* 服务发现*/
    @RequestMapping(value="/memory/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MEMORIES-MEMORY");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}