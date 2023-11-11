package com.iamneo.hotelhub.service;

import com.iamneo.hotelhub.model.Employee;
import com.iamneo.hotelhub.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    public Employee updateEmployee(Long employeeId, Employee updatedEmployeeData) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow();

        // Update fields
        existingEmployee.setName(updatedEmployeeData.getName());
        existingEmployee.setPosition(updatedEmployeeData.getPosition());
        existingEmployee.setShift(updatedEmployeeData.getShift());
        existingEmployee.setSalary(updatedEmployeeData.getSalary());

        // Save and return the updated employee
        return employeeRepository.save(existingEmployee);
    }
}
