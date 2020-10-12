package com.example.springbootmemcachexmemcached;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @ClassName: SpringBootMemcacheXmemcachedApplicationTests
 * @Description: (描述) SpringBootTest 测试基础类，其他类继承此类
 * @Author: WHT
 * @Version: V1.0
 * @Date: 2020/10/12 15:55
 */

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
class SpringBootMemcacheXmemcachedApplicationTests {

    private Long time;

    @Test
    void contextLoads() {

    }

    @Before
    public void setUp() {
        this.time = System.currentTimeMillis();
        log.info("==> 测试开始执行 <==");
    }

    @After
    public void tearDown() {
        log.info("==> 测试执行完成，耗时：{} ms <==", System.currentTimeMillis() - this.time);
    }

}
