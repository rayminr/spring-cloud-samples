package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sanny on 2019/10/7.
 */
@Service
public class FeignService {
    @Autowired
    EurekaFeignClient eurekaClientFeign;

    public String hello(String name) {
        return eurekaClientFeign.hello(name);
    }
}
