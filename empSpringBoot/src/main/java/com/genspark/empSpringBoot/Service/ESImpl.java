package com.genspark.empSpringBoot.Service;

import com.genspark.empSpringBoot.Dao.EmployeeDao;
import com.genspark.empSpringBoot.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ESImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return this.employeeDao.getById(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    public Employee updateSalary(Employee emp) {
        return this.employeeDao.save(emp);
    }

    @Override
    public String deleteEmployee(int id) {
        this.employeeDao.deleteById(id);
        return "Employee " + id + " deleted";
    }
}
