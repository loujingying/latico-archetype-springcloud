package com.latico.archetype.springcloud.service.controller;

import com.latico.archetype.springcloud.service.api.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RequestMapping(value = "client")
public class HelloFeignController {
    @Value("${server.port}")
    String serverPort;
    @Autowired
    private HelloFeignClient helloFeignClient;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "端口" + serverPort + "Feign服务调用者结果:" + helloFeignClient.hello();
    }
}