package com.pse.testserver.Unit.Repository;


import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.PostRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryUnitTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    PostRepository postRepository;

    Post post1;
    Post post2;
    Post post3;

    @Before
    public void setup() {
        post1 = new Post();
        post2 = new Post();
        post3 = new Post();
        post1.setOwned_by(1);
        post2.setOwned_by(2);
        post3.setOwned_by(3);
    }

    @Test
    public void findAllOwnedByIdTest() {
        Post post1Saved = entityManager.persist(post1);
        Post post2Saved = entityManager.persist(post2);
        Post post3Saved = entityManager.persist(post3);

        assertTrue(postRepository.findAllOwnedById(1).contains(post1Saved));
        assertTrue(postRepository.findAllOwnedById(2).contains(post2Saved));
    }

    @After
    public void tearDown() {
        entityManager.clear();
    }


}
