package com.pse.testserver.Unit.Repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.EventRepository;
import com.pse.testserver.repository.PostRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.junit4.SpringRunner;
import sun.awt.image.ImageWatched;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    EventRepository eventRepository;

    Event event1;
    Event event2;
    Event event3;

    Category category1;
    Category category2;
    Category category3;


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
        category1 = new Category();
        category1.setName("Cat1");
        event1.setCategory(category1);


        event2.setName("MatheTag");
        today.minusDays(4);
        date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        event2.setDate(date);
        category2 = new Category();
        category2.setName("Cat2");
        event2.setCategory(category2);


        event3.setName("ProgTag");
        today.minusDays(5);
        date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        event3.setDate(date);
        category3 = new Category();
        category3.setName("Cat3");
        event3.setCategory(category3);

    }

    @Test
    public void findAllByDateTest(){
        Event event1Saved = entityManager.persist(event1);
        Event event2Saved = entityManager.persist(event2);
        Event event3Saved = entityManager.persist(event3);
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
        Event event1Saved = entityManager.persist(event1);
        Event event2Saved = entityManager.persist(event2);
        Event event3Saved = entityManager.persist(event3);

        assertTrue(eventRepository.findByNameSortedByDate("InfoTag").contains(event1Saved));
        assertTrue(eventRepository.findByNameSortedByDate("MatheTag").contains(event2Saved));
        assertTrue(eventRepository.findByNameSortedByDate("ProgTag").contains(event3Saved));
    }

    @Test
    public void findAllByNameSortedByCategoryTest(){
        Event event1Saved = entityManager.persist(event1);
        Event event2Saved = entityManager.persist(event2);
        Event event3Saved = entityManager.persist(event3);

       //no getters/setters for id in Category
        assertTrue(eventRepository.findAllByNameSortedByCategory("InfoTag",category1.getId()).contains(event1Saved));
        assertTrue(eventRepository.findAllByNameSortedByCategory("MatheTag",category2.getId()).contains(event2Saved));
        assertTrue(eventRepository.findAllByNameSortedByCategory("ProgTag",category3.getId()).contains(event3Saved));


    }


    @Test
    public void findAllSortedByDateTest(){
        Event event1Saved = entityManager.persist(event1);
        Event event2Saved = entityManager.persist(event2);
        Event event3Saved = entityManager.persist(event3);

        LinkedList<Event> testList = new LinkedList<Event>();
        testList.add(event1);
        testList.add(event2);
        testList.add(event3);

        assertTrue(eventRepository.findAllSortedByDate().equals(testList));

    }


    @After
    public void tearDown() {
        entityManager.clear();
    }
}
