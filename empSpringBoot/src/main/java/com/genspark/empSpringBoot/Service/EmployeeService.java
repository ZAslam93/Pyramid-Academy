package com.genspark.empSpringBoot.Service;

import com.genspark.empSpringBoot.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    Employee addEmployee(Employee employee);

    Employee updateSalary(Employee emp);

    String deleteEmployee(int id);

}
