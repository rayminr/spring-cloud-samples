package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sanny on 2019/10/6.
 */
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(String name) {
        return restTemplate.getForObject("http://eureka-producer/hello?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "sorry " + name + ", there is a error on hello method!";
    }

    public String helloRibbon() {
        /**
         * 负载均衡器LoadBalancerClient是从eureka client获取服务注册列表信息的，并将该信息缓存了一份，
         * 在调用choose()方法时，根据负载均衡策略选择一个服务实例的信息，从而维护了负载均衡。
         * LoadBalancerClient可以不从eureka client获取注册列表信息，这时需要自己维护一份信息，参照stores配置。
         */
        ServiceInstance instance = loadBalancer.choose("eureka-producer");
        //ServiceInstance instance = loadBalancer.choose("stores");
        return instance.getHost() + ":" + instance.getPort();
    }
}
