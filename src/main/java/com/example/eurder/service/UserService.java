package com.example.eurder.service;

import com.example.eurder.domain.UserRepository;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;
import com.example.eurder.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(CreateUserDto createUserDto){
        return UserMapper.toDto(userRepository.save(UserMapper.toUser(createUserDto)));
    }
}
