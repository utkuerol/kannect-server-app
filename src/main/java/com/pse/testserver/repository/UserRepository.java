package com.pse.testserver.repository;

import com.pse.testserver.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
