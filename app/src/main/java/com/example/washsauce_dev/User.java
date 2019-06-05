package com.example.washsauce_dev;

import java.util.Date;

public class User {
    private String name;
    private String Location;
    private String email;
    private String phone;
    private Boolean admin;
    private int servicesRequested;
    private int servicesDone;
    private Date birthday;

    public User(String name, String location, String email, String phone, Boolean admin, int servicesRequested, int servicesDone, Date birthday) {
        this.name = name;
        Location = location;
        this.email = email;
        this.phone = phone;
        this.admin = admin;
        this.servicesRequested = servicesRequested;
        this.servicesDone = servicesDone;
        this.birthday = birthday;
    }
}
