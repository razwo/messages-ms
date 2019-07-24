package com.payoneer.demo.impl.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.payoneer.demo.impl.StatusMessage;
import com.payoneer.demo.impl.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisManagerMock implements CacheManager {

    static Cache<String, StatusMessage> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(20,TimeUnit.MINUTES)
            .build();

    @Override
    public void save(String id, StatusMessage statusMessage) {
        cache.put(id,statusMessage);
    }

    @Override
    public StatusMessage getStatus(String id) {
        return cache.getIfPresent(id);

    }
}
