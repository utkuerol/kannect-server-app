package com.pse.testserver.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Entity class for the persisted post data from the "posts" table.
 * Represents a post, providing access to the post's unique id, text, creator,
 * number of likes, date of creation, comments and the information on whether
 * it is owned by a user, a group or an event.
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    public Post() {
        this.comments = new LinkedList<>();
        this.likedUsers = new LinkedList<>();
    }

    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * User-created text to be displayed in the post.
     */
    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;

    /**
     * User, which created this post.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;


    /**
     * Creation date of this post.
     */
    @Column(name = "date")
    private Date date;

    /**
     * Gives information on whether this post is owned by a user, a group or an event.
     * This information is needed to determine where to display the post on the client-side.
     */
    //TODO how does this work? enum?
    @Column(name = "OWNED_BY")
    private int owned_by;

    /**
     * Comments, which have been created regarding this post.
     */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @ManyToMany(mappedBy = "likedPosts")
    private List<User> likedUsers;

    /**
     * Gets creator.
     *
     * @return Value of creator.
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Sets new creator.
     *
     * @param creator New value of creator.
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * Gets owned_by.
     *
     * @return Value of owned_by.
     */
    public int getOwned_by() {
        return owned_by;
    }

    /**
     * Sets new owned_by.
     *
     * @param owned_by New value of owned_by.
     */
    public void setOwned_by(int owned_by) {
        this.owned_by = owned_by;
    }

    /**
     * Gets date.
     *
     * @return Value of date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets new date.
     *
     * @param date New value of date.
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * Gets text.
     *
     * @return Value of text.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets new text.
     *
     * @param text New value of text.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets number_of_likes.
     *
     * @return Value of number_of_likes.
     */
    public int getNumber_of_likes() {
        return likedUsers.size();
    }


    /**
     * Gets Comments, which have been created regarding this post..
     *
     * @return Value of Comments, which have been created regarding this post..
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Sets new likedUsers.
     *
     * @param likedUsers New value of likedUsers.
     */
    public void setLikedUsers(List<User> likedUsers) {
        this.likedUsers = likedUsers;
    }

    /**
     * Sets new Comments, which have been created regarding this post..
     *
     * @param comments New value of Comments, which have been created regarding this post..
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Gets likedUsers.
     *
     * @return Value of likedUsers.
     */
    public List<User> getLikedUsers() {
        return likedUsers;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Post other = ((Post) obj);

        return id == other.id;
    }

}