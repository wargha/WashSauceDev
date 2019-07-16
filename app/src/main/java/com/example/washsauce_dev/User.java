package com.example.washsauce_dev;

/****
 * This is the user object that is used starting at the sign-up page
 * to create a new customer. It is also used for sign-in authentication
 * and keeping track of which customers made certain tasks so the washer
 * and customer can know each other for outside app contact when needed.
 */

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
