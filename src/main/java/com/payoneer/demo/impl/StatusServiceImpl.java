package com.payoneer.demo.impl;

import com.payoneer.demo.impl.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    CacheManager cacheManager;

    @Override
    public StatusMessage getStatus(String messageId) {
        StatusMessage statusMessage = cacheManager.getStatus(messageId);
        return statusMessage == null ? StatusMessage.NotFound : statusMessage;
    }
}
