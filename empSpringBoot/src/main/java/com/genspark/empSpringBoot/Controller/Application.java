package com.genspark.empSpringBoot.Controller;

import com.genspark.empSpringBoot.Entity.Employee;
import com.genspark.empSpringBoot.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Application {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home() {
        return "<HTML><h1>Spring Employee WebApp</h1></HTML>";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("employees/{empID}")
    public Employee getEmployee(@PathVariable int id) {
        return this.employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        return this.employeeService.addEmployee(emp);
    }

    @GetMapping("/employees")
    public Employee updateSalary(@RequestBody Employee emp) {
        return this.employeeService.updateSalary(emp);
    }

    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestBody int id) {
        return this.employeeService.deleteEmployee(id);
    }

}
