package com.vpclub.admin.utils;

/**
 * Redis所有Keys
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 07-18 19:51
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "mapper.sys:config:" + key;
    }
}
