package com.itzzh.springcloud.service;

import com.itzzh.springcloud.entities.Memory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MEMORIES-MEMORY",fallbackFactory = MemoryClientServiceFallbackFactory.class)
public interface MemoryClientService {

    /* 添加*/
    @RequestMapping(value = "/memory/add",method= RequestMethod.POST )
    public boolean addMemory(@RequestBody Memory memory);

    /* 删除*/
    @RequestMapping(value = "/memory/delete",method = RequestMethod.POST)
    public boolean deleteMemory(@RequestBody Memory memory);

    /* 修改*/
    @RequestMapping(value = "/memory/update",method = RequestMethod.POST)
    public boolean updateMemory(@RequestBody Memory memory);

    /* 查询单个*/
    @RequestMapping(value = "/memory/get/{id}",method = RequestMethod.GET)
    public Memory getMemory(@PathVariable("id") Long id);

    /* 查询全部*/
    @RequestMapping(value = "/memory/list",method = RequestMethod.GET)
    public List<Memory> getAllMemories();

    /* 服务发现*/
    @RequestMapping(value="/memory/discovery", method = RequestMethod.GET)
    public Object discovery();

}
