package com.payoneer.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class MessageTester implements MyRunnable{

    @Autowired
    private IngestServiceImpl ingestService;

    @PostConstruct
    public void startTest(){
        Thread test = new Thread(this);
        test.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);

            for(int i=0;i<20;i++){
                MessageRequest msg = new MessageRequest(i+"","m"+i);
                myLog("[MessageTester] "+msg.toString());
                ingestService.CreateMessage(msg);
            }

        } catch (InterruptedException e) {
            myLog("[MessageTester] An error occurred while Injected messages to queue : " + e.getMessage());
        }
    }
}
