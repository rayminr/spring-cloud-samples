package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by sanny on 2019/10/10.
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${conf.env:error}")
    private String profile;

    @GetMapping("/conf")
    public Mono<String> hello() {
        return Mono.justOrEmpty(profile);
    }
}
