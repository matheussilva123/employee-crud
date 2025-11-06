package com.br.employee.service;

import com.br.employee.exception.UserIsAlreadyExistsException;
import com.br.employee.exception.UserNotFoundException;
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
        final var employee1 = employeeRepository.findByCpf(employee.getCpf());
        if(employee1 != null ) {
            throw new UserIsAlreadyExistsException("Employee is already exists.");
        }

        employeeRepository.save(employee);

    }

    public Employee getEmployeeByCpf(Integer cpf) {
        final var employee1 = employeeRepository.findByCpf(cpf);
        if(employee1 == null) {
            throw new UserNotFoundException("User not found");
        }
        return employee1;
    }

    public void deleteEmployeeBy(Integer cpf) {
        final var employee1 = employeeRepository.findByCpf(cpf);
        if(employee1 == null) {
            throw new UserNotFoundException("User not found");
        }
        employeeRepository.delete(employee1);
    }

}
