package com.example.springbootmemcachexmemcached;


import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

/**
 * @ClassName: MemcachedTest
 * @Description: (描述)  Memcached 测试
 * @Author: WHT
 * @Version: V1.0
 * @Date: 2020/10/12 16:15
 */

@Slf4j
@Component
public class MemcachedTest extends SpringBootMemcacheXmemcachedApplicationTests {

    @Autowired
    private MemcachedClient memcachedClient;

    @Test
    public void test() throws InterruptedException, TimeoutException, MemcachedException {

        // 写入缓存 dataOne ，设置缓存时间永不过期
        boolean flag = memcachedClient.set("dataOne", 0, 1);

        // 取出缓存
        Object dataOne = memcachedClient.get("dataOne");
        log.warn("dataOne is [{}]", dataOne);

        int[] arr = {1, 2, 3, 4, 5};

        // 写入缓存 数组 arr ，并设置 3s后过期
        memcachedClient.set("arr", 3, arr);
        Object arrayOne = memcachedClient.get("arr");
        log.warn("arrayOne is [{}]", arrayOne);


        Thread.sleep(3000);
        Object arrayTwo = memcachedClient.get("arr");
        log.warn("arrayTwo is [{}]", arrayTwo);


    }
}
