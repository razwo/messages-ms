package com.payoneer.demo.impl;

public enum StatusMessage {
    Accepted(0),
    Processing(1),
    Error(2),
    Complete(3),
    NotFound(4);

    private int status;

    StatusMessage(int status) {
        this.status = status;
    }

    public int getStatusCode() { return this.status; }
    }
