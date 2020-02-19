package com.qf.redis.service;

import java.util.Map;
import java.util.Set;

/**
 * @author 徐老板
 * @date 2020/2/9   16:32
 */
public interface RedisService {
    String getRedis(String key);
    boolean setRedis(String key,String value,long expire);
    long increRedis(String key);
    boolean deleteRedis(String key);
    boolean hashRedis(String key,String field,String value);
    boolean expireRedis(String key,long seconds);

    Map<String,String> heGetAll(String key);
    Set<String> paramNames(String key);

    //这两个方法用来操作zset 其中添加方法的返回值作为判断有误的条件去使用
    boolean testExitHash(String key,Object value);
    boolean addHash(String key,Object value,Double score);
}
