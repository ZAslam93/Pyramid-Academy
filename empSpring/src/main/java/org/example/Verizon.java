package org.example;

import org.springframework.stereotype.Component;

@Component
public class Verizon implements Employer {
    @Override
    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ": Verizon";
    }
}
