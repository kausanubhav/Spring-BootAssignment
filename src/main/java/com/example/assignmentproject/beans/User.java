package com.example.assignmentproject.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "pincode")
    int pincode;

    @Column(name = "state")
    String state;

    @Column(name = "row_creation_timestamp")
    LocalDateTime row_creation_timestamp;

    //constructor
    public User(){}
    public User(int id, String name, String address, int pincode, String state, LocalDateTime timestamp) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.pincode = pincode;
        this.state = state;
        this.row_creation_timestamp = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getRow_creation_timestamp() {
        return row_creation_timestamp;
    }

    public void setRow_creation_timestamp(LocalDateTime row_creation_timestamp) {
        this.row_creation_timestamp =
                row_creation_timestamp;
    }


}
