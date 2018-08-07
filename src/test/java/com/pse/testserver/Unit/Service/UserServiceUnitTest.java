package com.pse.testserver.Unit.Service;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.EventParticipant;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.EventRepository;
import com.pse.testserver.repository.GroupRepository;
import com.pse.testserver.repository.UserRepository;
import com.pse.testserver.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceUnitTest {

    @MockBean
    UserRepository userRepository;
    @MockBean
    GroupRepository groupRepository;
    @MockBean
    EventRepository eventRepository;
    User user1;
    User user2;
    Group group;
    Event event;
    @Autowired
    private UserService userService;

    @Before
    public void setup() {
        user1 = new User();
        user2 = new User();
    }

    @Test
    public void subscribeUserTest() {
        userService.subscribeUser(user1, user2);
        Assert.assertTrue(user1.getSubscriptions().contains(user2)
                && user2.getSubscribers().contains(user1));
    }

    @Test
    public void unsubscribeUserTest() {
        user1.getSubscriptions().add(user2);
        user2.getSubscribers().add(user1);
        userService.unsubscribeUser(user1, user2);
        Assert.assertFalse(user1.getSubscriptions().contains(user2)
                && user2.getSubscribers().contains(user1));
    }

    @Test
    public void joinGroupTest() {
        group = new Group();
        userService.joinGroup(user1, group);
        Assert.assertTrue(user1.getJoinedGroups().contains(group)
                && group.getMembers().contains(user1));
    }

    @Test
    public void leaveGroupTest() {
        group = new Group();
        group.getMembers().add(user1);
        user1.getJoinedGroups().add(group);
        userService.leaveGroup(user1, group);
        Assert.assertFalse(user1.getJoinedGroups().contains(group)
                && group.getMembers().contains(user1));
    }

    @Test
    public void participateInEventTest() {
        event = new Event();
        userService.participateInEvent(user1, event);
        Assert.assertTrue(user1.getEventParticipants().contains(event)
                && event.getEventParticipants().contains(user1));
    }

    @Test
    public void leaveEventTest() {
        EventParticipant eventParticipant = new EventParticipant();
        eventParticipant.setEvent(event);
        eventParticipant.setUser(user1);
        userService.leaveEvent(user1, event);
        Assert.assertFalse(user1.getEventParticipants().contains(event)
                && event.getEventParticipants().contains(user1));
    }

    @TestConfiguration
    public static class UserServiceUnitTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

}
