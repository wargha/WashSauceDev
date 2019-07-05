package com.example.washsauce_dev;

public class Task {
    protected Date requestDate;
    protected Date acceptDate;
    protected Date finishDate;
    protected String comments;
    protected String status;
    protected Boolean isFinished;
    protected String requestorEmail;
    protected int numberOfLoads;
    protected String condition;
    protected String size;
    protected String loadType;
    protected float price;

    public Task(Date requestDate, String comments, String size, String requestorEmail, int numberOfLoads, String condition, String loadType) {
        this.requestDate = requestDate;
        this.acceptDate = null;
        this.finishDate = null;
        this.comments = comments;
        this.status = "Requested";
        this.isFinished = false;
        this.requestorEmail = requestorEmail;
        this.numberOfLoads = numberOfLoads;
        this.condition = condition;
        this.loadType = loadType;
        this.size = size;
        this.price = calculatePrice();
    }

    private float calculatePrice() {
        return (float) 0;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
