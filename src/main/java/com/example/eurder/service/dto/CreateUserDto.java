package com.example.eurder.service.dto;

import com.example.eurder.domain.user.Address;
import com.example.eurder.domain.user.PhoneNumber;

public class CreateUserDto {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final PhoneNumber phoneNumber;
    private final String password;

    public CreateUserDto(String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
