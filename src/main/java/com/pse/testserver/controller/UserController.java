package com.pse.testserver.controller;

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
    public void subscribeUser(@RequestParam(value = "subscriber") long subscriberId,
                              @RequestParam(value = "subscribed") long subscribedId) {
        boolean success = userService.subscribeUser(subscriberId, subscribedId);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribeUser(@RequestParam(value = "subscriber") long subscriberId,
                                @RequestParam(value = "subscribed") long subscribedId) {
        userService.unsubscribeUser(subscriberId, subscribedId);
    }
}
