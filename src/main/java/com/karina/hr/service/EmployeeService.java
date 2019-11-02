package com.karina.hr.service;

import com.karina.hr.model.Employee;
import com.karina.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAllEmploees(){
       List<Employee> employeeList= employeeRepository.findAll();
       return employeeList;
    }

    public Employee findEmployeeByID(Long employeeID){
        Employee employee=employeeRepository.findById(employeeID).get();
        return employee;
    }

    public Employee insertEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }
    public Employee editEmployee(Employee employee){
        return employeeRepository.save(employee);

    }
}
