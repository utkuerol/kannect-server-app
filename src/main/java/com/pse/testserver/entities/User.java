package com.pse.testserver.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mail")
    private String mail;

    @Column(name = "image_url")
    private String image_url;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_subscriptions",
            inverseJoinColumns = {@JoinColumn(name = "subscribed_id")},
            joinColumns = {@JoinColumn(name = "subscriber_id")})
    private Set<User> subscriptions;

    @ManyToMany(mappedBy = "subscriptions")
    private Set<User> subscribers;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "group_members",
            inverseJoinColumns = {@JoinColumn(name = "group_id")},
            joinColumns = {@JoinColumn(name = "user_id")})
    private Set<Group> joinedGroups;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "event_participants",
            inverseJoinColumns = {@JoinColumn(name = "event_id")},
            joinColumns = {@JoinColumn(name = "user_id")})
    private Set<Event> participatedEvents;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> createdPosts;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> createdGroups;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> createdEvents;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> createdComments;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Message> receivedMessages;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Message> sentMessages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Set<User> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<User> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }

    public Set<Group> getJoinedGroups() {
        return joinedGroups;
    }

    public void setJoinedGroups(Set<Group> joinedGroups) {
        this.joinedGroups = joinedGroups;
    }

    public Set<Event> getParticipatedEvents() {
        return participatedEvents;
    }

    public void setParticipatedEvents(Set<Event> participatedEvents) {
        this.participatedEvents = participatedEvents;
    }

    public Set<Post> getCreatedPosts() {
        return createdPosts;
    }

    public void setCreatedPosts(Set<Post> createdPosts) {
        this.createdPosts = createdPosts;
    }

    public Set<Group> getCreatedGroups() {
        return createdGroups;
    }

    public void setCreatedGroups(Set<Group> createdGroups) {
        this.createdGroups = createdGroups;
    }

    public Set<Event> getCreatedEvents() {
        return createdEvents;
    }

    public void setCreatedEvents(Set<Event> createdEvents) {
        this.createdEvents = createdEvents;
    }

    public Set<Comment> getCreatedComments() {
        return createdComments;
    }

    public void setCreatedComments(Set<Comment> createdComments) {
        this.createdComments = createdComments;
    }

    public Set<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(Set<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public Set<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(Set<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }
}
