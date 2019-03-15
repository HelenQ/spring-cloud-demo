package com.helen.spring.demo.server.controller;

import com.helen.spring.demo.server.dao.UserRepository;
import com.helen.spring.demo.server.dao.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by JinYang.Qin on 2019-03-05
 */
@RestController
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserRepository userRepository;

    @Value("${config.name}")
    private String name;

    @RequestMapping("/name")
    public String getName() {
        return name;
    }

    @RequestMapping("/listUser")
    public List<String> home() {
        List<User> users = (List<User>) userRepository.findAll();
        List<String> us = new ArrayList<>();
        users.forEach((v)->{
            us.add(v.getName());
            logger.info("homeController-listUser:{}", v.getName());
        });
        return us;
    }


}
