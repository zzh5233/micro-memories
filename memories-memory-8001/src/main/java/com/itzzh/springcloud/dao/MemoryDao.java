package com.itzzh.springcloud.dao;

import com.itzzh.springcloud.entities.Memory;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.Valid;
import java.util.List;

@Mapper
public interface MemoryDao {

    public void addMemory(Memory memory);

    public List<Memory> findAllMemories();

    public Memory queryMemoryById(Long memoryId);

    public void deleteMemory(Memory memory);

    public void updateMemory(@Valid Memory memory);

}
