package com.itzzh.springcloud.service;

import com.itzzh.springcloud.entities.Memory;

import javax.validation.Valid;
import java.util.List;

public interface MemoryService {

    public void addMemory(Memory memory);

    public List<Memory> findAllMemories();

    public Memory queryMemoryById(Long memoryId);

    public void deleteMemory(Memory memory);

    public void updateMemory(Long memoryId, @Valid Memory memory);
}
