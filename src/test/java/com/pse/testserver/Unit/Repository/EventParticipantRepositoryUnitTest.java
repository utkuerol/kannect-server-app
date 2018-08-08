package com.pse.testserver.Unit.Repository;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.EventParticipant;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.CategoryRepository;
import com.pse.testserver.repository.EventParticipantRepository;
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
public class EventParticipantRepositoryUnitTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    EventParticipantRepository eventParticipantRepository;

    User user1;
    User user2;
    User user3;

    User savedUser1;
    User savedUser2;
    User savedUser3;

    Event event1;
    Event event2;
    Event event3;

    Event savedEvent1;
    Event savedEvent2;
    Event savedEvent3;

    EventParticipant eventParticipant1;
    EventParticipant eventParticipant2;
    EventParticipant eventParticipant3;

    EventParticipant savedEventParticipant1;
    EventParticipant savedEventParticipant2;
    EventParticipant savedEventParticipant3;

    @Before
    public void setup() {

        user1 = new User();
        user2 = new User();
        user3 = new User();

        user1.setName("true");
        user2.setName("truee");
        user3.setName("false");

        savedUser1 = entityManager.persist(user1);
        savedUser2 = entityManager.persist(user2);
        savedUser3 = entityManager.persist(user3);

        event1 = new Event();
        event2 = new Event();
        event3 = new Event();

        event1.setName("Event 1");
        event2.setName("Event 2");
        event3.setName("Event 3");

        savedEvent1 = entityManager.persist(event1);
        savedEvent2 = entityManager.persist(event2);
        savedEvent3 = entityManager.persist(event3);

        eventParticipant1 = new EventParticipant();
        eventParticipant2 = new EventParticipant();
        eventParticipant3 = new EventParticipant();

        eventParticipant1.setEvent(savedEvent1);
        eventParticipant1.setUser(savedUser1);
        savedEventParticipant1 = entityManager.persist(eventParticipant1);

        eventParticipant2.setEvent(savedEvent2);
        eventParticipant2.setUser(savedUser2);
        savedEventParticipant2 = entityManager.persist(eventParticipant2);

        eventParticipant3.setEvent(savedEvent3);
        eventParticipant3.setUser(savedUser3);
        savedEventParticipant3 = entityManager.persist(eventParticipant3);

    }

    @Test
    public void findByUserAndEventId() {
        assertTrue(eventParticipantRepository.findByUserAndEventId(savedUser1.getId(), savedEvent1.getId()).getId() == savedEventParticipant1.getId());
        assertTrue(eventParticipantRepository.findByUserAndEventId(savedUser2.getId(), savedEvent2.getId()).getId() == savedEventParticipant2.getId());
        assertTrue(eventParticipantRepository.findByUserAndEventId(savedUser3.getId(), savedEvent3.getId()).getId() == savedEventParticipant3.getId());
    }
}
