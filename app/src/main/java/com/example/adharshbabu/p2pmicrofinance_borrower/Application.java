package com.example.adharshbabu.p2pmicrofinance_borrower;

import java.util.Map;

public class Application {
    private String borrowerName;
    private Map<String, Double> lenders;
    private String borrowerLocation;
    private double amountRequested;
    private double amountRecieved;
    private double amountReturned;
    private String description;

    public Application(String borrowerName, String borrowerLocation, double amountRequested) {
        this.borrowerName = borrowerName;
        this.borrowerLocation = borrowerLocation;
        this.amountRequested = amountRequested;
    }

    public double getAmountReturned() {
        return amountReturned;
    }

    public void setAmountReturned(double amountReturned) {
        this.amountReturned = amountReturned;
    }

    public void addAmountReturned(double paymentSize) {
        amountReturned += paymentSize;
    }

    public double getAmountRecieved() {
        return amountRecieved;
    }

    public void setAmountRecieved(double amountRecieved) {
        this.amountRecieved = amountRecieved;
    }

    public void addAmountRecieved(double paymentSize) {
        amountRecieved += paymentSize;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerlocation() {
        return borrowerLocation;
    }

    public void setBorrowerlocation(String borrowerlocation) {
        this.borrowerLocation = borrowerlocation;
    }

    public double getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(double amountRequested) {
        this.amountRequested = amountRequested;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addLender(String lenderUID, double paymentSize) {
        lenders.put(lenderUID, paymentSize);
        this.addAmountRecieved(paymentSize);
    }

    public Map getLenders() {
        return lenders;
    }

}