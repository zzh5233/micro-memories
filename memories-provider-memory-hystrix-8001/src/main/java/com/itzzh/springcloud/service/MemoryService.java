package com.itzzh.springcloud.service;

import com.itzzh.springcloud.entities.Memory;

import javax.validation.Valid;
import java.util.List;

public interface MemoryService {

    public boolean addMemory(Memory memory);

    public boolean deleteMemory(Memory memory);

    public boolean updateMemory(Memory memory);

    public Memory getMemoryById(Long memoryId);

    public List<Memory> getAllMemories();
}
