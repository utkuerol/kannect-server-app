package com.pse.testserver.repository;

import com.pse.testserver.entities.Group;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {
    
    Set<Group> findAll();
    Group findById(int id);
    Group findByName(String name);
}
