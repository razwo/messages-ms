package com.payoneer.demo.impl.queue;

import com.payoneer.demo.impl.MessageRequest;
import com.payoneer.demo.impl.StatusMessage;

import java.util.concurrent.LinkedBlockingQueue;

public interface QueueManager {

    StatusMessage pushRecord(MessageRequest request);
    MessageRequest pullRecord();
    LinkedBlockingQueue<MessageRequest> getBlockingQueue();
}
