package com.vpclub.dto;

/**
 * 通用异常
 *
 * @author
 * @date 2018/2/4
 */
public class BaseException extends Exception {
    public BaseException(String message) {
        super(message);
    }
}