package com.vpclub.redis;


import com.alibaba.fastjson.JSON;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil
{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private HashOperations<String, String, Object> hashOperations;
    @Autowired
    private ListOperations<String, Object> listOperations;
    @Autowired
    private SetOperations<String, Object> setOperations;
    @Autowired
    private ZSetOperations<String, Object> zSetOperations;
    public static final long DEFAULT_EXPIRE = 86400L;
    public static final long NOT_EXPIRE = -1L;

    public void set(String key, Object value, long expire)
    {
        this.valueOperations.set(key, toJson(value));
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value)
    {
        set(key, value, 86400L);
    }

    public <T> T get(String key, Class<T> clazz, long expire)
    {
        String value = (String)this.valueOperations.get(key);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz)
    {
        return (T)get(key, clazz, -1L);
    }

    public String get(String key, long expire)
    {
        String value = (String)this.valueOperations.get(key);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key)
    {
        return get(key, -1L);
    }

    public void delete(String key)
    {
        this.redisTemplate.delete(key);
    }

    private String toJson(Object object)
    {
        if (((object instanceof Integer)) || ((object instanceof Long)) || ((object instanceof Float)) || ((object instanceof Double)) || ((object instanceof Boolean)) || ((object instanceof String))) {
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    private <T> T fromJson(String json, Class<T> clazz)
    {
        return (T)JSON.parseObject(json, clazz);
    }
}

