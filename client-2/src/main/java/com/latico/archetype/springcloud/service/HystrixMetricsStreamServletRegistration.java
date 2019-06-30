package com.latico.archetype.springcloud.service;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @Author: LanDingDong
 * @Date: 2019-06-30 16:16
 * @Version: 1.0
 */
@Component
public class HystrixMetricsStreamServletRegistration {
    /**
     * springboot2.0版本以上，需要添加此Servlet，
     * http://localhost:9100/actuator/hystrix.stream
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet streamServlet = new com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
