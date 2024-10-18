package org.coaxus.employeeclient.Entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.xml.bind.annotation.*;
import lombok.*;
import org.coaxus.employeeclient.interfaces.Adult;

import java.util.Date;

@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @XmlElement(name = "Id")
    private Long id;

    @XmlElement(name = "FirstName")
    @NotEmpty(message = "First name is required")
    private String name;

    @XmlElement(name = "LastName")
    @NotEmpty(message = "Last name is required")
    private String lastName;

    @XmlElement(name = "CitizenshipType")
    @NotEmpty(message = "Citizenship type is required")
    private String citizenshipType;

    @XmlElement(name = "CitizenshipId")
    @NotEmpty(message = "Citizenship ID is required")
    private String citizenshipId;

    @XmlElement(name = "BirthDate")
    @NotNull(message = "Birth date is required")
    @Adult(message = "The employee must be at least 18 years old")
    @XmlSchemaType(name = "date")
    private Date birthDate;

    @XmlElement(name = "HireDate")
    @NotNull(message = "Hire date is required")
    @XmlSchemaType(name = "date")
    private Date hireDate;

    @XmlElement(name = "Job")
    @NotEmpty(message = "Job is required")
    private String job;

    @XmlElement(name = "Salary")
    @NotNull(message = "Salary is required")
    private Double salary;
}
