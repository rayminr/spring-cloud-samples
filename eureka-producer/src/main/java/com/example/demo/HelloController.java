package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sanny on 2019/10/6.
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "Spring Cloud", required = false) String name) {
        return "Hello " + name + ", I am from port:" + port;
    }
}
