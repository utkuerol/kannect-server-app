package com.pse.testserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pse.testserver.entities.Post;
import com.pse.testserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.models.Post.Post")
@RequestMapping
public class PostController {

    @Autowired
    private PostService postService;

    ObjectMapper mapper = new ObjectMapper();


    @GetMapping("/posts")
    @ResponseBody
    public String getPosts(Model model) {

        List<Post> feed = postService.getAllPosts();

        try {
            //Convert object to JSON string
            String feedJson = mapper.writeValueAsString(feed);
            return feedJson;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "failed";
    }
}