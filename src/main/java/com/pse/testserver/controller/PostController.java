package com.pse.testserver.controller;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.models.Post.Post")
@RequestMapping
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/personalFeed")
    @ResponseBody
    public List<Post> getPersonalFeed(@RequestBody User user) {
        //postService.getPersonalFeed(user);
        return null;
    }

    @GetMapping("/groupFeed")
    @ResponseBody
    public List<Post> getGroupFeed(@RequestBody Group group) {
        //postService.getGroupFeed(group);
        return null;
    }

    @GetMapping("/eventFeed")
    @ResponseBody
    public List<Post> getEventFeed(@RequestBody Event event) {
        //postService.getEventFeed(event);
        return null;
    }

    @PostMapping("/post")
    public boolean post(@RequestBody User user, @RequestBody String text) {
        postService.post(user, text);
        return false;
    }

    @PostMapping("/deletePost")
    public boolean deletePost(@RequestBody Post post) {
        postService.deletePost(post);
        return false;
    }



}