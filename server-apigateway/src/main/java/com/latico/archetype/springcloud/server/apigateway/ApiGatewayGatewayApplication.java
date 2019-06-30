package com.latico.archetype.springcloud.server.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <PRE>
 *  程序入口
 * </PRE>
 * @Author: LanDingDong
 * @Date: 2019-03-13 22:03:56
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayGatewayApplication {

    /**
     * 服务器启动
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayGatewayApplication.class, args);
    }

}
