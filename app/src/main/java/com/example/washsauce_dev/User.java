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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getWasher() {
        return washer;
    }

    public void setWasher(Boolean washer) {
        this.washer = washer;
    }

    public int getServicesRequested() {
        return servicesRequested;
    }

    public void setServicesRequested(int servicesRequested) {
        this.servicesRequested = servicesRequested;
    }

    public int getServicesDone() {
        return servicesDone;
    }

    public void setServicesDone(int servicesDone) {
        this.servicesDone = servicesDone;
    }
}
