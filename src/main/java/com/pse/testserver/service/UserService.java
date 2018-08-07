package com.pse.testserver.service;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.EventRepository;
import com.pse.testserver.repository.GroupRepository;
import com.pse.testserver.repository.UserRepository;
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
     * Injected GroupMemberRepository class dependency.
     */
    @Autowired
    GroupMemberRepository groupMemberRepository;


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

    @Autowired
    EventParticipantRepository eventParticipantRepository;

    @Autowired
    UserSubscriptionRepository userSubscriptionRepository;

    /**
     * Searchs and gives all users with the given name.
     * @param name to search for. Empty String parameter gets all users.
     * @return list of users.
     */
    @Transactional
    public List<User> getAllByName(String name) {
        return userRepository.findByName(name);
    }

    /**
     * Gets the user with the given unique id.
     * @param id to search for.
     * @return found user.
     */
    @Transactional
    public User getById(int id) {
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
        if (!userRepository.findById(subscribed.getId()).getSubscribers().contains(subscriber)) {
            UserSubscription userSubscription = new UserSubscription();
            userSubscription.setSubscribed(subscribed);
            userSubscription.setSubscriber(subscriber);
            userSubscriptionRepository.save(userSubscription);
        }
    }

    /**
     * Removes the subscriber user from the subscribed user's list of subscribers and the subscribed user from
     * the subscriber user's list of subscriptions.
     * @param subscriber user, which unsubscribes.
     * @param subscribed user, which gets unsubscribed.
     */
    @Transactional
    public void unsubscribeUser(User subscriber, User subscribed) {
        if (userRepository.findById(subscribed.getId()).getSubscribers().contains(subscriber)) {
            UserSubscription userSubscription = userSubscriptionRepository
                    .findBySubscriberAndSubscribedId(subscriber.getId(), subscribed.getId());
            userSubscriptionRepository.delete(userSubscription);
        }
    }

    /**
     * Adds the given user to the given group's list of members and the group to the user's list of
     * joined groups.
     * @param user which joins the group.
     * @param group to be joined.
     */
    @Transactional
    public void joinGroup(User user, Group group) {

        if (!groupRepository.findById(group.getId()).getMembers().contains(user)) {
            GroupMember gm = new GroupMember();
            gm.setGroup(group);
            gm.setUser(user);
            groupMemberRepository.save(gm);

        }
    }

    /**
     * Removes the given user from the given group's list of members and the group from the user's list of
     * joined groups.
     * @param user which leaves the group.
     * @param group to be left.
     */
    @Transactional
    public void leaveGroup(User user, Group group) {
        GroupMember gm = groupMemberRepository.findAllByUserAndGroupId(user.getId(), group.getId());
        groupMemberRepository.delete(gm);
    }

    /**
     * Adds the given user to the given event's list of participants and the event to the user's list of
     * participated events.
     * @param user which participates in the event.
     * @param event to be participated in.
     */
    @Transactional
    public void participateInEvent(User user, Event event) {
        if (!eventRepository.findById(event.getId()).getParticipants().contains(user)) {
            EventParticipant eventParticipant = new EventParticipant();
            eventParticipant.setUser(user);
            eventParticipant.setEvent(event);
            eventParticipantRepository.save(eventParticipant);
        }

    }

    /**
     * Removes the given user from the given event's list of participants and the event from the user's list of
     * participated events.
     * @param user which leaves the event.
     * @param event to be left.
     */
    @Transactional
    public void leaveEvent(User user, Event event) {
        if (eventRepository.findById(event.getId()).getParticipants().contains(user)) {
            EventParticipant eventParticipant = eventParticipantRepository.findByUserAndEventId(user.getId(), event.getId());
            eventParticipantRepository.delete(eventParticipant);
        }
    }


    @Transactional
    public User getUserByMail(String userMail) {
        System.out.println("on service" + userMail);
        return userRepository.findByMail(userMail);
    }


    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

}
