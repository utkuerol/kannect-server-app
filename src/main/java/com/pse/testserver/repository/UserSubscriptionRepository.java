package com.pse.testserver.repository;

import com.pse.testserver.entities.UserSubscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserSubscriptionRepository extends CrudRepository<UserSubscription, Integer> {

    @Query(value = "Select * from user_subscriptions us where us.subscriber_id = :subscriberId and us.subscribed_id = :subscribedId", nativeQuery = true)
    UserSubscription findBySubscriberAndSubscribedId(@Param("subscriberId") int subscriberId, @Param("subscribedId") int subscribedId);
}
