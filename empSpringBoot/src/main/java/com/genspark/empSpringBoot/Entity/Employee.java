package com.genspark.empSpringBoot.Entity;

import javax.persistence.*;

@Entity
@Table(name ="tbl_employees")
public class Employee {

    @Id
    @Column(name="emp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int employeeID;


    String name;
    int salary;

    public Employee() {

    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
