package com.pse.testserver.service;

import com.pse.testserver.entities.Group;
import com.pse.testserver.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class implementing the business logic regarding the group entity, which includes (or may include
 * in future versions) searching, creating, modifying, deleting and other operations which the application needs
 * to perform on mainly group objects.
 * To perform these operations, methods of the injected repository class(es) are to be used.
 */
@Service
public class GroupService {

    /**
     * Injected GroupRepositoryAdvancedImpl class dependency.
     */


    /**
     * Injected GroupRepository class dependency.
     */
    @Autowired
    private GroupRepository groupRepository;

    /**
     * Method to look for groups, which include the given String in their names.
     *
     * @param name to look for.
     * @return list of wanted groups.
     */
    @Transactional
    public List<Group> getAllByName(String name) {
        return groupRepository.findAllByName(name);
    }


    /**
     * Method to save a new group to the system.
     * @param group to be saved.
     */
    @Transactional
    public void createGroup(Group group) {
        groupRepository.save(group);
    }

    /**
     * Method to delete a group from the system.
     * @param groupId to be deleted.
     */
    @Transactional
    public void deleteGroup(int groupId) {
        Group group = groupRepository.findById(groupId);
        groupRepository.delete(group);
    }

    /**
     * Edits a group by saving the editedGroup received from the client.
     * @param editedGroup received from the client, has the edited attributes.
     */
    @Transactional
    public void editGroup(Group editedGroup) {
        groupRepository.save(editedGroup);
    }


}
