package com.karina.hr.rest;

import com.karina.hr.model.Employee;
import com.karina.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@RestController()
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        return employeeService.findAllEmploees() ;

    }

    @GetMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@PathVariable(value = "id") Long employeeId) {
        return employeeService.findEmployeeByID(employeeId);
    }

    @PostMapping(path = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);
    }

    @DeleteMapping(path = "/employees/{id}")
    public void removeEmployee(@PathVariable(value = "id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

   @PutMapping(path = "/employees")
    public Employee editEmployee(@RequestBody Employee employee){
        return employeeService.editEmployee(employee);
   }
}
