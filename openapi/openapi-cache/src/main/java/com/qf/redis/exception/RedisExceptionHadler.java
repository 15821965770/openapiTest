package com.qf.redis.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import redis.clients.jedis.exceptions.JedisDataException;

/**
 * @author 徐老板
 * @date 2020/2/9   17:15
 */
@RestControllerAdvice
public class RedisExceptionHadler {

    @ExceptionHandler(RedisException.class)
    public String handleRedisException(RedisException e){
        return "抓到异常了";
    }

    @ExceptionHandler(JedisDataException.class)
    public String handleJedisDataException(JedisDataException e){
        return "redis数据类型错误";
    }
}
