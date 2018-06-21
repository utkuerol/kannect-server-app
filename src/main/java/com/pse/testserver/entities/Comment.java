package com.pse.testserver.entities;


import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for the persisted comment data from the "comments" table.
 * Represents a comment, providing access to the comment's unique id, text, creator, belonging post and
 * date of creation
 */
@Entity
@Table(name = "comments")
public class Comment {

    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * User-created text to be displayed in the comment.
     */
    @Column(name = "text")
    private String text;

    /**
     * Post, to which this comment belongs.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    /**
     * Creation date of this comment.
     */
    @Column(name = "date")
    private Date date;

    /**
     * User, which created this comment.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;


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
     * Gets post.
     *
     * @return Value of post.
     */
    public Post getPost() {
        return post;
    }

    /**
     * Sets new post.
     *
     * @param post New value of post.
     */
    public void setPost(Post post) {
        this.post = post;
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
}