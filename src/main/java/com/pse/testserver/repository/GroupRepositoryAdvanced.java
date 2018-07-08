package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query("Select * from groups g where g.name like name")
    List<Group> findAllByName(@Param("name") String name);
    
    /**
     * Find all groups from the database belonging to the specified category.
     *
     * @param category category of groups searched
     * @return list of all groups that belong to the given category
     */
    @Query("Select * from groups g where g.category_id like category")
    List<Group> findAllByCategory(@Param("category") long category);
    
    /**
     * Find all groups from the database containing the string name with the specified category.
     *
     * @param name word to be searched in all groups names
     * @param category category of groups searched
     * @return list of all groups that belong to the given category
     */
    @Query("Select * from groups g where g.name like name and g.category_id like category")
    List<Group> findAllByNameSortedByCategory(@Param("name") String name, @Param("category") long category);
    
    
    /**
     * Find all posts of group from the database.
     *
     * @param group group to be searched in for posts
     * @return list of all posts of the group
     */
    List<Post> findPost(Group group);
}
