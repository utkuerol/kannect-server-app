package com.pse.testserver.Repositiory;


import com.pse.testserver.AppConfig;

import com.pse.testserver.repository.UserRepository;
import com.pse.testserver.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class UserRepositoryTest {


    @Autowired
    @Qualifier("userService")
    UserRepository userRepository;

    @Test
    public void test_ml_always_return_true() {
    }


}
