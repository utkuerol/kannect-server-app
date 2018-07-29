package com.pse.testserver.service;

import com.pse.testserver.entities.*;
import com.pse.testserver.repository.CommentRepository;
import com.pse.testserver.repository.PostRepository;
import com.pse.testserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.LinkedList;
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
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;


    /**
     * Gets all posts owned by users, groups and events, which are subscribed/joined/participated by the given user
     * in chronological order, with the latest created post being the first item.
     *
     * @param userId whose personal feed is to be fetched.
     * @return list of posts.
     */
    @Transactional
    public List<Post> getPersonalFeed(int userId) {
        List<Post> personalFeed = new LinkedList<>();

        User user = userRepository.findById(userId);

        for (User subscription : user.getSubscriptions()) {
            personalFeed.addAll(postRepository.findAllOwnedById(subscription.getId()));
        }

        for (Group joinedGroup : user.getJoinedGroups()) {
            personalFeed.addAll(postRepository.findAllOwnedById(joinedGroup.getId()));
        }

        for (Event participatedEvent : user.getParticipatedEvents()) {
            personalFeed.addAll(postRepository.findAllOwnedById(participatedEvent.getId()));
        }

        personalFeed.sort(Comparator.comparing(Post::getDate));
        return personalFeed;
    }


    /**
     * Gets all posts, which are owned by the given user.
     * @param userId whose posts are to be fetched.
     * @return list of posts.
     */
    @Transactional
    public List<Post> getAllByUser(int userId) {
        return postRepository.findAllOwnedById(userId);
    }

    /**
     * Gets all posts, which are owned by the given group and sorts them chronologically.
     * @param groupId whose posts are to be fetched.
     * @return list of posts.
     */
    @Transactional
    public List<Post> getAllByGroup(int groupId) {
        return postRepository.findAllOwnedById(groupId);
    }

    /**
     * Gets all posts, which are owned by the given event and sorts them chronologically.
     * @param eventId whose posts are to be fetched.
     * @return list of posts.
     */
    @Transactional
    public List<Post> getAllByEvent(int eventId) {
        return postRepository.findAllOwnedById(eventId);
    }

    /**
     * Saves a new post object into the system.
     * @param post to be saved, received from the client.
     */
    @Transactional
    public void newPost(Post post) {
        postRepository.save(post);
    }

    /**
     * Deletes a post object from the system.
     * @param post to be deleted.
     */
    @Transactional
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    /**
     * Edits a post by saving the editedPost received from the client.
     * @param editedPost received from the client, has the edited attributes.
     */
    @Transactional
    public void editPost(Post editedPost) {
        postRepository.save(editedPost);
    }

    /**
     * Adds the given user to the given post's list of liked users.
     * @param post to be liked.
     * @param user which likes the post.
     */
    @Transactional
    public void likePost(Post post, User user) {
        List<Post> posts = user.getLikedPosts();
        List<User> users = post.getLikedUsers();
        posts.add(post);
        users.add(user);
        post.setLikedUsers(users);
        user.setLikedPosts(posts);
        userRepository.save(user);
        postRepository.save(post);
    }

    /**
     * Removes the given user from the given post's list of liked users.
     * @param post to be unliked.
     * @param user which unlikes the post.
     */
    @Transactional
    public void unlikePost(Post post, User user) {
        user.getLikedPosts().remove(post);
        userRepository.save(user);
        post.getLikedUsers().remove(user);
        postRepository.save(post);

    }

    /**
     * Saves a new comment into the system.
     * @param comment to be saved, received from the client.
     */
    @Transactional
    public void commentPost(Comment comment) {
        commentRepository.save(comment);
        Post post = comment.getPost();
        post.getComments().add(comment);
        postRepository.save(post);
    }

}
