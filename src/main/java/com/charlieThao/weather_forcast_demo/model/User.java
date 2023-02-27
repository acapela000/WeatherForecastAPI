package com.charlieThao.weather_forcast_demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private boolean isAdmin;
    private String userName;
    private String password;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private String idNumber;

    private final List<WeatherForecast> weatherForecastList = new ArrayList<>();

    public User() {
    }

    public User(
        boolean isAdmin, String userName, String password, Date dateOfBirth,
        String email, String phoneNumber, String address, String idNumber) {
        this.isAdmin = isAdmin;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.idNumber = idNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<WeatherForecast> getWeatherForecastList() {
        return weatherForecastList;
    }
}
