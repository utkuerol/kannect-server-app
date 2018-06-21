package com.pse.testserver.repository;

import com.pse.testserver.entities.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Simple interface which includes find methods related to group entity.
 * To perform these operations, methods of the spring framework are to be used.
 */
public interface GroupRepository extends CrudRepository<Group, Integer> {

    /**
     * Find all groups.
     *
     * @return a list of all available groups
     */
    List<Group> findAll();
    
    /**
     * Find group by id.
     *
     * @param id unique id of the searched group
     * @return group with the defined id
     */
    Group findById(long id);
    
}
