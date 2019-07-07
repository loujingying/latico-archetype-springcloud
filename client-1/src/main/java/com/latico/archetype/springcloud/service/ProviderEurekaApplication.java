package com.latico.archetype.springcloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <PRE>
 *  程序启动入口类
 * </PRE>
 * @Author: latico
 * @Date: 2019-03-18 20:40:19
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderEurekaApplication {

    /**
     * 服务器启动
     *
     * @param args
     * @author <B><a href="mailto:latico@gdlaticosoft.com"> 蓝鼎栋 </a></B>
     */
    public static void main(String[] args) {
        SpringApplication.run(ProviderEurekaApplication.class, args);
    }

}
