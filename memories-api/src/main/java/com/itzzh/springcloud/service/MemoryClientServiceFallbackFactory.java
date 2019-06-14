package com.itzzh.springcloud.service;

import com.itzzh.springcloud.entities.Memory;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/* hystrix服务降级，先暂时关闭服务*/
@Component//  不要忘记添加，不要忘记添加,不要忘记添加
public class MemoryClientServiceFallbackFactory implements FallbackFactory<MemoryClientService> {

    @Override
    public MemoryClientService create(Throwable cause) {
        return new MemoryClientService() {
            @Override
            public boolean addMemory(Memory memory) {
                return false;
            }

            @Override
            public boolean deleteMemory(Memory memory) {
                return false;
            }

            @Override
            public boolean updateMemory(Memory memory) {
                return false;
            }

            @Override
            public Memory getMemory(Long id) {
                Memory memory = new Memory();
                memory.setMemoryId(id);
                memory.setDescription("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
                return memory;
            }

            @Override
            public List<Memory> getAllMemories() {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
