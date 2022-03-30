package org.example;

import org.springframework.beans.factory.annotation.Value;

public class Address {
    @Value("USA")
    private String country;
    @Value("New York")
    private String state;
    @Value("New York City")
    private String city;
    @Value("10016")
    private String zipcode;

    public Address() {
    }

    public Address(String country, String state, String city, String zipcode) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
