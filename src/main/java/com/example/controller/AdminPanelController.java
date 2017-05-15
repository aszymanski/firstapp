package com.example.controller;

import com.example.domain.Post;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by adria on 15.05.2017.
 */

@Controller
@RequestMapping("/adminpanel")
public class AdminPanelController {


    private PostService postService;

    @Autowired
    public AdminPanelController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("")
    public String adminPanel(){
        return "views/admin/panel";
    }

    @RequestMapping("post/add")
    public String addPostForm(Model model){
        model.addAttribute("post", new Post());
        return "views/admin/add_post";
    }


        @RequestMapping(value="post/add",  method = RequestMethod.POST)
        public String addPost(Post post){
            Post savedPost = postService.save(post);
            return "redirect: ./../../../posts/view/" + savedPost.getSlug();

    }
}
