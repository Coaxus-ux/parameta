package org.coaxus.employeeclient.httpServices;

import org.coaxus.employeeclient.Exceptions.ServiceUnavailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscoveryService {
    private static final Logger logger = LoggerFactory.getLogger(DiscoveryService.class);
    private final DiscoveryClient discoveryClient;

    @Autowired
    public DiscoveryService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public ServiceInstance getFirstAvailableInstance(String serviceName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        if (instances.isEmpty()) {
            String errorMessage = "No instances found for service: " + serviceName;
            logger.warn(errorMessage);
            throw new ServiceUnavailableException(errorMessage);
        }
        return instances.get(0);
    }
}
