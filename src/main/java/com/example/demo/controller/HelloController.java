package com.example.demo.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

    @GetMapping(value = "{name}")
    public String hello(@PathVariable("name") String name) {

        // TEST with http://localhost:8080/api/hello/keuss
        return "{\"data\": \"Hello UDEV " + name + "\"}";
    }
}
