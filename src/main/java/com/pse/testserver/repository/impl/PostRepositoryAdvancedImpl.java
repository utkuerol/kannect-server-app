package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.PostRepositoryAdvanced;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Class PostRepositoryAdvancedImpl implement the find methods related to post entity, which are not
 * supported by the spring framework.
 */
@Repository
public class PostRepositoryAdvancedImpl implements PostRepositoryAdvanced {

    /**
     * @see com.pse.testserver.repository.PostRepositoryAdvanced#findAllByUser(com.pse.testserver.entities.User)
     */
    @Override
    public List<Post> findAllByUser(long user) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.PostRepositoryAdvanced#findAllByGroup(com.pse.testserver.entities.Group)
     */
    @Override
    public List<Post> findAllByGroup(long group) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.PostRepositoryAdvanced#findAllByEvent(com.pse.testserver.entities.Event)
     */
    @Override
    public List<Post> findAllByEvent(long event) {
        return null;
    }


}
