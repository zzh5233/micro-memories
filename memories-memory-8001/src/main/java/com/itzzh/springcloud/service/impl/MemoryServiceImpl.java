package com.itzzh.springcloud.service.impl;

import com.itzzh.springcloud.dao.MemoryDao;
import com.itzzh.springcloud.entities.Memory;
import com.itzzh.springcloud.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class MemoryServiceImpl implements MemoryService {

    @Autowired
    private MemoryDao dao;

    @Override
    public void addMemory(Memory memory) {
        dao.addMemory(memory);
    }

    @Override
    public List<Memory> findAllMemories() {
        return dao.findAllMemories();
    }

    @Override
    public Memory queryMemoryById(Long memoryId) {
        return dao.queryMemoryById(memoryId);
    }

    @Override
    public void deleteMemory(Memory memory) {
        dao.deleteMemory(memory);
    }

    @Override
    public void updateMemory(Long memoryId, @Valid Memory memory) {
        //添加业务校验，通常在service接口对关键参数进行校验
        //检验id是否为空，若为空抛出异常
        memory.setMemoryId(memoryId);
        dao.updateMemory(memory);
    }

}