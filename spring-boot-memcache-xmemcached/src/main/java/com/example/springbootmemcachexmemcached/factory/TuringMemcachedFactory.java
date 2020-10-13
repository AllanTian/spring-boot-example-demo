package com.example.springbootmemcachexmemcached.factory;


import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeoutException;

@Slf4j
@Component
public class TuringMemcachedFactory {


    @Autowired
    private MemcachedClient memcachedClient;
    private static MemcachedClient staticMemcachedClient;


    /**
     * 解决带static关键字的bean无法注入的问题
     */
    @PostConstruct
    public void init() {

        staticMemcachedClient = this.memcachedClient;
    }


    /**
     * 1分钟过期
     */
    public static final int ONE_MINUTE = 60;
    /**
     * 1小时过期
     */
    public static final int ONE_HOUR = 60 * 60;
    /**
     * 半小时过期
     */
    public static final int HALF_HOUR = 60 * 30;
    /**
     * 1天过期
     */
    public static final int ONE_DAY = 60 * 60 * 24;
    /**
     * 1周过期
     */
    public static final int ONE_WEEK = 60 * 60 * 24 * 7;
    /**
     * 1月过期
     * 最大不能超过30天
     */
    public static final int ONE_MONTH = 60 * 60 * 24 * 30;
    /**
     * 永不过期
     */
    public static final int ALWAYS = 0;


    /**
     * 缓存对象
     */
    public static void add(String key, Object obj, int time) {
        try {
            staticMemcachedClient.add(key, time, obj);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            log.warn("Memcached add Object {}", e, key);
        }
    }

    /**
     * 获取对象
     */
    public static Object get(String key) {
        Object obj = null;
        try {
            if (staticMemcachedClient != null) {
                obj = staticMemcachedClient.get(key);
            }
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            log.warn("Memcached get Object {}", e, key);
        }
        return obj;
    }

    /**
     * 删除对象
     */
    public static void delete(String key) {
        try {
            if (staticMemcachedClient != null) {
                staticMemcachedClient.delete(key);
            }
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            log.warn("Memcached delete {}", e, key);
        }
    }

    /**
     * 修改对象
     */
    public static void replace(String key, Object obj, int time) {
        try {
            staticMemcachedClient.replace(key, time, obj);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            log.warn("Memcached replace {}", e, key);
        }
    }

    /**
     * 清除所有缓存
     */
    public static void flushAll() {
        try {
            if (staticMemcachedClient != null) {
                staticMemcachedClient.flushAll();
            }

        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            log.warn("Memcached replace {}", e);
        }
    }
}
