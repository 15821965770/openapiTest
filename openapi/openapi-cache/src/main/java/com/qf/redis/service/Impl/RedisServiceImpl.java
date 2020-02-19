package com.qf.redis.service.Impl;

import com.qf.redis.service.RedisService;
import com.qf.redis.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author 徐老板
 * @date 2020/2/9   16:35
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public String getRedis(String key) {
        if (!EmptyUtil.checkEmpty(key)) {
            return redisTemplate.opsForValue().get(key).toString();
        }
            return null;
    }

    @Override
    public boolean setRedis(String key, String value, long expire) {
        if (!EmptyUtil.checkEmpty(key)) {
            redisTemplate.opsForValue().set(key,value );
            redisTemplate.expire(key,3000 , TimeUnit.SECONDS);
            return true;
        }
        return false;
    }

    @Override
    public long increRedis(String key) {
      return   redisTemplate.opsForValue().increment(key);
    }

    @Override
    public boolean deleteRedis(String key) {
       return redisTemplate.delete(key);

    }

    @Override
    public boolean hashRedis(String key, String field, String value) {
        if (!EmptyUtil.checkEmpty(key)) {
            redisTemplate.opsForHash().put(key,field ,value );
            return true;
        }

        return false;
    }

    @Override
    public boolean expireRedis(String key, long seconds) {
        if (!EmptyUtil.checkEmpty(key)) {
          return   redisTemplate.expire(key,seconds ,TimeUnit.SECONDS );
        }
        return false;
    }

    @Override
    public Map<String, String> heGetAll(String key) {
        Map map = redisTemplate.opsForHash().entries(key);
        return  map;
    }

    @Override
    public Set<String> paramNames(String key) {
        Set members = redisTemplate.opsForSet().members(key);
        return members;
    }

    //这里是对zset的操作
    @Override
    public boolean testExitHash(String key,Object value) {
        Double score = redisTemplate.opsForZSet().score(key, value);
        return score!=null;
    }

    @Override
    public boolean addHash(String key, Object value,Double score) {
        Boolean addScore = redisTemplate.opsForZSet().add(key, value, score);
        return addScore;
    }
}
