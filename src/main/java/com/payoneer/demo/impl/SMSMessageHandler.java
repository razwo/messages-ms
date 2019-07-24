package com.payoneer.demo.impl;

import com.payoneer.demo.impl.cache.CacheManager;
import java.util.Random;

public class SMSMessageHandler implements MyRunnable {

    Random rand = new Random();

    MessageRequest messageRequest;

    CacheManager cacheManager;

    public SMSMessageHandler(MessageRequest messageRequest,CacheManager cacheManager){
        this.messageRequest=messageRequest;
        this.cacheManager=cacheManager;
    }

    @Override
    public void run() {
        myLog("[SMSMessageHandler] Start process request: " + messageRequest.toString());
        cacheManager.save(messageRequest.getId(),StatusMessage.Processing);
        try {
            long sec = (long)(rand.nextInt(9) * 1000) + 1000;
//            sec = 1000;
            myLog("[SMSMessageHandler] Sleep for " + sec + " millis");
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            cacheManager.save(messageRequest.getId(),StatusMessage.Error);
            myLog("[SMSMessageHandler] An error occurred while process request: " + messageRequest.toString() +
                    "\n"+ e.getMessage());
        }
        cacheManager.save(messageRequest.getId(),StatusMessage.Complete);
        myLog("[SMSMessageHandler] End process request: " + messageRequest.toString());
    }
}
