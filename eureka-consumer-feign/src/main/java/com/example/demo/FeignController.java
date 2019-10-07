package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sanny on 2019/10/7.
 */
@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "name", required = false) String name) {
        return feignService.hello(name);
    }
}
