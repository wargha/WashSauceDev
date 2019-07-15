package com.example.washsauce_dev;

public class User {
    protected String name;
    protected String location;
    protected String email;
    protected String phone;
    protected Boolean washer;
    protected int servicesRequested;
    protected int servicesDone;
    protected boolean currentHaveTask;

    public User(String name, String location, String email, String phone) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.servicesRequested = 0;
        this.servicesDone = 0;
        this.washer = false;
        this.currentHaveTask = false;
  }

    public User() {
        this.name = "";
        this.location = "";
        this.email = "";
        this.phone = "";
        this.washer = null;
        this.servicesRequested = 0;
        this.servicesDone = 0;
        this.currentHaveTask = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
