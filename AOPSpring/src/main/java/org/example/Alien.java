package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("#{T(Integer).parseInt('17')}")
    private int age;

    @Value("#{new String('Xarian VI')}")
    private String homePlanet;

    @Value("#{100-alien.age}")
    private int lifeRemaining;



    public void show(){

        System.out.println("Showing Alien with " +age+ " revolutions around " + homePlanet);
        System.out.println("He'll be dead in another " + lifeRemaining + " revolutions!");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }

    public int getLifeRemaining() {
        return lifeRemaining;
    }

    public void setLifeRemaining(int lifeRemaining) {
        this.lifeRemaining = lifeRemaining;
    }
}
