package com.example.washsauce_dev;

public class Task {
    protected String requestDate;
    protected String acceptDate;
    protected String finishDate;
    protected String comments;
    protected String status;
    protected Boolean isFinished;
    protected String requestorEmail;
    protected int numberOfLoads;
    protected String condition;
    protected String size;
    protected String loadType;
    protected String washer;
    protected String washerNumber;

    public Task() {
        this.requestDate = "";
        this.acceptDate = "";
        this.finishDate = "";
        this.comments = "";
        this.status = "Requested";
        this.isFinished = null;
        this.requestorEmail = "";
        this.numberOfLoads = 0;
        this.condition = "";
        this.loadType = "";
        this.size = "";
        this.washer = "";
        this.washerNumber = "";
    }

    public Task(String requestDate, String comments, String size, String requestorEmail, int numberOfLoads, String condition, String loadType) {
        this.requestDate = requestDate;
        this.acceptDate = "";
        this.finishDate = "";
        this.comments = comments;
        this.status = "Requested";
        this.isFinished = false;
        this.requestorEmail = requestorEmail;
        this.numberOfLoads = numberOfLoads;
        this.condition = condition;
        this.loadType = loadType;
        this.size = size;
        this.washer = "";
        this.washerNumber = "";
    }
}
