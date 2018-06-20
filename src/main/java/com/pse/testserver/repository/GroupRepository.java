package com.pse.testserver.repository;

import com.pse.testserver.entities.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {
    Group findById(int id);
    Group findByName(String name);
}
