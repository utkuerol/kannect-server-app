package com.pse.testserver.repository;

import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Simple interface which includes find methods related to group entity.
 * To perform these operations, methods of the spring framework are to be used.
 */
public interface GroupRepository extends CrudRepository<Group, Integer> {

    /**
     * Find all groups from the database.
     *
     * @return a list of all available groups
     */
    List<Group> findAll();
    
    /**
     * Find group from the database by id.
     *
     * @param id unique id of the searched group
     * @return group with the defined id
     */
    Group findById(long id);


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
     * @param name     word to be searched in all groups names
     * @param category category of groups searched
     * @return list of all groups that belong to the given category
     */
    @Query("Select * from groups g where g.name like name and g.category_id like category")
    List<Group> findAllByNameSortedByCategory(@Param("name") String name, @Param("category") long category);

}
