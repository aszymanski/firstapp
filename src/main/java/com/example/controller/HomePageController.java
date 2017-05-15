package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomePageController {

    private String pageTitle = "Test custom title";

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle",pageTitle);
        return "index";
    }
}
