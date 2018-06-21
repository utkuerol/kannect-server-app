package com.pse.testserver.service;

import com.pse.testserver.entities.*;
import com.pse.testserver.repository.PostRepository;
import com.pse.testserver.repository.impl.PostRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class implementing the business logic regarding the post entity, which includes (or may include
 * in future versions) searching, creating, modifying, deleting and other operations which the application needs
 * to perform on mainly post objects.
 * To perform these operations, methods of the injected repository class(es) are to be used.
 */
@Service
public class PostService {

    /**
     * Injected PostRepository class dependency.
     */
    @Autowired
    private PostRepository postRepository;

    /**
     * Injected PostRepositoryAdvancedImpl class dependency.
     */
    @Autowired
    private PostRepositoryAdvancedImpl postRepositoryADV;

    /**
     * Gets all posts owned by users, groups and events, which are subscribed/joined/participated by the given user
     * in chronological order, with the latest created post being the first item.
     *
     * @param user whose personal feed is to be fetched.
     * @return list of posts.
     */
    @Transactional
    public List<Post> getPersonalFeed(User user) {
        return null;
    }

    /**
     * Gets all posts, which are owned by the given user.
     * @param user whose posts are to be fetched.
     * @return list of posts.
     */
    @Transactional
    public List<Post> getAllByUser(User user) {
        return postRepositoryADV.findAllByUser(user);
    }

    /**
     * Gets all posts, which are owned by the given group and sorts them chronologically.
     * @param group whose posts are to be fetched.
     * @return list of posts.
     */
    @Transactional
    public List<Post> getAllByGroup(Group group) {
        return postRepositoryADV.findAllByGroup(group);
    }

    /**
     * Gets all posts, which are owned by the given event and sorts them chronologically.
     * @param event whose posts are to be fetched.
     * @return list of posts.
     */
    @Transactional
    public List<Post> getAllByEvent(Event event) {
        return postRepositoryADV.findAllByEvent(event);
    }

    /**
     * Saves a new post object into the system.
     * @param post to be saved, received from the client.
     */
    @Transactional
    public void post(Post post) {
    }

    /**
     * Deletes a post object from the system.
     * @param post to be deleted.
     */
    @Transactional
    public void deletePost(Post post) {
    }

    /**
     * Edits a post by saving the editedPost received from the client.
     * @param editedPost received from the client, has the edited attributes.
     */
    @Transactional
    public void editPost(Post editedPost) {
    }

    /**
     * Adds the given user to the given post's list of liked users.
     * @param post to be liked.
     * @param user which likes the post.
     */
    @Transactional
    public void likePost(Post post, User user) {
    }

    /**
     * Removes the given user from the given post's list of liked users.
     * @param post to be unliked.
     * @param user which unlikes the post.
     */
    @Transactional
    public void unlikePost(Post post, User user) {
    }

    /**
     * Saves a new comment into the system.
     * @param comment to be saved, received from the client.
     */
    @Transactional
    public void commentPost(Comment comment) {

    }

}
