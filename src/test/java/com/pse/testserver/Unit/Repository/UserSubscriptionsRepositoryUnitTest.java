package com.pse.testserver.Unit.Repository;

import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.User;
import com.pse.testserver.entities.UserSubscription;
import com.pse.testserver.repository.PostLikeRepository;
import com.pse.testserver.repository.UserSubscriptionRepository;
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
public class UserSubscriptionsRepositoryUnitTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    UserSubscriptionRepository userSubscriptionRepository;

    User user1;
    User user2;
    User user3;

    User savedUser1;
    User savedUser2;
    User savedUser3;


    UserSubscription userSubscription12;
    UserSubscription userSubscription13;
    UserSubscription userSubscription21;
    UserSubscription userSubscription23;
    UserSubscription userSubscription31;
    UserSubscription userSubscription32;


    UserSubscription savedUserSubscription12;
    UserSubscription savedUserSubscription13;
    UserSubscription savedUserSubscription21;
    UserSubscription savedUserSubscription23;
    UserSubscription savedUserSubscription31;
    UserSubscription savedUserSubscription32;


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

        userSubscription12 = new UserSubscription();
        userSubscription13 = new UserSubscription();
        userSubscription21 = new UserSubscription();
        userSubscription23 = new UserSubscription();
        userSubscription31 = new UserSubscription();
        userSubscription32 = new UserSubscription();

        userSubscription12.setSubscribed(savedUser1);
        userSubscription12.setSubscriber(savedUser2);
        savedUserSubscription12 = entityManager.persist(userSubscription12);

        userSubscription13.setSubscribed(savedUser1);
        userSubscription13.setSubscriber(savedUser3);
        savedUserSubscription13 = entityManager.persist(userSubscription13);

        userSubscription21.setSubscribed(savedUser2);
        userSubscription21.setSubscriber(savedUser1);
        savedUserSubscription21 = entityManager.persist(userSubscription21);

        userSubscription23.setSubscribed(savedUser2);
        userSubscription23.setSubscriber(savedUser3);
        savedUserSubscription23 = entityManager.persist(userSubscription23);

        userSubscription31.setSubscribed(savedUser3);
        userSubscription31.setSubscriber(savedUser1);
        savedUserSubscription31 = entityManager.persist(userSubscription31);

        userSubscription32.setSubscribed(savedUser3);
        userSubscription32.setSubscriber(savedUser2);
        savedUserSubscription32 = entityManager.persist(userSubscription32);
    }

    @Test
    public void findBySubscriberAndSubscribedId() {
        assertTrue(userSubscriptionRepository.findBySubscriberAndSubscribedId(savedUser3.getId(), user2.getId()).getId() == savedUserSubscription23.getId());
        assertTrue(userSubscriptionRepository.findBySubscriberAndSubscribedId(savedUser2.getId(), user3.getId()).getId() == savedUserSubscription32.getId());
        assertTrue(userSubscriptionRepository.findBySubscriberAndSubscribedId(savedUser1.getId(), user2.getId()).getId() == savedUserSubscription21.getId());
    }

    @After
    public void tearDown() {
        entityManager.clear();
    }
}
