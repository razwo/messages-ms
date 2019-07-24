package com.payoneer.demo.impl;

import java.io.Serializable;

public class MessageRequest implements Serializable {
    private String id;
    private String message;

    public MessageRequest(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
