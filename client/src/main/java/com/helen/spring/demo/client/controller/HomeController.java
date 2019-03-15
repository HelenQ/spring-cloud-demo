package com.helen.spring.demo.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * client controller
 * Create by JinYang.Qin on 2019-03-04
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${config.name}")
    private String name;

    @RequestMapping("/getInfo")
    public String getInfo() {
        return this.name;
    }

    @HystrixCommand(fallbackMethod = "callBack")
    @RequestMapping("/getServerInfo")
    public String getServerInfo() {
        return this.restTemplate.exchange("http://server/name", HttpMethod.GET, null, String.class).getBody();
    }
    private String callBack() {
        return "none";
    }

}
