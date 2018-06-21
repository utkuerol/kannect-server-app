package com.pse.testserver.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity class for the persisted user data from the "users" table.
 * Represents a user, providing access to the user's unique id, e-mail information, profile picture,
 * subscriptions, subscribers, joined and created groups, participated and created events, created posts and comments,
 * received and sent messages
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    /**
     * Name of this user.
     */
    @Column(name = "name")
    private String name;

    /**
     * E-Mail address.
     */
    @Column(name = "mail")
    private String email;

    /**
     * Url of the profile picture.
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * Users, which this user subscribes.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_subscriptions",
            inverseJoinColumns = {@JoinColumn(name = "subscribed_id")},
            joinColumns = {@JoinColumn(name = "subscriber_id")})
    private Set<User> subscriptions;

    /**
     * Users, which subscribe this user.
     */
    @ManyToMany(mappedBy = "subscriptions")
    private Set<User> subscribers;

    /**
     * Groups, which this user has joined.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "group_members",
            inverseJoinColumns = {@JoinColumn(name = "group_id")},
            joinColumns = {@JoinColumn(name = "user_id")})
    private Set<Group> joinedGroups;

    /**
     * Events, in which this user has participated.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "event_participants",
            inverseJoinColumns = {@JoinColumn(name = "event_id")},
            joinColumns = {@JoinColumn(name = "user_id")})
    private Set<Event> participatedEvents;

    /**
     * Posts, which this user has created.
     */
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> createdPosts;

    /**
     * Groups, which this user has created.
     */
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> createdGroups;

    /**
     * Events, which this user has created.
     */
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> createdEvents;

    /**
     * Comments, which this user has created.
     */
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> createdComments;

    /**
     * Messages, which this user has received.
     */
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Message> receivedMessages;

    /**
     * Messages, which this user has sent.
     */
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Message> sentMessages;

    /**
     * Gets createdGroups.
     *
     * @return Value of createdGroups.
     */
    public Set<Group> getCreatedGroups() {
        return createdGroups;
    }

    /**
     * Sets new createdGroups.
     *
     * @param createdGroups New value of createdGroups.
     */
    public void setCreatedGroups(Set<Group> createdGroups) {
        this.createdGroups = createdGroups;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets receivedMessages.
     *
     * @return Value of receivedMessages.
     */
    public Set<Message> getReceivedMessages() {
        return receivedMessages;
    }

    /**
     * Sets new receivedMessages.
     *
     * @param receivedMessages New value of receivedMessages.
     */
    public void setReceivedMessages(Set<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    /**
     * Gets sentMessages.
     *
     * @return Value of sentMessages.
     */
    public Set<Message> getSentMessages() {
        return sentMessages;
    }

    /**
     * Sets new sentMessages.
     *
     * @param sentMessages New value of sentMessages.
     */
    public void setSentMessages(Set<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    /**
     * Gets createdEvents.
     *
     * @return Value of createdEvents.
     */
    public Set<Event> getCreatedEvents() {
        return createdEvents;
    }

    /**
     * Sets new createdEvents.
     *
     * @param createdEvents New value of createdEvents.
     */
    public void setCreatedEvents(Set<Event> createdEvents) {
        this.createdEvents = createdEvents;
    }

    /**
     * Gets createdPosts.
     *
     * @return Value of createdPosts.
     */
    public Set<Post> getCreatedPosts() {
        return createdPosts;
    }

    /**
     * Sets new createdPosts.
     *
     * @param createdPosts New value of createdPosts.
     */
    public void setCreatedPosts(Set<Post> createdPosts) {
        this.createdPosts = createdPosts;
    }

    /**
     * Gets joinedGroups.
     *
     * @return Value of joinedGroups.
     */
    public Set<Group> getJoinedGroups() {
        return joinedGroups;
    }

    /**
     * Sets new joinedGroups.
     *
     * @param joinedGroups New value of joinedGroups.
     */
    public void setJoinedGroups(Set<Group> joinedGroups) {
        this.joinedGroups = joinedGroups;
    }

    /**
     * Gets createdComments.
     *
     * @return Value of createdComments.
     */
    public Set<Comment> getCreatedComments() {
        return createdComments;
    }

    /**
     * Sets new createdComments.
     *
     * @param createdComments New value of createdComments.
     */
    public void setCreatedComments(Set<Comment> createdComments) {
        this.createdComments = createdComments;
    }

    /**
     * Gets mail.
     *
     * @return Value of mail.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets new mail.
     *
     * @param email New value of mail.
     */
    public void setMail(String email) {
        this.email = email;
    }

    /**
     * Gets participatedEvents.
     *
     * @return Value of participatedEvents.
     */
    public Set<Event> getParticipatedEvents() {
        return participatedEvents;
    }

    /**
     * Sets new participatedEvents.
     *
     * @param participatedEvents New value of participatedEvents.
     */
    public void setParticipatedEvents(Set<Event> participatedEvents) {
        this.participatedEvents = participatedEvents;
    }

    /**
     * Gets subscribers.
     *
     * @return Value of subscribers.
     */
    public Set<User> getSubscribers() {
        return subscribers;
    }

    /**
     * Sets new subscribers.
     *
     * @param subscribers New value of subscribers.
     */
    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }

    /**
     * Gets image_url.
     *
     * @return Value of image_url.
     */
    public String getImage_url() {
        return imageUrl;
    }

    /**
     * Sets new image_url.
     *
     * @param imageUrl New value of image_url.
     */
    public void setImage_url(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets subscriptions.
     *
     * @return Value of subscriptions.
     */
    public Set<User> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Sets new subscriptions.
     *
     * @param subscriptions New value of subscriptions.
     */
    public void setSubscriptions(Set<User> subscriptions) {
        this.subscriptions = subscriptions;
    }


    /**
     * Gets Url of the profile picture..
     *
     * @return Value of Url of the profile picture..
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets new Url of the profile picture..
     *
     * @param imageUrl New value of Url of the profile picture..
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets Name of this user..
     *
     * @return Value of Name of this user..
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new Name of this user..
     *
     * @param name New value of Name of this user..
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets new E-Mail address..
     *
     * @param email New value of E-Mail address..
     */
    public void setEmail(String email) {
        this.email = email;
    }
}