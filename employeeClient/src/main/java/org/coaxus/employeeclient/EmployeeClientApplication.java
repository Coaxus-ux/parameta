package org.coaxus.employeeclient;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeClientApplication {
    private DiscoveryClient discoveryClient;
    public static void main(String[] args) {
        SpringApplication.run(EmployeeClientApplication.class, args);
    }
}
