package com.pse.testserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Entity class for the persisted event data from the "events" table.
 * Represents an event, providing access to the event's unique id, name, description, category, subcategory,
 * creator, profile picture url and eventParticipants .
 */
@Entity
@Table(name = "events")
public class Event {

    /**
     * Users, which participate in this event.
     */
    @OneToMany(mappedBy = "event")
    @JsonBackReference(value = "eventparticipantsevent")
    private List<EventParticipant> eventParticipants;

    @Transient
    private List<User> participants;

    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Name of the event.
     */
    @Column(name = "name", columnDefinition = "LONGTEXT")
    private String name;
    
    /**
     * Date of the event.
     */
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Description of the event, containing extra information intended to be given from the user.
     */
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    /**
     * User, which created this event.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    @JsonBackReference(value = "eventuser")
    private User creator;

    /**
     * Category, into which this event falls.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "eventcategory")
    private Category category;

    /**
     * Subcategory, into which this event falls.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    @JsonBackReference(value = "eventsubcategory")
    private Subcategory subcategory;

    /**
     * Url of the profile picture.
     */
    @Column(name = "image_url")
    private String image_url;

    public Event() {
        this.eventParticipants = new LinkedList<>();
    }

    /**
     * Gets category.
     *
     * @return Value of category.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets new category.
     *
     * @param category New value of category.
     */
    public void setCategory(Category category) {
        this.category = category;
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
     * Gets eventParticipants.
     *
     * @return Value of eventParticipants.
     */
    public List<EventParticipant> getEventParticipants() {
        return eventParticipants;
    }

    /**
     * Sets new eventParticipants.
     *
     * @param eventParticipants New value of eventParticipants.
     */
    public void setEventParticipants(List<EventParticipant> eventParticipants) {
        this.eventParticipants = eventParticipants;
    }

    /**
     * Gets description.
     *
     * @return Value of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new description.
     *
     * @param description New value of description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets image_url.
     *
     * @return Value of image_url.
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     * Sets new image_url.
     *
     * @param image_url New value of image_url.
     */
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * Gets subcategory.
     *
     * @return Value of subcategory.
     */
    public Subcategory getSubcategory() {
        return subcategory;
    }

    /**
     * Sets new subcategory.
     *
     * @param subcategory New value of subcategory.
     */
    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Event other = ((Event) obj);

        return id == other.id;
    }

    /**
     * Gets participants.
     *
     * @return Value of participants.
     */
    public List<User> getParticipants() {
        List<User> participants = new LinkedList<>();
        for (EventParticipant eventParticipant : eventParticipants) {
            participants.add(eventParticipant.getUser());
        }
        return participants;
    }

    /**
     * Sets new participants.
     *
     * @param participants New value of participants.
     */
    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}