package org.coaxus.employeeserver.Controller;

import jakarta.validation.Valid;
import org.coaxus.employeeserver.Entity.Employee;
import org.coaxus.employeeserver.Services.EmployeeService;
import org.coaxus.employeeserver.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.coaxus.employeeserver.Constants.MediaTypeConstants;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping({"/{employeeId}"})
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity< Employee> postEmployee(@RequestBody @Valid Employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity.ok(employee);
    }
}
