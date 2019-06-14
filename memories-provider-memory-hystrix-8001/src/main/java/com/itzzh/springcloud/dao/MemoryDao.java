package com.itzzh.springcloud.dao;

import com.itzzh.springcloud.entities.Memory;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.Valid;
import java.util.List;

@Mapper
public interface MemoryDao {

    public boolean addMemory(Memory memory);

    public boolean deleteMemory(Memory memory);

    public boolean updateMemory(Memory memory);

    public Memory getMemoryById(Long memoryId);

    public List<Memory> getAllMemories();

}
