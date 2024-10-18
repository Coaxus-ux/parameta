package org.coaxus.employeeserver.Services;


import org.coaxus.employeeserver.Entity.Employee;
import org.coaxus.employeeserver.Repository.EmployeeRepository;
import org.coaxus.employeeserver.Utils.DateUtils;
import org.coaxus.employeeserver.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return mapToEmployeeDTO(employee);
    }
    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::mapToEmployeeDTO)
                .toList();
    }
    private EmployeeDTO mapToEmployeeDTO(Employee employee) {
        LocalDate today = LocalDate.now();
        LocalDate hireDate = DateUtils.convertToLocalDate(employee.getHireDate());
        LocalDate birthDate = DateUtils.convertToLocalDate(employee.getBirthDate());
        String timeInCompany = DateUtils.calculatePeriod(hireDate, today);
        String employeeAge = DateUtils.calculatePeriod(birthDate, today);
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getLastName(),
                employee.getCitizenshipType(),
                employee.getCitizenshipId(),
                employee.getBirthDate(),
                employee.getHireDate(),
                employee.getJob(),
                employee.getSalary(),
                timeInCompany,
                employeeAge
        );
    }
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
