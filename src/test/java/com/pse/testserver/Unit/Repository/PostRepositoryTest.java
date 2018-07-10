package com.pse.testserver.Unit.Repository;


import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    Post post1;
    Post post2;
    Post post3;

    @Before
    public void setUp() {
        post1 = new Post();
        post2 = new Post();
        post3 = new Post();
        post1.setText("Hallo");
        post2.setText("Hey");
        post3.setText("Sallammm");
        post1.setOwned_by(877777);
        post2.setOwned_by(877777);
        post3.setOwned_by(789456);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
    }

    @Test
    public void Test1() {

        List<Post> foundPostsByOwnedBy = postRepository.findAllOwnedByUser(877777);
        List<Post> foundPosts = new LinkedList<>();
        foundPosts.add(post1);
        foundPosts.add(post2);

        assertTrue(foundPosts.equals(foundPostsByOwnedBy));
    }


}
