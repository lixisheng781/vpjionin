package com.vpclub.exception;

public class BussinessException extends RuntimeException{

    private String errorCode;

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(Throwable cause) {
        super(cause);
    }

    public BussinessException(String errorCode, String message) {
        this(message);
        this.errorCode = errorCode;
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BussinessException(String errorCode, String message, Throwable cause) {
        this(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

}
