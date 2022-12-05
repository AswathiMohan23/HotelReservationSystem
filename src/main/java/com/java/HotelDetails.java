package com.java;

public class HotelDetails {
    private  int rating;
   // private int id;
    private String name;
    private double weekDayRateNormal;
    private double weekDayRateReward;
    private double weekEndRateNormal;
    private double weekEndRateReward;

    public HotelDetails() {
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public HotelDetails(String name, double weekDayRateNormal, double weekDayRateReward, double weekEndRateNormal, double weekEndRateReward, int rating) {
        this.name = name;
        this.weekDayRateNormal = weekDayRateNormal;
        this.weekDayRateReward = weekDayRateReward;
        this.weekEndRateNormal = weekEndRateNormal;
        this.weekEndRateReward = weekEndRateReward;
        this.rating=rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeekDayRateNormal() {
        return weekDayRateNormal;
    }

    public void setWeekDayRateNormal(double weekDayRateNormal) {
        this.weekDayRateNormal = weekDayRateNormal;
    }

    public double getWeekDayRateReward() {
        return weekDayRateReward;
    }

    public void setWeekDayRateReward(double weekDayRateReward) {
        this.weekDayRateReward = weekDayRateReward;
    }

    public double getWeekEndRateNormal() {
        return weekEndRateNormal;
    }

    public void setWeekEndRateNormal(double weekEndRateNormal) {
        this.weekEndRateNormal = weekEndRateNormal;
    }

    public double getWeekEndRateReward() {
        return weekEndRateReward;
    }

    public void setWeekEndRateReward(double weekEndRateReward) {
        this.weekEndRateReward = weekEndRateReward;
    }
}
