package com.example.eurder.api;

import com.example.eurder.domain.user.*;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    public static final String USERS_PATH = "/users";
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private UserRepository userRepository;


    @Test
    void createUser() {
        // Given
        CreateUserDto createUserDto = new CreateUserDto("Sven", "Verboven", "sven@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032", "459653254"),
                "asecret");
        // When
        // Then
        webTestClient.post()
                .uri(USERS_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createUserDto), CreateUserDto.class)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(UserDto.class)
                .value(userDto -> assertThat(userDto.getId()).isNotNull())
                .value(userDto -> assertThat(userDto.getFirstName()).isEqualTo(createUserDto.getFirstName()))
                .value(userDto -> assertThat(userDto.getLastName()).isEqualTo(createUserDto.getLastName()))
                .value(userDto -> assertThat(userDto.getEmail()).isEqualTo(createUserDto.getEmail()))
                .value(userDto -> assertThat(userDto.getAddress()).isEqualTo(createUserDto.getAddress()))
                .value(userDto -> assertThat(userDto.getPhoneNumber()).isEqualTo(createUserDto.getPhoneNumber()))
                .value(userDto -> assertThat(userDto.getRole()).isEqualTo(Role.CUSTOMER));
    }

    @Test
    void getAllUsers() {
        // Given
        userRepository.save(new User("Sven", "Verboven", "sven@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032", "456986521"),
                "asecret"));
        userRepository.save(new User("Melissa", "Morren", "melissa@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032", "458753216"),
                "tralalala"));
        // When
        // Then
        webTestClient.get()
                .uri(USERS_PATH)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(UserDto.class)
                .hasSize(2);
    }

    @Test
    void getUser_givenUserId_thenReturnUser() {
        // Given
        User user = userRepository.save(new User("Sven", "Verboven", "sven@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032", "456986521"),
                "asecret"));
        // When
        // Then
        webTestClient.get()
                .uri(USERS_PATH + "/" + user.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserDto.class)
                .value(userDto -> assertThat(userDto.getId()).isNotNull())
                .value(userDto -> assertThat(userDto.getId()).isEqualTo(user.getId()))
                .value(userDto -> assertThat(userDto.getFirstName()).isEqualTo(user.getFirstName()))
                .value(userDto -> assertThat(userDto.getLastName()).isEqualTo(user.getLastName()))
                .value(userDto -> assertThat(userDto.getEmail()).isEqualTo(user.getEmail()))
                .value(userDto -> assertThat(userDto.getAddress()).isEqualTo(user.getAddress()))
                .value(userDto -> assertThat(userDto.getPhoneNumber()).isEqualTo(user.getPhoneNumber()))
                .value(userDto -> assertThat(userDto.getRole()).isEqualTo(user.getRole()))
                .value(userDto -> assertThat(userDto.getPassword()).isEqualTo(user.getPassword()));
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }
}