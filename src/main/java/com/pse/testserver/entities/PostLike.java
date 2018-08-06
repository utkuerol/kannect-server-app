package com.pse.testserver.entities;


import javax.persistence.*;

@Entity
@Table(name = "post_likes")
public class PostLike {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User likedUser;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_id")
    private Post likedPost;

    /**
     * Gets likedPost.
     *
     * @return Value of likedPost.
     */
    public Post getLikedPost() {
        return likedPost;
    }

    /**
     * Sets new likedPost.
     *
     * @param likedPost New value of likedPost.
     */
    public void setLikedPost(Post likedPost) {
        this.likedPost = likedPost;
    }

    /**
     * Gets likedUser.
     *
     * @return Value of likedUser.
     */
    public User getLikedUser() {
        return likedUser;
    }

    /**
     * Sets new likedUser.
     *
     * @param likedUser New value of likedUser.
     */
    public void setLikedUser(User likedUser) {
        this.likedUser = likedUser;
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
}
