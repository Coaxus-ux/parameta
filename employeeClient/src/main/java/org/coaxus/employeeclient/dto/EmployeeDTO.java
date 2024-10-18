package org.coaxus.employeeclient.dto;

import lombok.*;
import org.coaxus.employeeclient.Entity.Employee;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO extends Employee {
    private String timeInCompany;
    private String employeeAge;
}