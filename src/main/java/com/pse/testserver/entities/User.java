package com.pse.testserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Entity class for the persisted user data from the "users" table.
 * Represents a user, providing access to the user's unique id, e-mail information, profile picture,
 * subscriptions, subscribers, joined and created groups, participated and created events, created posts and comments,
 * received and sent messages
 */
@Entity
@Table(name = "users")
@Embeddable
public class User implements Serializable {



    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    /**
     * Name of this user.
     */
    @Column(name = "name", columnDefinition = "LONGTEXT")
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
    @Fetch(value = FetchMode.SUBSELECT)
    private List<User> subscriptions;

    /**
     * Users, which subscribe this user.
     */
    @ManyToMany(mappedBy = "subscriptions")
    private List<User> subscribers;

    /**
     * Groups, which this user has joined.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "group_members",
            inverseJoinColumns = {@JoinColumn(name = "group_id")},
            joinColumns = {@JoinColumn(name = "user_id")})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Group> joinedGroups;

    /**
     * Events, in which this user has participated.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "event_participants",
            inverseJoinColumns = {@JoinColumn(name = "event_id")},
            joinColumns = {@JoinColumn(name = "user_id")})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Event> participatedEvents;

    /**
     * Posts, which are liked by this user.
     */
    @OneToMany(mappedBy = "likedUser")
    @JsonBackReference(value = "postlikeuser")
    private List<PostLike> likedPosts;

    /**
     * Posts, which this user has created.
     */
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    @JsonBackReference(value = "postuser")
    private List<Post> createdPosts;

    /**
     * Groups, which this user has created.
     */
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "groupuser")
    private List<Group> createdGroups;

    /**
     * Events, which this user has created.
     */
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "eventuser")
    private List<Event> createdEvents;

    /**
     * Comments, which this user has created.
     */
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "commentuser")
    private List<Comment> createdComments;


    public User() {
        this.subscriptions = new LinkedList<>();
        this.subscribers = new LinkedList<>();
        this.joinedGroups = new LinkedList<>();
        this.participatedEvents = new LinkedList<>();
        this.likedPosts = new LinkedList<>();
        this.createdPosts = new LinkedList<>();
        this.createdGroups = new LinkedList<>();
        this.createdEvents = new LinkedList<>();
        this.createdComments = new LinkedList<>();

    }


    /**
     * Sets new Comments, which this user has created..
     *
     * @param createdComments New value of Comments, which this user has created..
     */
    public void setCreatedComments(List<Comment> createdComments) {
        this.createdComments = createdComments;
    }

    /**
     * Gets Events, which this user has created..
     *
     * @return Value of Events, which this user has created..
     */
    public List<Event> getCreatedEvents() {
        return createdEvents;
    }

    /**
     * Sets new Posts, which this user has created..
     *
     * @param createdPosts New value of Posts, which this user has created..
     */
    public void setCreatedPosts(List<Post> createdPosts) {
        this.createdPosts = createdPosts;
    }

    /**
     * Sets new Groups, which this user has joined..
     *
     * @param joinedGroups New value of Groups, which this user has joined..
     */
    public void setJoinedGroups(List<Group> joinedGroups) {
        this.joinedGroups = joinedGroups;
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
     * Gets Posts, which this user has created..
     *
     * @return Value of Posts, which this user has created..
     */
    public List<Post> getCreatedPosts() {
        return createdPosts;
    }

    /**
     * Gets E-Mail address..
     *
     * @return Value of E-Mail address..
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets Groups, which this user has created..
     *
     * @return Value of Groups, which this user has created..
     */
    public List<Group> getCreatedGroups() {
        return createdGroups;
    }

    /**
     * Gets Posts, which are liked by this user..
     *
     * @return Value of Posts, which are liked by this user..
     */
    public List<PostLike> getLikedPosts() {
        return likedPosts;
    }

    /**
     * Gets Users, which subscribe this user..
     *
     * @return Value of Users, which subscribe this user..
     */
    public List<User> getSubscribers() {
        return subscribers;
    }

    /**
     * Gets Groups, which this user has joined..
     *
     * @return Value of Groups, which this user has joined..
     */
    public List<Group> getJoinedGroups() {
        return joinedGroups;
    }

    /**
     * Sets new Incremental generated unique id..
     *
     * @param id New value of Incremental generated unique id..
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets Users, which this user subscribes..
     *
     * @return Value of Users, which this user subscribes..
     */
    public List<User> getSubscriptions() {
        return subscriptions;
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
     * Gets Events, in which this user has participated..
     *
     * @return Value of Events, in which this user has participated..
     */
    public List<Event> getParticipatedEvents() {
        return participatedEvents;
    }

    /**
     * Sets new Events, in which this user has participated..
     *
     * @param participatedEvents New value of Events, in which this user has participated..
     */
    public void setParticipatedEvents(List<Event> participatedEvents) {
        this.participatedEvents = participatedEvents;
    }

    /**
     * Sets new Users, which subscribe this user..
     *
     * @param subscribers New value of Users, which subscribe this user..
     */
    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    /**
     * Gets Incremental generated unique id..
     *
     * @return Value of Incremental generated unique id..
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new Groups, which this user has created..
     *
     * @param createdGroups New value of Groups, which this user has created..
     */
    public void setCreatedGroups(List<Group> createdGroups) {
        this.createdGroups = createdGroups;
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
     * Sets new Posts, which are liked by this user..
     *
     * @param likedPosts New value of Posts, which are liked by this user..
     */
    public void setLikedPosts(List<PostLike> likedPosts) {
        this.likedPosts = likedPosts;
    }

    /**
     * Sets new E-Mail address..
     *
     * @param email New value of E-Mail address..
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets Comments, which this user has created..
     *
     * @return Value of Comments, which this user has created..
     */
    public List<Comment> getCreatedComments() {
        return createdComments;
    }

    /**
     * Sets new Users, which this user subscribes..
     *
     * @param subscriptions New value of Users, which this user subscribes..
     */
    public void setSubscriptions(List<User> subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * Sets new Events, which this user has created..
     *
     * @param createdEvents New value of Events, which this user has created..
     */
    public void setCreatedEvents(List<Event> createdEvents) {
        this.createdEvents = createdEvents;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        User other = ((User) obj);

        return id == other.getId();
    }


}