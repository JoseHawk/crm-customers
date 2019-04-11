package com.joselara.crmcustomers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CrmCustomersApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmCustomersApplication.class, args);
    }
}
