package com.payoneer.demo.impl;

import com.payoneer.demo.impl.cache.CacheManager;
import com.payoneer.demo.impl.queue.QueueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    QueueManager queueManager;

    ThreadPoolExecutor pool;

    @Value("${thread.pool.size}")
    private Integer threadPoolSize;

    @PostConstruct
    public void startListener(){
        pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadPoolSize);
        pool.execute(this);
    }

    @Override
    public void run() {
        Runnable task;

        LinkedBlockingQueue<MessageRequest> queue =  queueManager.getBlockingQueue();

        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        myLog("[ProcessServiceImpl] An error occurred while queue is waiting: " + e.getMessage());
                    }
                }
                task = new SMSMessageHandler(queue.poll(),cacheManager);
                pool.execute(task);
            }
        }
    }


}
