package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Verizon implements Employer {
    @Autowired
    public Verizon() {
    }
    @Override
    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ": Verizon";
    }
}
