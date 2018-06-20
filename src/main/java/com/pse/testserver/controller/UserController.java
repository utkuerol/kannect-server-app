package com.pse.testserver.controller;

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
    UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers(@RequestParam(value = "name", defaultValue = "") String name) {
        userService.getAllByName(name);
        return null;
    }

    @PostMapping("/subscribe")
    public void subscribeUser(@RequestBody User subscriber,
                              @RequestBody User subscribed) {
        boolean success = userService.subscribeUser(subscriber, subscribed);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribeUser(@RequestBody User subscriber,
                                @RequestBody User subscribed) {
        userService.unsubscribeUser(subscriber, subscribed);
    }

    @PostMapping("/joinGroup")
    public void joinGroup(@RequestBody User user, @RequestBody Group group) {
        //userService.joinGroup(user, group);
    }

    @PostMapping("/leaveGroup")
    public void leaveGroup(@RequestBody User user, @RequestBody Group group) {
        //userService.leaveGroup(user, group);
    }

}
