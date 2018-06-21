package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.GroupRepositoryAdvanced;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Class GroupRepositoryAdvancedImpl.
 */
@Repository
public class GroupRepositoryAdvancedImpl implements GroupRepositoryAdvanced {


    /**
     * @see com.pse.testserver.repository.GroupRepositoryAdvanced#findAllByName(java.lang.String)
     */
    @Override
    public List<Group> findAllByName(String name) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.GroupRepositoryAdvanced#findJoinedUsers(com.pse.testserver.entities.Group)
     */
    @Override
    public List<User> findJoinedUsers(Group group) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.GroupRepositoryAdvanced#findPost(com.pse.testserver.entities.Group)
     */
    @Override
    public List<Post> findPost(Group group) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.GroupRepositoryAdvanced#findAllByCategory(com.pse.testserver.entities.Category)
     */
    @Override
    public List<Group> findAllByCategory(Category category) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.GroupRepositoryAdvanced#findAllByNameSortedByCategory(java.lang.String, com.pse.testserver.entities.Category)
     */
    @Override
    public List<Group> findAllByNameSortedByCategory(String name, Category category) {
        return null;
    }
}
