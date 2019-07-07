package com.latico.archetype.springcloud.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @Author: latico
 * @Date: 2019-03-10 17:20
 * @Version: 1.0
 */
@FeignClient(value = "service-provider-eureka", fallback = HelloFeignClientFailure.class) //声明调用的服务名称，自带负载均衡
public interface HelloFeignClient {

    @RequestMapping(value = "hello")
    public String hello();
}
