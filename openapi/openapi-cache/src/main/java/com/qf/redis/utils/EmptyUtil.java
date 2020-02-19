package com.qf.redis.utils;

/**
 * @author 徐老板
 * @date 2020/2/9   16:46
 */
public  class  EmptyUtil {
    public static boolean checkEmpty(String key){
        if (key!=null&&"".equalsIgnoreCase(key.trim())){
            return true;
        }
        return false;
    }
}
