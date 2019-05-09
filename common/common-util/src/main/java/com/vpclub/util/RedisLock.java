package com.vpclub.util;

import cn.vpclub.moses.utils.common.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisLock {
    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * redis 枷锁
     * setnx命令
     *
     * @param key
     * @param value = 当前时间 + 超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        //避免死锁的情况
        String currentValue = redisTemplate.opsForValue().get(key);
        if (!StringUtil.isEmpty(currentValue) &&
                Long.valueOf(currentValue) < System.currentTimeMillis()) {
            //拿到上一个锁的时间
            String preValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtil.isEmpty(preValue) && preValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }

    public void unLock(String key, String value) {
        try {

            String currValue = redisTemplate.opsForValue().get(key);
            if (!StringUtil.isEmpty(currValue) && currValue.equals(value)) {
                //删掉redis的key
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("解锁异常,{}", e.getMessage());
        }

    }

}
