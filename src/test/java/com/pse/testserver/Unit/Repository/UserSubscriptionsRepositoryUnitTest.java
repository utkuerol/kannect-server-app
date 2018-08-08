package com.pse.testserver.Unit.Repository;

import com.pse.testserver.repository.PostLikeRepository;
import com.pse.testserver.repository.UserSubscriptionRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserSubscriptionsRepositoryUnitTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    UserSubscriptionRepository userSubscriptionRepository;
}
