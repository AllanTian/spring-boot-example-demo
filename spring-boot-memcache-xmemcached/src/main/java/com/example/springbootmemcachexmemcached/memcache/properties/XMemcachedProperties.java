package com.example.springbootmemcachexmemcached.memcache.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName: XMemcachedProperties
 * @Description: (描述) XMemcached 配置属性，读取的是 yml / properties 文件中 memcached 开头的属性
 * @Author: WHT
 * @Version: V1.0
 * @Date: 2020/10/12 11:38
 */

@Data
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "memcached")
@Component
public class XMemcachedProperties {

    /**
     * memcached服务器节点
     */
    private String servers;

    /**
     * 设置默认操作超时
     */
    private Long opTimeout;

    /**
     * nio连接池的数量
     */
    private Integer poolSize;

    /**
     * 是否开启失败模式
     */

    private Boolean failureMode;

    /**
     * 是否使用memcached缓存
     */
    private Boolean enabled;

}
