package com.decipline.self.dto;

public enum ResponseStatus {
    OK("Ok"),
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    TIMED_OUT("TIMED_OUT");

    private String status;

    private ResponseStatus(String status){
        this.status =status;
    }

    private String getStatus(){
        return this.status;
    }
}
