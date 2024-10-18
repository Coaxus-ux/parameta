package org.coaxus.employeeserver.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Table(name = "employees")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "citizenship_type", nullable = false, length = 50)
    private String citizenshipType;

    @Column(name = "citizenship_id", nullable = false, length = 50)
    private String citizenshipId;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @Column(name = "job", nullable = false, length = 100)
    private String job;

    @Column(name = "salary", nullable = false)
    private Double salary;
}
