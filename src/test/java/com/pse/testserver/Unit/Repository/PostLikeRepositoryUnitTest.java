package com.pse.testserver.Unit.Repository;

import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.PostLike;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.EventParticipantRepository;
import com.pse.testserver.repository.PostLikeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostLikeRepositoryUnitTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    PostLikeRepository postLikeRepository;

    User user1;
    User user2;
    User user3;

    User savedUser1;
    User savedUser2;
    User savedUser3;

    Post post1;
    Post post2;
    Post post3;

    Post savedPost1;
    Post savedPost2;
    Post savedPost3;

    PostLike postLike1;
    PostLike postLike2;
    PostLike postLike3;

    PostLike savedPostLike1;
    PostLike savedPostLike2;
    PostLike savedPostLike3;


    @Before
    public void setup() {

        user1 = new User();
        user2 = new User();
        user3 = new User();
        user1.setName("true");
        user1.setName("truee");
        user1.setName("false");


        savedUser1 = entityManager.persist(user1);
        savedUser2 = entityManager.persist(user2);
        savedUser3 = entityManager.persist(user3);

        post1 = new Post();
        post2 = new Post();
        post3 = new Post();
        post1.setText("Hallo");
        post1.setText("Hey");
        post1.setText("Hola");

        savedPost1 = entityManager.persist(post1);
        savedPost2 = entityManager.persist(post2);
        savedPost3 = entityManager.persist(post3);

        postLike1 = new PostLike();
        postLike2 = new PostLike();
        postLike3 = new PostLike();

        postLike1.setLikedPost(savedPost1);
        postLike1.setLikedUser(savedUser1);
        savedPostLike1 = entityManager.persist(postLike1);

        postLike2.setLikedPost(savedPost2);
        postLike2.setLikedUser(savedUser2);
        savedPostLike2 = entityManager.persist(postLike2);

        postLike3.setLikedPost(savedPost3);
        postLike3.setLikedUser(savedUser3);
        savedPostLike3 = entityManager.persist(postLike3);
    }

    @Test
    public void findBySubscriberAndSubscribedId() {
        assertTrue(postLikeRepository.findByUserAndPostId(savedUser1.getId(), savedPost1.getId()).getId() == postLike1.getId());
        assertTrue(postLikeRepository.findByUserAndPostId(savedUser2.getId(), savedPost2.getId()).getId() == postLike2.getId());
        assertTrue(postLikeRepository.findByUserAndPostId(savedUser3.getId(), savedPost3.getId()).getId() == postLike3.getId());
    }


    @After
    public void tearDown() {
        entityManager.clear();
    }
}
