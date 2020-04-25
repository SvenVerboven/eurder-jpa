package com.example.eurder.service;

import com.example.eurder.domain.User;
import com.example.eurder.domain.exceptions.UserDoesNotExistException;
import com.example.eurder.domain.UserRepository;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;
import com.example.eurder.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    public Collection<UserDto> getAllUsers() {
        return UserMapper.toDto((Collection<User>) userRepository.findAll());
    }

    public UserDto getUser(long userId) {
        if(userRepository.findById(userId).isEmpty()){
            throw new UserDoesNotExistException(userId);
        }
        return UserMapper.toDto(userRepository.findById(userId).get());
    }
}
