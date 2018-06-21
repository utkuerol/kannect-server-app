package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;

import java.util.List;

/**
 * The Interface GroupRepositoryAdvanced.
 */
public interface GroupRepositoryAdvanced{
    
    /**
     * Find all groups containing the string name.
     *
     * @param name word to be searched in all groups names
     * @return list of all groups containing the string name
     */
    List<Group> findAllByName(String name);
    
    /**
     * Find all groups belonging to the specified category.
     *
     * @param category category of groups searched
     * @return list of all groups that belong to the given category
     */
    List<Group> findAllByCategory(Category category);
    
    /**
     * Find all groups containing the string name with the specified category.
     *
     * @param name word to be searched in all groups names
     * @param category category of groups searched
     * @return list of all groups that belong to the given category
     */
    List<Group> findAllByNameSortedByCategory(String name, Category category);
    
    /**
     * Find all members of group.
     *
     * @param group group to be searched in for members
     * @return list of all members of the group
     */
    List<User> findJoinedUsers(Group group);
    
    /**
     * Find all posts of group.
     *
     * @param group group to be searched in for posts
     * @return list of all posts of the group
     */
    List<Post> findPost(Group group);
}
