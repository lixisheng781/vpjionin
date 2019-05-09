package com.vpclub.result;

import java.util.Objects;

/**
 * 响应状态类
 *
 * @author vpclub
 */
public class Result<T> {
    /***
     * 状态码
     */
    private int code;
    /***
     * 状态描述
     */
    private String msg;
    /***
     * 响应结果内容
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result = (Result) o;
        return this.code == result.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
