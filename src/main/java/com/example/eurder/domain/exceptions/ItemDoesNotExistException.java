package com.example.eurder.domain.exceptions;

public class ItemDoesNotExistException extends RuntimeException {
    public ItemDoesNotExistException(long itemId) {
        super("Item with id: " + itemId + " does not exist");
    }
}
