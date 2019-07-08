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

    private float calculatePrice() {
        return (float) 0;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public String getRequestorEmail() {
        return requestorEmail;
    }

    public void setRequestorEmail(String requestorEmail) {
        this.requestorEmail = requestorEmail;
    }

    public int getNumberOfLoads() {
        return numberOfLoads;
    }

    public void setNumberOfLoads(int numberOfLoads) {
        this.numberOfLoads = numberOfLoads;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

}
