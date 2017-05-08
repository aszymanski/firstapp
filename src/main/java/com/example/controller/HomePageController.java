package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomePageController {

    private String sampleText = "This is sample text for Home Page";

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("pageText",sampleText);
        return "index";
    }
}
