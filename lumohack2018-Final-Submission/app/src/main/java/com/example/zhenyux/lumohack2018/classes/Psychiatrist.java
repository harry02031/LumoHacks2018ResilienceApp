package com.example.zhenyux.lumohack2018.classes;

public class Psychiatrist {
    public String name;
    public String location;
    public String phoneNumber;
    public String distance;
    public String rating;

    public Psychiatrist(String mName,String mPhoneNumber,String mLocation,String mDistance,String mRating){
        name = mName;
        location = mLocation;
        phoneNumber = mPhoneNumber;
        distance = mDistance;
        rating = mRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
