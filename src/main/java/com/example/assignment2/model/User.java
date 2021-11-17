package com.example.assignment2.model;

public class User {

    private String name;
    private String email;
    private String password;

    public User(String n,String e, String p) {
        this.name = n;
        this.email = e;
        this.password = p;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
