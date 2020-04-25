package com.example.eurder.service;

import com.example.eurder.domain.exceptions.UserDoesNotExistException;
import com.example.eurder.domain.user.*;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

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

    @Test
    void getAllUsers_givenTwoUsers_thenReturnCollectionWithTwoUsers() {
        // Given
        userRepository.save(new User("Sven", "Verboven", "sven@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032","456986521"),
                "asecret"));
        userRepository.save(new User("Melissa", "Morren", "melissa@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032","458753216"),
                "tralalala"));
        // When
        Collection<UserDto> users = userService.getAllUsers();
        // Then
        assertThat(users).hasSize(2);
    }

    @Test
    void getUser_givenUserId_thenReturnUser() {
        // Given
        User user = userRepository.save(new User("Sven", "Verboven", "sven@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032","456986521"),
                "asecret"));
        // When
        UserDto userDto = userService.getUser(user.getId());
        // Then
        assertThat(userDto).isNotNull();
        assertThat(userDto.getId()).isEqualTo(user.getId());
        assertThat(userDto.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(userDto.getLastName()).isEqualTo(user.getLastName());
        assertThat(userDto.getEmail()).isEqualTo(user.getEmail());
        assertThat(userDto.getAddress()).isEqualTo(user.getAddress());
        assertThat(userDto.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(userDto.getRole()).isEqualTo(user.getRole());
        assertThat(userDto.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    void getUser_givenWrongUserId_thenThrowUserDoesNotExistException() {
        // Given
        long userId = 100;
        // When
        // Then
        assertThatThrownBy(()-> userService.getUser(userId))
                .isInstanceOf(UserDoesNotExistException.class)
                .hasMessage("User with id: " + userId + " does not exist");
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }
}