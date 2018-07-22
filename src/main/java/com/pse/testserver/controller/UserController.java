package com.pse.testserver.controller;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.User;
import com.pse.testserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for the network communications regarding RESTful Http Requests mainly about the User entity.
 * To perform these requests coming from the client, methods of the injected service class(es) are to be used.
 */
@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class UserController {

    /**
     * Injected UserService class dependency.
     */
    @Autowired
    private UserService userService;

    /**
     * Get requests with the "/users" suffix are mapped to this method.
     * Searchs and gives all users with the given name.
     *
     * @param name to search for. Empty String parameter gets all users.
     * @return list of users.
     */
    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers(@RequestParam(value = "name", defaultValue = "") String name) {
        return userService.getAllByName(name);
    }



    @GetMapping("/userByMail")
    public User getUserByMail(@RequestParam(value = "userMail") String userMail) {
        return userService.getUserByMail(userMail);
    }


    @GetMapping("/userById")
    public User getUserById(@RequestParam(value = "userId") long id) {
        return userService.getUserById(id);
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/createUser")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
    /**
     * Post requests with the "/subscribeUser" suffix are mapped to this method.
     * Adds the subscriber user to the subscribed user's list of subscribers and the subscribed user to
     * the subscriber user's list of subscriptions.
     *
     * @param subscriber user, which subscribes.
     * @param subscribed user, which gets subscribed.
     */
    @PostMapping("/subscribeUser")
    public void subscribeUser(@RequestBody User subscriber,
                              @RequestBody User subscribed) {
        userService.subscribeUser(subscriber, subscribed);
    }

    /**
     * Post requests with the "/unsubscribeUser" suffix are mapped to this method.
     * Removes the subscriber user from the subscribed user's list of subscribers and the subscribed user from
     * the subscriber user's list of subscriptions.
     *
     * @param subscriber user, which unsubscribes.
     * @param subscribed user, which gets unsubscribed.
     */
    @PostMapping("/unsubscribeUser")
    public void unsubscribeUser(@RequestBody User subscriber,
                                @RequestBody User subscribed) {
        userService.unsubscribeUser(subscriber, subscribed);
    }

    /**
     * Post requests with the "/joinGroup" suffix are mapped to this method.
     * Adds the given user to the given group's list of members and the group to the user's list of
     * joined groups.
     *
     * @param user  which joins the group.
     * @param group to be joined.
     */
    @PostMapping("/joinGroup")
    public void joinGroup(@RequestBody User user, @RequestBody Group group) {
        userService.joinGroup(user, group);
    }

    /**
     * Post requests with the "/leaveGroup" suffix are mapped to this method.
     * Removes the given user from the given group's list of members and the group from the user's list of
     * joined groups.
     * @param user which leaves the group.
     * @param group to be left.
     */
    @PostMapping("/leaveGroup")
    public void leaveGroup(@RequestBody User user, @RequestBody Group group) {
        userService.leaveGroup(user, group);
    }

    /**
     * Post requests with the "/participateInEvent" suffix are mapped to this method.
     * Adds the given user to the given event's list of participants and the event to the user's list of
     * participated events.
     * @param user which participates in the event.
     * @param event to be participated in.
     */
    @PostMapping("/participateInEvent")
    public void participateInEvent(@RequestBody User user, @RequestBody Event event) {
        userService.participateInEvent(user, event);
    }

    /**
     * Post requests with the "/leaveEvent" suffix are mapped to this method.
     * Removes the given user from the given event's list of participants and the event from the user's list of
     * participated events.
     * @param user which leaves the event.
     * @param event to be left.
     */
    @PostMapping("/leaveEvent")
    public void leaveEvent(@RequestBody User user, @RequestBody Event event) {
        userService.leaveEvent(user, event);
    }

}
