package com.pse.testserver.Unit.Repository;


import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Group;
import com.pse.testserver.repository.GroupRepository;
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

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GroupRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    GroupRepository groupRepository;

    Group group1;
    Group group2;
    Group group3;



    Category category1;
    Category category2;
    Category category3;


    @Before
    public void setup() {
        group1 = new Group();
        group2 = new Group();
        group3 = new Group();

        category1 = new Category();
        category2 = new Category();
        category3 = new Category();


        group1.setName("group1");
        category1.setName("Cat1");
        group1.setCategory(category1);


        group2.setName("Informatik gruppe");
        category2.setName("Cat2");
        group2.setCategory(category1);


        group3.setName("FsHc Group");
        category3.setName("Cat3");
        group3.setCategory(category1);

    }

    @Test
    public void findAllByNameTest(){
        Group group1Saved = entityManager.persist(group1);
        Group group2Saved = entityManager.persist(group2);
        Group group3Saved = entityManager.persist(group3);

        assertTrue(groupRepository.findAllByName("group1").contains(group1Saved));
        assertTrue(groupRepository.findAllByName("Informatik gruppe").contains(group2Saved));
        assertTrue(groupRepository.findAllByName("FsHc Group").contains(group3Saved));
    }

    @Test
    public void findAllByCategoryTest(){
        Group group1Saved = entityManager.persist(group1);
        Group group2Saved = entityManager.persist(group2);
        Group group3Saved = entityManager.persist(group3);

        //no getters/setters for id in Category
        assertTrue(groupRepository.findAllByCategory(category1.getId()).contains(group1Saved));
        assertTrue(groupRepository.findAllByCategory(category2.getId()).contains(group2Saved));
        assertTrue(groupRepository.findAllByCategory(category2.getId()).contains(group3Saved));

    }


    @Test
    public void findAllByNameSortedByCategoryTest(){
        Group group1Saved = entityManager.persist(group1);
        Group group2Saved = entityManager.persist(group2);
        Group group3Saved = entityManager.persist(group3);

        //no getters/setters for id in Category
        assertTrue(groupRepository.findAllByNameSortedByCategory("group1",category1.getId()).contains(group1Saved));
        assertTrue(groupRepository.findAllByNameSortedByCategory("Informatik gruppe",category2.getId()).contains(group2Saved));
        assertTrue(groupRepository.findAllByNameSortedByCategory("FsHc Group",category2.getId()).contains(group3Saved));

    }

    @After
    public void tearDown() {
        entityManager.clear();
    }



}
