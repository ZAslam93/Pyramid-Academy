package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ATT implements Employer {
    @Override
    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName()  + ": ATT";
    }
}
