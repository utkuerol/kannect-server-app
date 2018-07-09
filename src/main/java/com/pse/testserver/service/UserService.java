package com.pse.testserver.service;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.EventRepository;
import com.pse.testserver.repository.GroupRepository;
import com.pse.testserver.repository.UserRepository;
import com.pse.testserver.repository.impl.UserRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class implementing the business logic regarding the user entity, which includes (or may include
 * in future versions) searching, creating, modifying, deleting and other operations which the application needs
 * to perform on mainly user objects.
 * To perform these operations, methods of the injected repository class(es) are to be used.
 */
@Service
public class UserService {

    /**
     * Injected UserRepository class dependency.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Injected UserRepositoryAdvancedImpl class dependency.
     */
    @Autowired
    UserRepositoryAdvancedImpl userRepositoryADV;

    /**
     * Injected GroupRepository class dependency.
     */
    @Autowired
    GroupRepository groupRepository;

    /**
     * Injected EventRepository class dependency.
     */
    @Autowired
    EventRepository eventRepository;

    /**
     * Searchs and gives all users with the given name.
     * @param name to search for. Empty String parameter gets all users.
     * @return list of users.
     */
    @Transactional
    public List<User> getAllByName(String name) {
        return userRepositoryADV.findAllByName(name);
    }

    /**
     * Gets the user with the given unique id.
     * @param id to search for.
     * @return found user.
     */
    @Transactional
    public User getById(long id) {
        return userRepository.findById(id);
    }


    /**
     * Adds the subscriber user to the subscribed user's list of subscribers and the subscribed user to
     * the subscriber user's list of subscriptions.
     * @param subscriber user, which subscribes.
     * @param subscribed user, which gets subscribed.
     */
    @Transactional
    public void subscribeUser(User subscriber, User subscribed) {
        subscriber.getSubscriptions().add(subscribed);
        userRepository.save(subscriber);
        subscribed.getSubscribers().add(subscriber);
        userRepository.save(subscribed);
    }

    /**
     * Removes the subscriber user from the subscribed user's list of subscribers and the subscribed user from
     * the subscriber user's list of subscriptions.
     * @param subscriber user, which unsubscribes.
     * @param subscribed user, which gets unsubscribed.
     */
    @Transactional
    public void unsubscribeUser(User subscriber, User subscribed) {
        subscriber.getSubscriptions().remove(subscribed);
        userRepository.save(subscriber);
        subscribed.getSubscribers().remove(subscriber);
        userRepository.save(subscribed);
    }

    /**
     * Adds the given user to the given group's list of members and the group to the user's list of
     * joined groups.
     * @param user which joins the group.
     * @param group to be joined.
     */
    @Transactional
    public void joinGroup(User user, Group group) {
        user.getJoinedGroups().add(group);
        userRepository.save(user);
        group.getMembers().add(user);
        groupRepository.save(group);
    }

    /**
     * Removes the given user from the given group's list of members and the group from the user's list of
     * joined groups.
     * @param user which leaves the group.
     * @param group to be left.
     */
    @Transactional
    public void leaveGroup(User user, Group group) {
        user.getJoinedGroups().remove(group);
        userRepository.save(user);
        group.getMembers().remove(user);
        groupRepository.save(group);
    }

    /**
     * Adds the given user to the given event's list of participants and the event to the user's list of
     * participated events.
     * @param user which participates in the event.
     * @param event to be participated in.
     */
    @Transactional
    public void participateInEvent(User user, Event event) {
        user.getParticipatedEvents().add(event);
        userRepository.save(user);
        event.getParticipants().add(user);
        eventRepository.save(event);
    }

    /**
     * Removes the given user from the given event's list of participants and the event from the user's list of
     * participated events.
     * @param user which leaves the event.
     * @param event to be left.
     */
    @Transactional
    public void leaveEvent(User user, Event event) {
        user.getParticipatedEvents().remove(event);
        userRepository.save(user);
        event.getParticipants().remove(user);
        eventRepository.save(event);
    }
}
