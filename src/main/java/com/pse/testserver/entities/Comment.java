package com.pse.testserver.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private int id;

    /**
     * User-created text to be displayed in the comment.
     */
    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;

    /**
     * Post, to which this comment belongs.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonBackReference
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
    @JsonBackReference
    private User creator;


    /**
     * Sets new Creation date of this comment..
     *
     * @param date New value of Creation date of this comment..
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets User-created text to be displayed in the comment..
     *
     * @return Value of User-created text to be displayed in the comment..
     */
    public String getText() {
        return text;
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
     * Sets new User, which created this comment..
     *
     * @param creator New value of User, which created this comment..
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * Gets User, which created this comment..
     *
     * @return Value of User, which created this comment..
     */
    public User getCreator() {
        return creator;
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
     * Gets Post, to which this comment belongs..
     *
     * @return Value of Post, to which this comment belongs..
     */
    public Post getPost() {
        return post;
    }

    /**
     * Gets Creation date of this comment..
     *
     * @return Value of Creation date of this comment..
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets new User-created text to be displayed in the comment..
     *
     * @param text New value of User-created text to be displayed in the comment..
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets new Post, to which this comment belongs..
     *
     * @param post New value of Post, to which this comment belongs..
     */
    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Comment other = ((Comment) obj);

        return id == other.id;
    }
}