package com.qf.redis.exception;

/**
 * @author 徐老板
 * @date 2020/2/9   17:12
 */

public class RedisException extends Exception {
    private int code;
    private String msg;

    public RedisException(String message, int code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public RedisException() {
    }

    public RedisException(String msg) {
        this.msg = msg;
    }


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

    @Override
    public String toString() {
        return "RedisException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
