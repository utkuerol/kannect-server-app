package com.pse.testserver.Unit.Repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.repository.CategoryRepository;
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
public class CategoryRepositoryUnitTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    CategoryRepository categoryRepository;


    Category category1;
    Category category2;
    Category category3;

    @Before
    public void setup() {
        category1 = new Category();
        category2 = new Category();
        category3 = new Category();
        category1.setName("university");
        category2.setName("Bar");
        category3.setName("Bank");
    }

    @Test
    public void findByNameTest() {
        Category category1Saved = entityManager.persist(category1);
        Category category2Saved = entityManager.persist(category2);
        Category category3Saved = entityManager.persist(category3);

        assertTrue(categoryRepository.findByName("university").contains(category1Saved));
        assertTrue(categoryRepository.findByName("Bar").contains(category2Saved));
        assertTrue(categoryRepository.findByName("Bank").contains(category3Saved));

    }


    @After
    public void tearDown() {
        entityManager.clear();
    }


}
