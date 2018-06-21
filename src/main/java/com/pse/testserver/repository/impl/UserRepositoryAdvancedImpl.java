package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepositoryAdvanced;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * The Class UserRepositoryAdvancedImpl.
 */
@Repository
public class UserRepositoryAdvancedImpl implements UserRepositoryAdvanced {

    /**
     * @see com.pse.testserver.repository.UserRepositoryAdvanced#findAllByName(java.lang.String)
     */
    @Override
    public List<User> findAllByName(String name) {
        return null;
    }

}
