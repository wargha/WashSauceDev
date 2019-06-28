package com.example.washsauce_dev;

import java.util.Date;

public class User {
    public String name;
    private String location;
    private String email;
    private String phone;
    private Boolean admin;
    private int servicesRequested;
    private int servicesDone;
    private Date birthday;

    public User(String name, String location, String email) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.servicesRequested = 0;
        this.servicesDone = 0;
  }

    public User() {
        this.name = "";
        this.location = "";
        this.email = "";
//        this.phone = "";
//        this.admin = null;
//        this.servicesRequested = 0;
//        this.servicesDone = 0;
//        this.birthday = null;
    }

}
