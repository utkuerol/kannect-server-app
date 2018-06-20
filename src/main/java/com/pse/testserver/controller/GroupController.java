package com.pse.testserver.controller;

import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/groups")
    @ResponseBody
    public List<Group> getUsers(@RequestParam(value = "name", defaultValue = "") String name) {
        groupService.getAllByName(name);
        return null;
    }
    
    
    @PostMapping("/editGroup")
    public boolean editGroup(@RequestBody Group editedGroup ,@RequestBody Group GroupToEdit) {
        groupService.editGroup(editedGroup, GroupToEdit);
        return false;
    }

}
