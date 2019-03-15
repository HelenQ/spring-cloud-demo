package com.helen.spring.demo.server;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.ProbabilityBasedSampler;
import org.springframework.cloud.sleuth.sampler.SamplerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * demo server
 * Create by JinYang.Qin on 2019-03-03
 */
@SpringBootApplication
@EnableEurekaClient
@EnableWebMvc
@RestController
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public Sampler defaultSampler() {
        SamplerProperties properties = new SamplerProperties();
        properties.setProbability(0.5F);
        return new ProbabilityBasedSampler(properties);
    }

}
