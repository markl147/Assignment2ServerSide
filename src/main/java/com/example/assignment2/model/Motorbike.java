package com.example.assignment2.model;

public class Motorbike {

//    private String motorbikeID;
    private String email;
    private String make;
    private String model;
    private String cc;

    public Motorbike(String email, String make, String model, String cc) {
//        this.motorbikeID = motorbikeID;
        this.email = email;
        this.make = make;
        this.model = model;
        this.cc = cc;
    }

//    public String getMotorbikeID() { return motorbikeID; }
//
//    public void setMotorbikeID(String motorbikeID) { this.motorbikeID = motorbikeID; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
