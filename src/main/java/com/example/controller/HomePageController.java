package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adria on 06.05.2017.
 */
@RestController
public class HomePageController {
    @RequestMapping("/example")
    public String home() {
        return "Hello World - this is from controller " + "<a href=\"http://localhost:8080\">Home<a/>";
    }
}
