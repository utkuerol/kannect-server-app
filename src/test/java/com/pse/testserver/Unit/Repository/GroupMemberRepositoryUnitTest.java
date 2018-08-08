package com.pse.testserver.Unit.Repository;

import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.GroupMember;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.GroupMemberRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GroupMemberRepositoryUnitTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    GroupMemberRepository groupMemberRepository;

    User user1;
    User user2;
    User user3;

    User savedUser1;
    User savedUser2;
    User savedUser3;

    Group group1;
    Group group2;
    Group group3;

    Group savedGroup1;
    Group savedGroup2;
    Group savedGroup3;


    GroupMember groupMember1;
    GroupMember groupMember2;
    GroupMember groupMember3;

    GroupMember savedGroupMember1;
    GroupMember savedGroupMember2;
    GroupMember savedGroupMember3;

    @Before
    public void setup() {

        user1 = new User();
        user2 = new User();
        user3 = new User();
        user1.setName("true");
        user2.setName("truee");
        user3.setName("false");

        group1 = new Group();
        group2 = new Group();
        group3 = new Group();
        group1.setName("group1");
        group2.setName("group2");
        group3.setName("group3");

        savedUser1 = entityManager.persist(user1);
        savedUser2 = entityManager.persist(user2);
        savedUser3 = entityManager.persist(user3);

        savedGroup1 = entityManager.persist(group1);
        savedGroup2 = entityManager.persist(group2);
        savedGroup3 = entityManager.persist(group3);

        groupMember1 = new GroupMember();
        groupMember2 = new GroupMember();
        groupMember3 = new GroupMember();

        groupMember1.setUser(savedUser1);
        groupMember1.setGroup(savedGroup1);

        groupMember2.setUser(savedUser2);
        groupMember2.setGroup(savedGroup2);

        groupMember3.setUser(savedUser3);
        groupMember3.setGroup(savedGroup3);


        savedGroupMember1 = entityManager.persist(groupMember1);
        savedGroupMember2 = entityManager.persist(groupMember2);
        savedGroupMember3 = entityManager.persist(groupMember3);


    }

    @Test
    public void findAllByUserAndGroupId() {
        assertEquals(groupMemberRepository.findAllByUserAndGroupId(savedUser1.getId(), savedGroup1.getId()), savedGroupMember1);
        assertEquals(groupMemberRepository.findAllByUserAndGroupId(savedUser2.getId(), savedGroup2.getId()), savedGroupMember2);
        assertEquals(groupMemberRepository.findAllByUserAndGroupId(savedUser3.getId(), savedGroup3.getId()), savedGroupMember3);
    }

    @After
    public void tearDown() {
        entityManager.clear();
    }
}
