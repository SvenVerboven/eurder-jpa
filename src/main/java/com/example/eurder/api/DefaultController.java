package com.example.eurder.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class DefaultController {

    @GetMapping
    public String defaultText(){
        return "Hello örder";
    }
}
