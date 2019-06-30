package com.latico.archetype.springcloud.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${server.port}")
    String serverPort;
    /**
     * 读取配置文件的getHelloConfigKey配置项，
     * 浏览器访问:http://localhost:9200/getHelloConfigKey
     * 1、如果配置中心是git，流程：转向注册中心，注册中心调用配置中心，配置中心调用git服务器中的文件，一路返回来到这里注入配置
     * 2、如果配置中心是它本地文件：流程：转向注册中心，注册中心调用配置中心，配置中心调用本地文件，一路返回来到这里注入配置
     */
    @Value("${getHelloConfigKey}")
    String getHelloConfigKey;

    @Value("${getHelloConfigKeyYaml}")
    String getHelloConfigKeyYaml;

    @RequestMapping(value = "getHelloConfigKey")
    public String getHelloConfigKey() {
        return "端口:" + serverPort + " 返回:" + getHelloConfigKey;
    }

    @RequestMapping(value = "getHelloConfigKeyYaml")
    public String getHelloConfigKeyYaml() {
        return "端口:" + serverPort + " 返回:" + getHelloConfigKeyYaml;
    }
}