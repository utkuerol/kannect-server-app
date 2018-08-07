package com.pse.testserver.repository;

import com.pse.testserver.entities.EventParticipant;
import com.pse.testserver.entities.PostLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EventParticipantRepository extends CrudRepository<EventParticipant, Integer>  {

    @Query(value = "Select * from event_participants ep where ep.user_id = :userId and ep.event_id = :eventId", nativeQuery = true)
    EventParticipant findByUserAndEventId(@Param("userId") int userId, @Param("eventId") int eventId);
}
