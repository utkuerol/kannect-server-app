package com.pse.testserver.controller;

import com.pse.testserver.entities.Group;
import com.pse.testserver.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for the network communications regarding RESTful Http Requests mainly about the Group entity.
 * To perform these requests coming from the client, methods of the injected service class(es) are to be used.
 */
@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class GroupController {


    /**
     * Injected GroupService class dependency.
     */
    @Autowired
    private GroupService groupService;

    /**
     * Get requests with the "/groups" suffix are mapped to this method.
     * Gets groups, which include the given String in their names.
     *
     * @param name to look for groups. When no parameter is given, the default value will be set to
     *             an empty String "". In this case a list of all groups will be returned.
     * @return list of groups.
     */
    @GetMapping("/groups")
    @ResponseBody
    public List<Group> getGroups(@RequestParam(value = "name", defaultValue = "") String name) {
        groupService.getAllByName(name);
        return null;
    }

    /**
     * Post requests with the "/createGroup" suffix are mapped to this method.
     * Saves a group to the system.
     *
     * @param group to be saved.
     */
    @PostMapping("/createGroup")
    public void createGroup(@RequestBody Group group) {
        groupService.createGroup(group);
    }

    /**
     * Delete requests with the "/deleteGroup" suffix are mapped to this method.
     * Deletes a group from the system.
     *
     * @param group to be deleted.
     */
    @DeleteMapping("/deleteGroup")
    public void deleteGroup(@RequestBody Group group) {
        groupService.deleteGroup(group);
    }


    /**
     * Post requests with the "/editGroup" suffix are mapped to this method.
     * Saves the edited group, received from the client.
     * @param editedGroup to be saved.
     */
    @PostMapping("/editGroup")
    public boolean editGroup(@RequestBody Group editedGroup) {
        groupService.editGroup(editedGroup);
        return false;
    }

}
