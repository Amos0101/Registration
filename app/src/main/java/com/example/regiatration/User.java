package com.example.regiatration;


public class User {

    private String firstName;
    private String secondName;
    private String email;
    private String phone;

    // Required by Firebase
    public User() {}

    // THIS is what you are missing
    public User(String firstName, String secondName, String email, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getSecondName() { return secondName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}