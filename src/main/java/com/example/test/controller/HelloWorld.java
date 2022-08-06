package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/start")
    public String start()
    {
        return "hello world ... " ;
    }


    @GetMapping("/end")
    public String end()
    {
        return "goodbye ... " ;
    }


}
