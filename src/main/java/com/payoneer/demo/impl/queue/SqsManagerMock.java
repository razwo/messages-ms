package com.payoneer.demo.impl.queue;

import com.payoneer.demo.impl.MessageRequest;
import com.payoneer.demo.impl.StatusMessage;
import com.payoneer.demo.impl.queue.QueueManager;
import org.springframework.stereotype.Service;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class SqsManagerMock implements QueueManager {

    private final LinkedBlockingQueue<MessageRequest> blockingQueue = new LinkedBlockingQueue<>();

    @Override
    public StatusMessage pushRecord(MessageRequest request) {
        blockingQueue.add(request);
        synchronized (blockingQueue){
            blockingQueue.notify();
        }
        return StatusMessage.Accepted;
    }

    @Override
    public MessageRequest pullRecord() {
        MessageRequest request = null;
            request = blockingQueue.remove();
        return request;
    }

    @Override
    public LinkedBlockingQueue<MessageRequest> getBlockingQueue() {
        return blockingQueue;
    }


}
