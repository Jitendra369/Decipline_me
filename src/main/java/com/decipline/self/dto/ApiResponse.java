package com.decipline.self.dto;

public final class ApiResponse<T> {

    private String message;

    private ResponseStatus responseStatus;

    private String statusCode;

    private T data;

    public ApiResponse(String message, ResponseStatus responseStatus, String statusCode, T data) {
        super();
        this.message = message;
        this.responseStatus = responseStatus;
        this.statusCode = statusCode;
        this.data = data;
    }
    private static class  Builder<T>{
        private String message;

        private ResponseStatus responseStatus;
        private String statusCode;
        private T data;
        
    }

    public String getMessage() {
        return message;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public T getData() {
        return data;
    }
}
