package com.pse.testserver.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Column(name = "date")
    private Date date;

    public int getId() {
        return id;
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
     * Gets receiver.
     *
     * @return Value of receiver.
     */
    public User getReceiver() {
        return receiver;
    }

    /**
     * Sets new receiver.
     *
     * @param receiver New value of receiver.
     */
    public void setReceiver(User receiver) {
        this.receiver = receiver;
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
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets sender.
     *
     * @return Value of sender.
     */
    public User getSender() {
        return sender;
    }

    /**
     * Sets new sender.
     *
     * @param sender New value of sender.
     */
    public void setSender(User sender) {
        this.sender = sender;
    }
}
