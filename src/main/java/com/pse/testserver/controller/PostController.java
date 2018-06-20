package com.pse.testserver.controller;

import com.pse.testserver.entities.*;
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
        return postService.getAllByUser(user);
    }

    @GetMapping("/groupFeed")
    @ResponseBody
    public List<Post> getGroupFeed(@RequestBody Group group) {
        return postService.getAllByGroup(group);
    }

    @GetMapping("/eventFeed")
    @ResponseBody
    public List<Post> getEventFeed(@RequestBody Event event) {
        return postService.getAllByEvent(event);
    }

    @PostMapping("/post")
    public boolean post(@RequestBody User user, @RequestBody String text) {
        return postService.post(user, text);

    }

    @DeleteMapping("/deletePost")
    public boolean deletePost(@RequestBody Post post) {
        return postService.deletePost(post);
    }
    
    @PostMapping("/editPost")
    public boolean editPost(@RequestBody Post editedPost, @RequestBody Post postToEdit) {
        return postService.editPost(editedPost, postToEdit);

    }

    @PostMapping("/likePost")
    public boolean likePost(@RequestBody Post post, User user) {
        return postService.likePost(post, user);

    }
    
    @PostMapping("/unlikePost")
    public boolean unlikePost(@RequestBody Post post, User user) {
        return postService.unlikePost(post, user);

    }
    
    @PostMapping("/commentPost")
    public boolean commentPost(@RequestBody Post post, User user, Comment comment) {
        return postService.commentPost(post, user, comment);

    }


}