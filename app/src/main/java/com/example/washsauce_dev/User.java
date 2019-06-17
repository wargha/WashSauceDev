package com.example.washsauce_dev;

import java.util.Date;

public class User {
    private String name;
    private String location;
    private String email;
    private String phone;
    private Boolean admin;
    private int servicesRequested;
    private int servicesDone;
    private Date birthday;

    public User(String name, String location, String email, String phone, Boolean admin, int servicesRequested, int servicesDone, Date birthday) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.admin = admin;
        this.servicesRequested = servicesRequested;
        this.servicesDone = servicesDone;
        this.birthday = birthday;
    }

    public User() {
        this.name = "";
        this.location = "";
        this.email = "";
        this.phone = "";
        this.admin = null;
        this.servicesRequested = 0;
        this.servicesDone = 0;
        this.birthday = null;
    }
}
