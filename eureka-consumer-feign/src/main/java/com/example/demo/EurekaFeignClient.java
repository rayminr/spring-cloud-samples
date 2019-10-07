package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sanny on 2019/10/7.
 */
@Component
@FeignClient(value = "eureka-producer",configuration = FeignConfig.class,fallback = HelloHystrix.class)
public interface EurekaFeignClient {

    /**
     * Feign中只能用RequestMapping方式传参数
     */
    //@GetMapping(value = "/hello")
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}
