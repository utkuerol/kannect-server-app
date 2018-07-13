package com.pse.testserver.Unit.Repository;


import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepository;
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
public class UserRepositoryUnitTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    User user1;
    User user2;
    User user3;

    @Before
    public void setup() {
        user1 = new User();
        user2 = new User();
        user3 = new User();
        user1.setName("true");
        user2.setName("truee");
        user3.setName("false");
    }

    @Test
    public void findByNameTest() {
        User user1Saved = entityManager.persist(user1);
        User user2Saved = entityManager.persist(user2);
        User user3Saved = entityManager.persist(user3);

        assertTrue(userRepository.findByName("true").contains(user1Saved));
        assertTrue(userRepository.findByName("true").contains(user2Saved));
        assertFalse(userRepository.findByName("true").contains(user3Saved));
    }


}
