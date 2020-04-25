package com.example.eurder.service.mapper;

import com.example.eurder.domain.User;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;

public abstract class UserMapper {

    public static User toUser(CreateUserDto createUserDto){
        return new User(
                createUserDto.getFirstName(),
                createUserDto.getLastName(),
                createUserDto.getEmail(),
                createUserDto.getAddress(),
                createUserDto.getPhoneNumber(),
                createUserDto.getPassword()
        );
    }

    public static UserDto toDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.getRole());
    }
}
