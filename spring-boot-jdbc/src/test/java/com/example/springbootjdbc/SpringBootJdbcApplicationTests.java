package com.example.springbootjdbc;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
class SpringBootJdbcApplicationTests {

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
