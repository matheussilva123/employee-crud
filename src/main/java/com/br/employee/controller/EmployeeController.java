package com.br.employee.controller;

import com.br.employee.model.Employee;
import com.br.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "employee" )
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmploy(employee);
        return ResponseEntity.ok().build();
    }

}
