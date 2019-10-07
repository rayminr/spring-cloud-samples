package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sanny on 2019/10/6.
 */
@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, defaultValue = "Ribbon") String name) {
        return ribbonService.hello(name);
    }

    @GetMapping("/helloRibbon")
    public String helloRibbon() {
        return ribbonService.helloRibbon();
    }
}
