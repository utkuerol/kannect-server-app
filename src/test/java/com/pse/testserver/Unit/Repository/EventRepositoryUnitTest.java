package com.pse.testserver.Unit.Repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.repository.EventRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryUnitTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    EventRepository eventRepository;

    Event event1;
    Event event2;
    Event event3;

    Event event1Saved;
    Event event2Saved;
    Event event3Saved;

    Category category1;
    Category category2;
    Category category3;

    Category category1Saved;
    Category category2Saved;
    Category category3Saved;

    @Before
    public void setup() {
        event1 = new Event();
        event2 = new Event();
        event3 = new Event();

        category1 = new Category();
        category2 = new Category();
        category3 = new Category();

        event1.setName("InfoTag");
        LocalDate today = LocalDate.now();
        today.minusDays(3);
        Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        event1.setDate(date);

        event2.setName("MatheTag");
        today.minusDays(4);
        date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        event2.setDate(date);

        event3.setName("ProgTag");
        today.minusDays(5);
        date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        event3.setDate(date);

        category1.setName("Cat1");
        category2.setName("Cat2");
        category3.setName("Cat3");

        category1.getEvents().add(event1);
        category2.getEvents().add(event2);
        category3.getEvents().add(event3);

        category1Saved = entityManager.persist(category1);
        category2Saved = entityManager.persist(category2);
        category3Saved = entityManager.persist(category3);

        event1.setCategory(category1Saved);
        event2.setCategory(category2Saved);
        event3.setCategory(category3Saved);

        event1Saved = entityManager.persist(event1);
        event2Saved = entityManager.persist(event2);
        event3Saved = entityManager.persist(event3);
    }

    @Test
    public void findAllByDateTest(){


        LocalDate today = LocalDate.now();
        today.minusDays(3);

        Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());

        assertTrue(eventRepository.findAllByDate(date).contains(event1Saved));
        today.minusDays(4);

        date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());

        assertTrue(eventRepository.findAllByDate(date).contains(event2Saved));

        today.minusDays(5);
        date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());

        assertTrue(eventRepository.findAllByDate(date).contains(event3Saved));

    }


    @Test
    public void findByNameSortedByDateTest(){

        assertTrue(eventRepository.findByNameSortedByDate("InfoTag").contains(event1Saved));
        assertTrue(eventRepository.findByNameSortedByDate("MatheTag").contains(event2Saved));
        assertTrue(eventRepository.findByNameSortedByDate("ProgTag").contains(event3Saved));
    }

    @Test
    public void findAllByNameSortedByCategoryTest(){

        assertTrue(eventRepository.findAllByNameSortedByCategory("InfoTag",category1.getId()).contains(event1Saved));
        assertTrue(eventRepository.findAllByNameSortedByCategory("MatheTag",category2.getId()).contains(event2Saved));
        assertTrue(eventRepository.findAllByNameSortedByCategory("ProgTag",category3.getId()).contains(event3Saved));


    }


    @Test
    public void findAllSortedByDateTest(){

        LinkedList<Event> testList = new LinkedList<>();
        testList.add(event1Saved);
        testList.add(event2Saved);
        testList.add(event3Saved);

        assertTrue(eventRepository.findAllSortedByDate().equals(testList));

    }


    @After
    public void tearDown() {
        entityManager.clear();
    }
}
