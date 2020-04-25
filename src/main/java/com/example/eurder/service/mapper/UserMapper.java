package com.example.eurder.service.mapper;

import com.example.eurder.domain.user.User;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;

import java.util.Collection;
import java.util.stream.Collectors;

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

    public static Collection<UserDto> toDto(Collection<User> users){
        return users.stream().map(UserMapper::toDto).collect(Collectors.toList());
    }
}
