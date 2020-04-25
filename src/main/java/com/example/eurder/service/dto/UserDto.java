package com.example.eurder.service.dto;

import com.example.eurder.domain.Address;
import com.example.eurder.domain.PhoneNumber;
import com.example.eurder.domain.Role;

public class UserDto {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final PhoneNumber phoneNumber;
    private final String password;
    private final Role role;

    public UserDto(long id, String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
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

    public Role getRole() {
        return role;
    }
}
