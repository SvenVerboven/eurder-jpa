package com.example.eurder.service.dto;

import com.example.eurder.domain.user.Address;
import com.example.eurder.domain.user.PhoneNumber;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class CreateUserDto {

    @NotEmpty(message = "first name can't be empty")
    private final String firstName;
    @NotEmpty(message = "last name can't be empty")
    private final String lastName;
    @NotEmpty(message = "email can't be empty")
    private final String email;
    @Valid
    private final Address address;
    @Valid
    private final PhoneNumber phoneNumber;
    @NotEmpty(message = "password can't be empty")
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
