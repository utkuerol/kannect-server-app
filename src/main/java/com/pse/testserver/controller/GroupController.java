package com.pse.testserver.controller;

import com.pse.testserver.entities.Group;
import com.pse.testserver.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping("/createGroup")
    public boolean createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    @DeleteMapping("/deleteGroup")
    public boolean deleteGroup(@RequestBody Group group) {
        return groupService.deleteGroup(group);
    }


}
