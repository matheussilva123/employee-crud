package com.br.employee.controller;

import com.br.employee.model.Employee;
import com.br.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "employee" )
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmploy(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getEmployee(@RequestParam(name = "cpf") Integer cpf) {
        Employee employee = employeeService.getEmployeeByCpf(cpf);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteEmployee(@RequestParam(name = "cpf") Integer cpf) {
        employeeService.deleteEmployeeBy(cpf);
        return ResponseEntity.accepted().build();
    }

}
