package com.pse.testserver.controller;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.User;
import com.pse.testserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers(@RequestParam(value = "name", defaultValue = "") String name) {
        userService.getAllByName(name);
        return null;
    }

    @PostMapping("/subscribe")
    public boolean subscribeUser(@RequestBody User subscriber,
                                 @RequestBody User subscribed) {
        return userService.subscribeUser(subscriber, subscribed);
    }

    @PostMapping("/unsubscribe")
    public boolean unsubscribeUser(@RequestBody User subscriber,
                                   @RequestBody User subscribed) {
        return userService.unsubscribeUser(subscriber, subscribed);
    }

    @PostMapping("/joinGroup")
    public boolean joinGroup(@RequestBody User user, @RequestBody Group group) {
        return userService.joinGroup(user, group);
    }

    @PostMapping("/leaveGroup")
    public boolean leaveGroup(@RequestBody User user, @RequestBody Group group) {
        return userService.leaveGroup(user, group);
    }

    @PostMapping("/participateInEvent")
    public boolean participateInEvent(@RequestBody User user, @RequestBody Event event) {
        //return userService.participateInEvent(user, event);
        return true;
    }

    @PostMapping("/leaveEvent")
    public boolean leaveEvent(@RequestBody User user, @RequestBody Event event) {
        //return userService.leaveEvent(user, event);
        return true;
    }

}
