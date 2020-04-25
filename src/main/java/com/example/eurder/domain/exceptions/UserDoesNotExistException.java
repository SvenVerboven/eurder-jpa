package com.example.eurder.domain.exceptions;

public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException(long userId) {
        super("User with id: " + userId + " does not exist");
    }
}
