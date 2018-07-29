package com.pse.testserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Entity class for the persisted subcategory data from the "subcategories" table.
 * Represents a subcategory, providing access to the subcategory's unique id, name, parent category,
 * groups and events.
 */
@Entity
@Table(name = "subcategories")
public class Subcategory {

    public Subcategory() {
        this.events = new LinkedList<>();
        this.groups = new LinkedList<>();
    }

    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Name of the subcategory.
     */
    @Column(name = "name", columnDefinition = "LONGTEXT")
    private String name;

    /**
     * Parent category of this subcategory.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "subcategorycategory")
    private Category category;

    /**
     * Events, which fall into this subcategory.
     */
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "eventsubcategory")
    private List<Event> events;

    /**
     * Groups, which fall into this subcategory.
     */
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "groupsubcategory")
    private List<Group> groups;


    /**
     * Sets new Incremental generated unique id..
     *
     * @param id New value of Incremental generated unique id..
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets new Groups, which fall into this subcategory..
     *
     * @param groups New value of Groups, which fall into this subcategory..
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * Sets new Parent category of this subcategory..
     *
     * @param category New value of Parent category of this subcategory..
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets Parent category of this subcategory..
     *
     * @return Value of Parent category of this subcategory..
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Gets Groups, which fall into this subcategory..
     *
     * @return Value of Groups, which fall into this subcategory..
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Sets new Name of the subcategory..
     *
     * @param name New value of Name of the subcategory..
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets Events, which fall into this subcategory..
     *
     * @return Value of Events, which fall into this subcategory..
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Sets new Events, which fall into this subcategory..
     *
     * @param events New value of Events, which fall into this subcategory..
     */
    public void setEvents(List<Event> events) {
        this.events = events;
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
     * Gets Name of the subcategory..
     *
     * @return Value of Name of the subcategory..
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Subcategory other = ((Subcategory) obj);

        return id == other.id;
    }
}