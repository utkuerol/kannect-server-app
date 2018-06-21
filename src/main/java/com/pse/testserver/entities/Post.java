package com.pse.testserver.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Entity class for the persisted post data from the "posts" table.
 * Represents a post, providing access to the post's unique id, text, creator,
 * number of likes, date of creation, comments and the information on whether
 * it is owned by a user, a group or an event.
 */
@Entity
@Table(name = "post")
public class Post implements Serializable {

    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * User-created text to be displayed in the post.
     */
    @Column(name = "text")
    private String text;

    /**
     * User, which created this post.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    /**
     * Number of likes of this post. Incremented when liked by users.
     */
    @Column(name = "number_of_likes")
    private int number_of_likes;

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
    private Set<Comment> comments;

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
     * Gets comments.
     *
     * @return Value of comments.
     */
    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * Sets new comments.
     *
     * @param comments New value of comments.
     */
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
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
     * Gets number_of_likes.
     *
     * @return Value of number_of_likes.
     */
    public int getNumber_of_likes() {
        return number_of_likes;
    }

    /**
     * Sets new number_of_likes.
     *
     * @param number_of_likes New value of number_of_likes.
     */
    public void setNumber_of_likes(int number_of_likes) {
        this.number_of_likes = number_of_likes;
    }
}