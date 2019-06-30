package com.latico.archetype.springcloud.service.api;

import org.springframework.stereotype.Component;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @Author: LanDingDong
 * @Date: 2019-03-17 0:45
 * @Version: 1.0
 */
@Component
public class HelloFeignClientFailure implements HelloFeignClient {
    @Override
    public String hello() {
        System.out.println("hello world service is not available !");
        return "hello world service is not available !";
    }
}
