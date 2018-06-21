package com.pse.testserver.repository;

import com.pse.testserver.entities.Group;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {

    /**
     * @return a {@linkplain java.util.List> of all available groups
     */
    List<Group> findAll();
    
    /**
     * 
     * @param id unique id of the searched group
     * @return group with the defined id
     */
    Group findById(int id);
    
    /**
     * 
     * @param name name of the searched group
     * @return group with the defined name
     */
    Group findByName(String name);
}
