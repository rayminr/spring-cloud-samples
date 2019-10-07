package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Created by sanny on 2019/10/7.
 */
@Component
public class HelloHystrix implements EurekaFeignClient {

    @Override
    public String hello(String name) {
        return "sorry " + name + ", there is a error on hello method!";
    }
}
