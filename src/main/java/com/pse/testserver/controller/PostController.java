package com.pse.testserver.controller;

import com.pse.testserver.entities.*;
import com.pse.testserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for the network communications regarding RESTful Http Requests mainly about the Post entity.
 * To perform these requests coming from the client, methods of the injected service class(es) are to be used.
 */
@RestController
@ComponentScan(basePackages = "com.pse.testserver.models.Post.Post")
@RequestMapping
public class PostController {

    /**
     * Injected PostService class dependency.
     */
    @Autowired
    private PostService postService;

    /**
     * Get requests with the "/personalFeed" suffix are mapped to this method.
     * Gets all posts owned by users, groups and events, which are subscribed/joined/participated by the given user
     * in chronological order, with the latest created post being the first item.
     *
     * @param user whose personal feed is to be fetched.
     * @return list of posts.
     */
    @GetMapping("/personalFeed")
    @ResponseBody
    public List<Post> getPersonalFeed(@RequestBody User user) {
        return postService.getPersonalFeed(user);
    }

    /**
     * Get requests with the "/groupFeed" suffix are mapped to this method.
     * Gets all posts, which are owned by the given group.
     *
     * @param group whose posts are to be fetched.
     * @return list of posts.
     */
    @GetMapping("/groupFeed")
    @ResponseBody
    public List<Post> getGroupFeed(@RequestBody Group group) {
        return postService.getAllByGroup(group);
    }

    /**
     * Get requests with the "/eventFeed" suffix are mapped to this method.
     * Gets all posts, which are owned by the given event.
     * @param event whose posts are to be fetched.
     * @return list of posts.
     */
    @GetMapping("/eventFeed")
    @ResponseBody
    public List<Post> getEventFeed(@RequestBody Event event) {
        return postService.getAllByEvent(event);
    }

    /**
     * Get requests with the "/userProfile" suffix are mapped to this method.
     * Gets all posts, which are owned by the given user.
     *
     * @param user whose posts are to be fetched.
     * @return list of posts.
     */
    @GetMapping("/userProfile")
    @ResponseBody
    public List<Post> getUsersProfile(@RequestBody User user) {
        return postService.getAllByUser(user);
    }

    /**
     * Post requests with the "/post" suffix are mapped to this method.
     * Saves a new post object into the system.
     * @param post to be saved, received from the client.
     */
    @PostMapping("/newPost")
    public void newPost(@RequestBody Post post) {
        postService.newPost(post);
    }

    /**
     * Post requests with the "/editPost" suffix are mapped to this method.
     * Edits a post by saving the editedPost received from the client.
     * @param editedPost received from the client, has the edited attributes.
     */
    @PostMapping("/editPost")
    public void editPost(@RequestBody Post editedPost) {
        postService.editPost(editedPost);
    }

    /**
     * Post requests with the "/likePost" suffix are mapped to this method.
     * Adds the given user to the given post's list of liked users.
     * @param post to be liked.
     * @param user which likes the post.
     */
    @PostMapping("/likePost")
    public void likePost(@RequestBody Post post, User user) {
        postService.likePost(post, user);
    }

    /**
     * Post requests with the "/unlikePost" suffix are mapped to this method.
     * Removes the given user from the given post's list of liked users.
     * @param post to be unliked.
     * @param user which unlikes the post.
     */
    @PostMapping("/unlikePost")
    public void unlikePost(@RequestBody Post post, User user) {
        postService.unlikePost(post, user);
    }

    /**
     * Post requests with the "/commentPost" suffix are mapped to this method.
     * Saves a new comment into the system.
     * @param comment to be saved, received from the client.
     */
    @PostMapping("/commentPost")
    public void commentPost(@RequestBody Comment comment) {
        postService.commentPost(comment);
    }

    /**
     * Delete requests with the "/deletePost" suffix are mapped to this method.
     * Deletes a post object from the system.
     *
     * @param post to be deleted.
     */
    @DeleteMapping("/deletePost")
    public void deletePost(@RequestBody Post post) {
        postService.deletePost(post);
    }
}