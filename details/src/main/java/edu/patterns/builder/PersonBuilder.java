package edu.patterns.builder;

// Static nested Builder class
public class PersonBuilder {

    private String name;
    private int age;
    private String city;
    private String phoneNumber;
    private String email = "companydefault@company.com";
    private String occupation;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public PersonBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PersonBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonBuilder setOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public Person build() {
        Person res =  new Person();
        res.setAge(age);
        res.setEmail(email);
        res.setCity(city);
        res.setOccupation(occupation);
        res.setPhoneNumber(phoneNumber);
        res.setName(name);
        return res;
    }
}