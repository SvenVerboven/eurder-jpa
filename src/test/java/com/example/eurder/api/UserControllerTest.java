package com.example.eurder.api;

import com.example.eurder.domain.Address;
import com.example.eurder.domain.PhoneNumber;
import com.example.eurder.domain.Role;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void createUser() {
        // Given
        CreateUserDto createUserDto = new CreateUserDto("Sven",
                "Verboven",
                "sven@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032", "459653254"),
                "asecret");
        // When
        // Then
        webTestClient.post()
                .uri("/users")
                .contentType(APPLICATION_JSON)
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
}