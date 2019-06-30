package com.latico.archetype.springcloud.server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <PRE>
 *  服务注册中心
 * </PRE>
 * @Author: LanDingDong
 * @Date: 2019-03-08 14:48:58
 * @Version: 1.0
 */
@SpringBootApplication
//该注解启动一个服务注册中心提供给其他应用进行对话。
@EnableConfigServer
public class ConfigServerApplication {
    /**
     * 服务器启动
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}