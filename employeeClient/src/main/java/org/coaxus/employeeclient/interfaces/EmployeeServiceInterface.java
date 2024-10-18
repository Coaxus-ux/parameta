package org.coaxus.employeeclient.interfaces;

import org.coaxus.employeeclient.Entity.Employee;
import org.coaxus.employeeclient.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee getEmployeeData(Long employeeId);
    Employee saveEmployeeData(Employee employee);
    List<EmployeeDTO> getEmployees();
}
