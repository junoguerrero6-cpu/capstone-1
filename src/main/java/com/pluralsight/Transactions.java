package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Transactions {
    private LocalDateTime date ;
    private LocalTime time ;
    private String description;
    private String vendor ;
    private double amount ;

    public LocalDateTime getDate(){
        return date;

    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public LocalTime getTime(){

        return time;

    }
    public void settime (localTime time) {
        this.time = time;

    }
    public String getDescription(){
        return description;

    }
    public void setDescription (String description){
        this.description = description;
    }
    public String getVendor(){
        return vendor;

    }
    public void setVendor(String vendor) {
        this.vendor = vendor;

    }
    public Double getamount(double amount){
        this.amount = amount ;

    }