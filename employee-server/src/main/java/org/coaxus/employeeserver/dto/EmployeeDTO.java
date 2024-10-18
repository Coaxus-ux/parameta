package org.coaxus.employeeserver.dto;

import lombok.*;
import org.coaxus.employeeserver.Entity.Employee;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO extends Employee {
    private String timeInCompany;
    private String employeeAge;

    public EmployeeDTO(Long id, String name, String lastName, String citizenshipType, String citizenshipId,
                       Date birthDate, Date hireDate, String job, Double salary, String timeInCompany, String employeeAge) {
        super(id, name, lastName, citizenshipType, citizenshipId, birthDate, hireDate, job, salary);
        this.timeInCompany = timeInCompany;
        this.employeeAge = employeeAge;
    }
}
