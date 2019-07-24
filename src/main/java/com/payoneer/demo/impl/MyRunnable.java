package com.payoneer.demo.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface MyRunnable extends Runnable {

    default void myLog(String msg){
        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(time +" ["+ Thread.currentThread().getName()+"] : "+msg);
    }
}
