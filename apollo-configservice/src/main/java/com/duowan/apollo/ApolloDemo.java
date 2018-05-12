package com.duowan.apollo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@EnableAutoConfiguration
public class ApolloDemo {

    @RequestMapping("hello")
    public String sayHello() {
        return "hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApolloDemo.class, args);
    }

}
