package com.qf.redis.controller;

import com.qf.redis.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * @author 徐老板
 * @date 2020/2/9   16:32
 */
@RestController
@RequestMapping("/cache")
public class RedisController {
    @Resource
    RedisService redisService;

    @RequestMapping("/save2cache")
    private boolean setRedis(String key,String value,long expire){
        System.out.println("key="+key+"value="+value+"expire="+expire);
        return redisService.setRedis(key,value ,expire );

    }
//
//    @RequestMapping(value = "/save2cache" ,produces = "MediaType.APPLICATION_JSON_UTF8")
//    private void setRedis(String key,String value,long expire){
//        redisService.setRedis(key,value ,expire );
//    }

    @RequestMapping("/getcache/{key}")
    private String getRedis(@PathVariable String key){
       return redisService.getRedis(key);
    }

    @RequestMapping("/delcache/{key}")
    private boolean delRedis(@PathVariable String key){
       return redisService.deleteRedis(key);
    }

    @RequestMapping("/incrcache/{key}")
    private long incrRedis(@PathVariable String key){
       return redisService.increRedis(key);
    }

    @RequestMapping("/hashcache/{key}/{field}/{value}")
    private boolean hashRedis(@PathVariable String key,@PathVariable String field,@PathVariable String value){
      return   redisService.hashRedis(key,field ,value );
    }

    @RequestMapping("/expirecache/{key}/{seconds}")
    private boolean expireRedis(@PathVariable String key,@PathVariable long seconds){
        return redisService.expireRedis(key,seconds );
    }

    @RequestMapping("/hegetall/{key}")
    public Map<String, String> heGetAll(@PathVariable String key) {

        return  redisService.heGetAll(key);
    }

    @Resource
    RedisTemplate redisTemplate;
    @RequestMapping("/sethash")
    public boolean setHash( String key, String hashKey,  String value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        return  true;
    }

    @RequestMapping("/gethash/{key}")
    public Map<String,String> getHash(@PathVariable String key){
        Map entries = redisTemplate.opsForHash().entries(key);
        return entries;
    }

    @RequestMapping("/paramnames/{key}")
    public Set<String> paramNames(@PathVariable String key) {
        return redisService.paramNames(key);
    }

    //下面两个是对zset的操作
    @RequestMapping("/testexithash/{key}/{value}")
    public boolean testExitHash(@PathVariable String key,@PathVariable Object value) {
        Double score = redisTemplate.opsForZSet().score(key, value);
        return score!=null;
    }

    @RequestMapping("/addhash/{key}/{value}/{score}")
    public boolean addHash(@PathVariable String key, @PathVariable Object value,@PathVariable Double score) {
        Boolean addScore = redisTemplate.opsForZSet().add(key, value, score);
        return addScore;
    }

}
