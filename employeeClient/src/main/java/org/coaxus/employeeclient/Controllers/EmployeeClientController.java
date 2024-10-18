package org.coaxus.employeeclient.Controllers;

import jakarta.validation.Valid;
import org.coaxus.employeeclient.Entity.Employee;
import org.coaxus.employeeclient.Services.EmployeeService;
import org.coaxus.employeeclient.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeClientController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeClientController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        System.out.println("Client: Getting employees");
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(
            @PathVariable("employeeId") Long employeeId
    ) {
        return ResponseEntity.ok(employeeService.getEmployeeData(employeeId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Employee> postEmployee(@RequestBody @Valid Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployeeData(employee));
    }


}
