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
        return postService.getPersonalFeed(user);
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

    @GetMapping("/eventFeed")
    @ResponseBody
    public List<Post> getUsersProfile(@RequestBody User user) {
        return postService.getAllByUser(user);
    }

    @PostMapping("/post")
    public void post(@RequestBody Post post) {
        postService.post(post);
    }

    @DeleteMapping("/deletePost")
    public void deletePost(@RequestBody Post post) {
        postService.deletePost(post);
    }
    
    @PostMapping("/editPost")
    public void editPost(@RequestBody Post editedPost, @RequestBody Post postToEdit) {
        postService.editPost(editedPost, postToEdit);
    }

    @PostMapping("/likePost")
    public void likePost(@RequestBody Post post, User user) {
        postService.likePost(post, user);

    }
    
    @PostMapping("/unlikePost")
    public void unlikePost(@RequestBody Post post, User user) {
        postService.unlikePost(post, user);
    }
    
    @PostMapping("/commentPost")
    public void commentPost(@RequestBody Comment comment) {
        postService.commentPost(comment);
    }


}