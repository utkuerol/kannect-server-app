package com.pse.testserver.repository;

import com.pse.testserver.entities.Group;
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
    @Query("Select * from groups")
    List<Group> findAll();
    
    /**
     * Find group from the database by id.
     *
     * @param id unique id of the searched group
     * @return group with the defined id
     */
    @Query("Select * from groups g where g.id like id")
    Group findById(@Param("id") long id);
    
}
