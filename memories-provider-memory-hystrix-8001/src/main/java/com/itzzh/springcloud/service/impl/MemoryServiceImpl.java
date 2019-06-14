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
    public boolean addMemory(Memory memory) {
        return dao.addMemory(memory);
    }

    @Override
    public boolean deleteMemory(Memory memory) {
        return dao.deleteMemory(memory);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return dao.updateMemory(memory);
    }

    @Override
    public Memory getMemoryById(Long memoryId) {
        return dao.getMemoryById(memoryId);
    }

    @Override
    public List<Memory> getAllMemories() {
        return dao.getAllMemories();
    }
}