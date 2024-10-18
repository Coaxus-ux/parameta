package org.coaxus.employeeclient.Services;

import org.coaxus.employeeclient.Entity.Employee;
import org.coaxus.employeeclient.dto.EmployeeDTO;
import org.coaxus.employeeclient.httpServices.DiscoveryService;
import org.coaxus.employeeclient.httpServices.HttpClientService;
import org.coaxus.employeeclient.interfaces.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private final DiscoveryService discoveryService;
    private final HttpClientService httpClientService;
    private final String employeeServiceName;
    private final String employeeEndpointPath;

    @Autowired
    public EmployeeService(
            DiscoveryService discoveryService,
            HttpClientService httpClientService,
            @Value("${employee.service.name}") String employeeServiceName,
            @Value("${employee.endpoint.path}") String employeeEndpointPath) {
        this.discoveryService = discoveryService;
        this.httpClientService = httpClientService;
        this.employeeServiceName = employeeServiceName;
        this.employeeEndpointPath = employeeEndpointPath;
    }

    @Override
    public EmployeeDTO getEmployeeData(Long employeeId) {
        ServiceInstance serviceInstance = discoveryService.getFirstAvailableInstance(employeeServiceName);
        String url = httpClientService.buildUrl(serviceInstance, employeeEndpointPath);
        return (EmployeeDTO) httpClientService.get(url + "/" + employeeId, false);
    }

    @Override
    public Employee saveEmployeeData(Employee employee) {
        ServiceInstance serviceInstance = discoveryService.getFirstAvailableInstance(employeeServiceName);
        String url = httpClientService.buildUrl(serviceInstance, employeeEndpointPath);
        Employee savedEmployee = httpClientService.post(url, employee);
        return  getEmployeeData(savedEmployee.getId());
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        ServiceInstance serviceInstance = discoveryService.getFirstAvailableInstance(employeeServiceName);
        String url = httpClientService.buildUrl(serviceInstance, employeeEndpointPath);
        return (List<EmployeeDTO>) httpClientService.get(url, true);
    }
}
