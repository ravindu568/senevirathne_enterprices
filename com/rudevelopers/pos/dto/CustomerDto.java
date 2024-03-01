package com.rudevelopers.pos.dto;

public class CustomerDto {

    private String name;
    private String email;

    public CustomerDto() {
    }

    public CustomerDto(String name, String email, String contact, double salary) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.salary = salary;
    }

    private String contact;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
