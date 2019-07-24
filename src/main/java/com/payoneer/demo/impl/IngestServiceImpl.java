package com.payoneer.demo.impl;

import com.payoneer.demo.impl.cache.CacheManager;
import com.payoneer.demo.impl.queue.QueueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngestServiceImpl implements IngestService {

    @Autowired
    QueueManager queueManager;

    @Autowired
    CacheManager cacheManager;

    @Override
    public StatusMessage CreateMessage(MessageRequest request) {
        StatusMessage statusMessage = queueManager.pushRecord(request);
        cacheManager.save(request.getId(),statusMessage);
        return statusMessage;
    }
}
