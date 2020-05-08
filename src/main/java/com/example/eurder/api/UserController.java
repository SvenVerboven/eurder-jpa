package com.example.eurder.api;

import com.example.eurder.service.UserService;
import com.example.eurder.service.dto.CreateUserDto;
import com.example.eurder.service.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
//    @CrossOrigin(origins = "https://order-sven-verboven-gui.herokuapp.com")
    public UserDto createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "https://order-sven-verboven-gui.herokuapp.com")
    public Collection<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "https://order-sven-verboven-gui.herokuapp.com")
    public UserDto getUser(@PathVariable long userId) {
        return userService.getUser(userId);
    }

    @PutMapping(path = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "https://order-sven-verboven-gui.herokuapp.com")
    public UserDto updateUser(@PathVariable long userId, @Valid @RequestBody CreateUserDto createUserDto){
        return userService.updateUser(userId, createUserDto);
    }
}
