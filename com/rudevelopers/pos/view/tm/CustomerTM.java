package com.rudevelopers.pos.view.tm;

import javafx.scene.control.Button;

public class CustomerTM {

    private int id;
    private String name;
    private String email;
    private String contact;

    private double salary;
    private Button deleteBtn;

    public CustomerTM() {
    }
    public CustomerTM(int id, String name, String email, String contact, double salary, Button deleteBtn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.salary = salary;
        this.deleteBtn = deleteBtn;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }




}
