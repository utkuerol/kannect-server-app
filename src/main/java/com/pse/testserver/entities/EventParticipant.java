package com.pse.testserver.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "event_participants")
public class EventParticipant implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "event_id")
    private Event event;

    /**
     * Gets user.
     *
     * @return Value of user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets new user.
     *
     * @param user New value of user.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets event.
     *
     * @return Value of event.
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets new event.
     *
     * @param event New value of event.
     */
    public void setEvent(Event event) {
        this.event = event;
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
