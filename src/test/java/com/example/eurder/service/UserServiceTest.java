package com.example.eurder.service;

import com.example.eurder.domain.Address;
import com.example.eurder.domain.PhoneNumber;
import com.example.eurder.domain.Role;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void createUser() {
        // Given
        Address address = new Address("straatje", "30", "3290", "Schaffen", "België");
        PhoneNumber phoneNumber = new PhoneNumber("032", "459653254");
        CreateUserDto createUserDto = new CreateUserDto("Sven", "Verboven", "sven@gmail.com", address, phoneNumber, "asecret");
        // When
        UserDto userDto = userService.createUser(createUserDto);
        // Then
        assertThat(userDto).isNotNull();
        assertThat(userDto.getId()).isNotNull();
        assertThat(userDto.getFirstName()).isEqualTo(createUserDto.getFirstName());
        assertThat(userDto.getLastName()).isEqualTo(createUserDto.getLastName());
        assertThat(userDto.getEmail()).isEqualTo(createUserDto.getEmail());
        assertThat(userDto.getAddress()).isEqualTo(createUserDto.getAddress());
        assertThat(userDto.getPhoneNumber()).isEqualTo(createUserDto.getPhoneNumber());
        assertThat(userDto.getRole()).isEqualTo(Role.CUSTOMER);
    }
}