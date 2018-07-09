package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.User;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * The Class UserRepositoryAdvancedImpl implement the find methods related to user entity, which are not
 * supported by the spring framework.
 */
@Repository
public class UserRepositoryAdvancedImpl implements UserRepositoryAdvanced {


    @Override
    public List<User> findAllByName(String name) {
        return null;
    }

}
