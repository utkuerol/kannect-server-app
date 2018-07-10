package com.pse.testserver.Unit.Repository;


import com.pse.testserver.AppConfig;

import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

@WebMvcTest
@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {


    @Autowired
    UserRepository userRepository;

    User user1;
    User user2;
    User user3;

    @Before
    public void setUp() {
        user1 = new User();
        user2 = new User();
        user3 = new User();
        user1.setName("true");
        user2.setName("truee");
        user3.setName("false");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    @Test
    public void findByName() {
        List<User> foundUsersByName = userRepository.findByName("true");
        List<User> trueFoundUsersByName = new LinkedList<>();
        trueFoundUsersByName.add(user1);
        trueFoundUsersByName.add(user2);
        trueFoundUsersByName.add(user3);

        assertTrue(foundUsersByName.equals(trueFoundUsersByName));
    }


}
