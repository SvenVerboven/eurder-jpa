package com.example.eurder.api;

import com.example.eurder.domain.exceptions.ItemDoesNotExistException;
import com.example.eurder.domain.exceptions.UserDoesNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger exceptionLogger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(UserDoesNotExistException.class)
    protected void userDoesNotExistException(UserDoesNotExistException ex,
                                             HttpServletResponse response) throws IOException {
        exceptionLogger.warn(ex.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
    @ExceptionHandler(ItemDoesNotExistException.class)
    protected void itemDoesNotExistException(ItemDoesNotExistException ex,
                                             HttpServletResponse response) throws IOException {
        exceptionLogger.warn(ex.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
