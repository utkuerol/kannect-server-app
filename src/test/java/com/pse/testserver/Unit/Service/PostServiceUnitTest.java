package com.pse.testserver.Unit.Service;

import com.pse.testserver.entities.*;
import com.pse.testserver.repository.CommentRepository;
import com.pse.testserver.repository.PostRepository;
import com.pse.testserver.repository.UserRepository;
import com.pse.testserver.service.PostService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
public class PostServiceUnitTest {

    @Autowired
    PostService postService;
    @MockBean
    PostRepository postRepository;
    @MockBean
    UserRepository userRepository;
    @MockBean
    CommentRepository commentRepository;
    private User user1;
    private User user2;
    private User user3;
    private Group group;
    private Event event;
    private Post post1;
    private Post post2;
    private Post post3;
    private Post post4;
    private List<Post> mockUser2Posts = new LinkedList<>();
    private List<Post> mockUser3Posts = new LinkedList<>();
    private List<Post> mockPostsOfJoinedGroup = new LinkedList<>();
    private List<Post> mockPostsOfParticipatedEvent = new LinkedList<>();
    private List<Post> mockPersonalFeed = new LinkedList<>();

    private EventParticipant eventParticipant1;


    @Before
    public void setup() {


        user1 = new User();
        user2 = new User();
        user3 = new User();
        group = new Group();
        event = new Event();

        user1.setId(1);
        user2.setId(2);
        user3.setId(3);
        group.setId(4);
        event.setId(5);

        user1.getSubscriptions().add(user2);
        user2.getSubscribers().add(user1);
        user1.getSubscriptions().add(user3);
        user3.getSubscribers().add(user1);
        user1.getJoinedGroups().add(group);
        eventParticipant1.setUser(user1);
        eventParticipant1.setEvent(event);
        group.getMembers().add(user1);

        post1 = new Post();
        post2 = new Post();
        post3 = new Post();
        post4 = new Post();

        Calendar calendar1 = new GregorianCalendar(2018, 2, 11);
        Date datePost1 = calendar1.getTime();
        Calendar calendar2 = new GregorianCalendar(2017, 2, 11);
        Date datePost2 = calendar2.getTime();
        Calendar calendar3 = new GregorianCalendar(2018, 3, 11);
        Date datePost3 = calendar3.getTime();
        Calendar calendar4 = new GregorianCalendar(2018, 5, 11);
        Date datePost4 = calendar4.getTime();

        post1.setDate(datePost1);
        post2.setDate(datePost2);
        post3.setDate(datePost3);
        post4.setDate(datePost4);

        mockUser2Posts.add(post1);
        mockUser3Posts.add(post2);
        mockPostsOfJoinedGroup.add(post3);
        mockPostsOfParticipatedEvent.add(post4);

        mockPersonalFeed.addAll(mockUser2Posts);
        mockPersonalFeed.addAll(mockUser3Posts);
        mockPersonalFeed.addAll(mockPostsOfJoinedGroup);
        mockPersonalFeed.addAll(mockPostsOfParticipatedEvent);

        Mockito.when(userRepository.findById(user1.getId()))
                .thenReturn(user1);

        Mockito.when(postRepository.findAllOwnedById(user2.getId()))
                .thenReturn(mockUser2Posts);

        Mockito.when(postRepository.findAllOwnedById(user3.getId()))
                .thenReturn(mockUser3Posts);

        Mockito.when(postRepository.findAllOwnedById(group.getId()))
                .thenReturn(mockPostsOfJoinedGroup);

        Mockito.when(postRepository.findAllOwnedById(event.getId()))
                .thenReturn(mockPostsOfParticipatedEvent);

    }

    @Test
    public void getPersonalFeedTest() {
        Assert.assertTrue(postService.getPersonalFeed(user1.getId()).equals(mockPersonalFeed));
    }

    @Test
    public void likePostTest() {
        postService.likePost(post1, user1);
        Assert.assertTrue(post1.getPostLikes().contains(user1)
                && user1.getLikedPosts().contains(post1));
    }

   @Test
    public void unlikePostTest() {
        PostLike postLike = new PostLike();
        postLike.setLikedUser(user1);
        postLike.setLikedPost(post1);
        postService.unlikePost(post1, user1);
        Assert.assertFalse(post1.getPostLikes().contains(user1)
                && user1.getLikedPosts().contains(post1));
    }

    @Test
    public void commentPostTest() {
        Comment comment = new Comment();
        comment.setPost(post1);
        postService.commentPost(comment);
        Assert.assertTrue(comment.getPost().equals(post1)
                && post1.getComments().contains(comment));
    }

    @TestConfiguration
    public static class PostServiceUnitTestContextConfiguration {

        @Bean
        public PostService postService() {
            return new PostService();
        }
    }

}
