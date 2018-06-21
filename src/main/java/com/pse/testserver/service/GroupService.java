package com.pse.testserver.service;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.GroupRepository;
import com.pse.testserver.repository.impl.GroupRepositoryAdvancedImpl;
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
    @Autowired
    private GroupRepositoryAdvancedImpl groupRepositoryADV;

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
        return groupRepositoryADV.findAllByName(name);
    }

    /**
     * Method to get the users, which have joined the given group.
     *
     * @param group to look of joined users.
     * @return list of users
     */
    @Transactional
    public List<User> getJoinedUsers(Group group) {
        return null;
    }

    /**
     * Method to get all groups, which fall into the given category.
     * @param category to look for groups.
     * @return list of groups
     */
    @Transactional
    public List<Group> getAllByCategory(Category category) {
        return groupRepositoryADV.findAllByCategory(category);
    }

    /**
     * Method to look for groups, which include the given String in their names and fall into the given category.
     * @param name to look for.
     * @param category to look for.
     * @return list of groups
     */
    @Transactional
    public List<Group> getAllByNameSortedByCategory(String name, Category category) {
        return groupRepositoryADV.findAllByNameSortedByCategory(name, category);
    }

    /**
     * Method to get all groups in the system.
     * @return list of groups.
     */
    @Transactional
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    /**
     * Method to find a group by its unique id.
     * @param id
     * @return found group.
     */
    @Transactional
    public Group getById(int id) {
        return groupRepository.findById(id);
    }

    /**
     * Method to save a new group to the system.
     * @param group to be saved.
     */
    @Transactional
    public void createGroup(Group group) {
    }

    /**
     * Method to delete a group from the system.
     * @param group to be deleted.
     */
    @Transactional
    public void deleteGroup(Group group) {
    }

    /**
     * Method to edit a group.
     * @param editedGroup received from the client, has the edited attributes.
     * @param groupToEdit original group to be edited, which will be compared to the editedGroup
     *                    received from the client and modified accordingly.
     */
    @Transactional
    public void editGroup(Group editedGroup, Group groupToEdit) {
    }
}
