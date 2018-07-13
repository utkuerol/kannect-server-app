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
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GroupRepositoryUnitTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    GroupRepository groupRepository;

    Group group1;
    Group group2;
    Group group3;

    Group group1Saved;
    Group group2Saved;
    Group group3Saved;

    Category category1;
    Category category2;
    Category category3;

    Category category1Saved;
    Category category2Saved;
    Category category3Saved;


    @Before
    public void setup() {
        group1 = new Group();
        group2 = new Group();
        group3 = new Group();

        category1 = new Category();
        category2 = new Category();
        category3 = new Category();

        category1.setName("Cat1");
        category2.setName("Cat2");
        category3.setName("Cat3");

        group1.setName("group1");
        group2.setName("Informatik gruppe");
        group3.setName("FsHc Group");

        category1.getGroups().add(group1);
        category2.getGroups().add(group2);
        category3.getGroups().add(group3);

        category1Saved = entityManager.persist(category1);
        category2Saved = entityManager.persist(category2);
        category3Saved = entityManager.persist(category3);

        group1.setCategory(category1Saved);
        group2.setCategory(category2Saved);
        group3.setCategory(category3Saved);

        group1Saved = entityManager.persist(group1);
        group2Saved = entityManager.persist(group2);
        group3Saved = entityManager.persist(group3);

    }

    @Test
    public void findAllByNameTest(){

        assertTrue(groupRepository.findAllByName("group1").contains(group1Saved));
        assertTrue(groupRepository.findAllByName("Informatik gruppe").contains(group2Saved));
        assertTrue(groupRepository.findAllByName("FsHc Group").contains(group3Saved));
    }

    @Test
    public void findAllByCategoryTest(){

        assertTrue(groupRepository.findAllByCategory(category1Saved.getId()).contains(group1Saved));
        assertTrue(groupRepository.findAllByCategory(category2Saved.getId()).contains(group2Saved));
        assertTrue(groupRepository.findAllByCategory(category3Saved.getId()).contains(group3Saved));

    }


    @Test
    public void findAllByNameSortedByCategoryTest(){

        assertTrue(groupRepository.findAllByNameSortedByCategory("group1", category1Saved.getId()).contains(group1Saved));
        assertTrue(groupRepository.findAllByNameSortedByCategory("Informatik gruppe", category2Saved.getId()).contains(group2Saved));
        assertTrue(groupRepository.findAllByNameSortedByCategory("FsHc Group", category3Saved.getId()).contains(group3Saved));

    }

    @After
    public void tearDown() {
        entityManager.clear();
    }



}
