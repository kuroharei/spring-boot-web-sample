package com.eoast.springboot.entities;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    String id;
    String phoneNumbers;
    String password;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(String id, String phoneNumbers, String password) {
        super();
        this.id = id;
        this.phoneNumbers = phoneNumbers;
        this.password = password;
    }

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
