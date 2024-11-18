package com.testproject.rest.Exceptions;

public class ErorrHadler {
    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErorrHadler() {
    }

    public ErorrHadler(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
