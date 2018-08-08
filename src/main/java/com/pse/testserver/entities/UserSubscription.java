package com.pse.testserver.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_subscriptions")
public class UserSubscription implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "subscriber_id")
    @JsonBackReference(value = "subscriber")
    private User subscriber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "subscribed_id")
    @JsonBackReference(value = "subscribed")
    private User subscribed;


    /**
     * Gets subscribed.
     *
     * @return Value of subscribed.
     */
    public User getSubscribed() {
        return subscribed;
    }

    /**
     * Sets new subscribed.
     *
     * @param subscribed New value of subscribed.
     */
    public void setSubscribed(User subscribed) {
        this.subscribed = subscribed;
    }

    /**
     * Gets subscriber.
     *
     * @return Value of subscriber.
     */
    public User getSubscriber() {
        return subscriber;
    }

    /**
     * Sets new subscriber.
     *
     * @param subscriber New value of subscriber.
     */
    public void setSubscriber(User subscriber) {
        this.subscriber = subscriber;
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
