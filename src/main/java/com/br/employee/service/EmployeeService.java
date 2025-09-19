package com.br.employee.service;

import com.br.employee.model.Employee;
import com.br.employee.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public void saveEmploy(Employee employee) {
        employeeRepository.save(employee);

    }

}
