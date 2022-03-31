package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Employee {
    @Autowired
    @Value("1")
    private String id;
    @Value("John")
    private String name;
    private Employer company;
    private Address add;

    public Employee() {
    }

    public Employee(String id, String name, Employer company, Address add) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.add = add;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

    public Employer getCompany() {
        return company;
    }

    public void setCompany(Employer company) {
        this.company = company;
    }

    public void work() {
        System.out.println("Employee number " + this.getId() + " working...");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", add=" + add +
                '}';
    }
}
