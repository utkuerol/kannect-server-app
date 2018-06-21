package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepositoryAdvanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRepositoryAdvancedImpl.
 */
@Repository
public class UserRepositoryAdvancedImpl implements UserRepositoryAdvanced {

    /** The entity manager. */
    @Autowired
    private EntityManager entityManager;


    /* (non-Javadoc)
     * @see com.pse.testserver.repository.UserRepositoryAdvanced#findAllByName(java.lang.String)
     */
    @Override
    public List<User> findAllByName(String name) {
        return null;
    }

}
