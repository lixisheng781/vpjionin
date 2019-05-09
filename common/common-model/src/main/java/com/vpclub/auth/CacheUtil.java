package com.vpclub.auth;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;



@Slf4j
@Component
public class CacheUtil {

    private  static CacheManager cacheManager;

    @Resource
    void setCacheManager(CacheManager cacheManager) {
        CacheUtil.cacheManager = cacheManager;
        log.info("CacheUtil is init");
    }

    private static CacheManager getCacheManager() {
        if (cacheManager == null){
            throw new IllegalStateException("cacheManager is null !!!");
        }
        return cacheManager;
    }


    public static Cache getCache(String namespace){
        if (StringUtils.isNotBlank(namespace)){
            Cache cache = getCacheManager().getCache(namespace);
            if (cache != null){
                return cache;
            }
        }
        throw new IllegalStateException("[namespace :"+namespace+"]  get the  cache is null !!!");
    }


    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
    }


    public static <V> V get(String namespace, Object key) {
        Cache  cache =   getCache(namespace);
        Cache.ValueWrapper valueWrapper = cache.get(key);
        if (valueWrapper != null && valueWrapper.get() != null){
            return (V)valueWrapper.get();
        }
        return null;
    }

    public static void put(String namespace, Object key, Object value) {
        Cache  cache =   getCache(namespace);
        if (key != null ){
            cache.put(key,value);
        }
    }

    public static void evict(String namespace, Object key) {
        Cache  cache = getCache(namespace);
        if (key != null){
            cache.evict(key);
        }
    }


}

