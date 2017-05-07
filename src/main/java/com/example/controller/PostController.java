package com.example.controller;

import com.example.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by adria on 06.05.2017.
 */

@Controller
public class PostController {
    private String message = "Template message";

    @RequestMapping("/myposts")
    public String welcome(Model model){
        model.addAttribute("message",this.message);
        return "index";
    }
}
