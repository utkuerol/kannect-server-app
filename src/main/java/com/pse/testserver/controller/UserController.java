package com.pse.testserver.controller;

import com.pse.testserver.entities.User;
import com.pse.testserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getUsers(@RequestParam(value = "name", defaultValue = "") String name) {
        //userService.getUsersByName(name) ...
        return null;
    }


}
