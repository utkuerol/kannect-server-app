package com.pse.testserver.repository;

import com.pse.testserver.entities.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * The Interface GroupRepository.
 */
public interface GroupRepository extends CrudRepository<Group, Integer> {

    /**
     * Find all groups.
     *
     * @return a {@linkplain java.util.List> of all available groups
     */
    List<Group> findAll();
    
    /**
     * Find group by id.
     *
     * @param id unique id of the searched group
     * @return group with the defined id
     */
    Group findById(long id);
    
    /**
     * Find group by name.
     *
     * @param name name of the searched group
     * @return group with the defined name
     */
    Group findByName(String name);
}
