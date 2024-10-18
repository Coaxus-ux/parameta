package org.coaxus.employeeclient.httpServices;

import org.coaxus.employeeclient.Entity.Employee;
import org.coaxus.employeeclient.Exceptions.ServiceUnavailableException;
import org.coaxus.employeeclient.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.*;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Service
public class HttpClientService {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientService.class);
    private final RestTemplate restTemplate;

    @Autowired
    public HttpClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        restTemplate.getMessageConverters().add(new MappingJackson2XmlHttpMessageConverter());
    }

    public Object get(String url, boolean isList) {
        try {
            logger.info("Requesting data from URL: {}", url);
            if (isList) {
                ResponseEntity<List<EmployeeDTO>> response = restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<EmployeeDTO>>() {}
                );
                return response.getBody();
            } else {
                // Obtener un solo objeto EmployeeDTO
                return restTemplate.getForObject(url, EmployeeDTO.class);
            }
        } catch (RestClientException ex) {
            String errorMessage = "Error requesting data from URL: " + url;
            logger.error(errorMessage, ex);
            throw new ServiceUnavailableException(errorMessage, ex);
        }
    }

    public Employee post(String url, Employee employee) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);
            HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, headers);

            logger.info("Posting data to URL: {}", url);
            ResponseEntity<Employee> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    Employee.class);

            return responseEntity.getBody();
        } catch (RestClientException ex) {
            String errorMessage = "Error posting data to URL: " + url;
            logger.error(errorMessage, ex);
            throw new ServiceUnavailableException(errorMessage, ex);
        }
    }

    public String buildUrl(ServiceInstance serviceInstance, String endpointPath) {
        return UriComponentsBuilder.fromUri(serviceInstance.getUri())
                .path(endpointPath)
                .build()
                .toUriString();
    }
}
