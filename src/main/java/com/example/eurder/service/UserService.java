package com.example.eurder.service;

import com.example.eurder.domain.user.User;
import com.example.eurder.domain.exceptions.UserDoesNotExistException;
import com.example.eurder.domain.user.UserRepository;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;
import com.example.eurder.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(CreateUserDto createUserDto){
        logger.info("User is created");
        return UserMapper.toDto(userRepository.save(UserMapper.toUser(createUserDto)));
    }

    public Collection<UserDto> getAllUsers() {
        logger.info("Returned all users");
        return UserMapper.toDto((Collection<User>) userRepository.findAll());
    }

    public UserDto getUser(long userId) {
        if(userRepository.findById(userId).isEmpty()){
            throw new UserDoesNotExistException(userId);
        }
        logger.info("Returned user");
        return UserMapper.toDto(userRepository.findById(userId).get());
    }
}
