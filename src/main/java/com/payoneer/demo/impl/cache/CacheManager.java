package com.payoneer.demo.impl.cache;

import com.payoneer.demo.impl.StatusMessage;

public interface CacheManager {

    void save(String id, StatusMessage statusMessage);
    StatusMessage getStatus(String id);
}
