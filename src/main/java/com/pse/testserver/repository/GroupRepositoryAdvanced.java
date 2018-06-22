package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;

import java.util.List;

/**
 * Advanced repository interface which includes find methods related to group entity.
 * 
 */
public interface GroupRepositoryAdvanced{
    
    /**
     * Find all groups from the database containing the string name.
     *
     * @param name word to be searched in all groups names
     * @return list of all groups containing the string name
     */
    List<Group> findAllByName(String name);
    
    /**
     * Find all groups from the database belonging to the specified category.
     *
     * @param category category of groups searched
     * @return list of all groups that belong to the given category
     */
    List<Group> findAllByCategory(Category category);
    
    /**
     * Find all groups from the database containing the string name with the specified category.
     *
     * @param name word to be searched in all groups names
     * @param category category of groups searched
     * @return list of all groups that belong to the given category
     */
    List<Group> findAllByNameSortedByCategory(String name, Category category);
    
    
    /**
     * Find all posts of group from the database.
     *
     * @param group group to be searched in for posts
     * @return list of all posts of the group
     */
    List<Post> findPost(Group group);
}
