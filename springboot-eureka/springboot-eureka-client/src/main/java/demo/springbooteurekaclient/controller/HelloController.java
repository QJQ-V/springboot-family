package demo.springbooteurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    private DiscoveryClient client;

    @GetMapping(value = "/hello")
    public String index() {
        ServiceInstance serviceInstance = client.getLocalServiceInstance();
        logger.info("/hello,host:" + serviceInstance.getHost() + ",service_id:" + serviceInstance.getServiceId());

        return "Hello World!";
    }
}
