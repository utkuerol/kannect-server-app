package com.pse.testserver.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity class for the persisted category data from the "categories" table.
 * Represents a category, providing access to the category's unique id, name, subcategories,
 * groups and events.
 */
@Entity
@Table(name = "categories")
public class Category {

    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * Name of the category.
     */
    @Column(name = "name")
    private String name;

    /**
     * Subcategories, which fall into this category.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Subcategory> subcategories;

    /**
     * Events, which fall into this category.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> events;

    /**
     * Groups, which fall into this category.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> groups;


    /**
     * Gets groups.
     *
     * @return Value of groups.
     */
    public Set<Group> getGroups() {
        return groups;
    }

    /**
     * Sets new groups.
     *
     * @param groups New value of groups.
     */
    public void setGroups(Set<Group> groups) {
        this.groups = groups;
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
     * Gets subcategories.
     *
     * @return Value of subcategories.
     */
    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }

    /**
     * Sets new subcategories.
     *
     * @param subcategories New value of subcategories.
     */
    public void setSubcategories(Set<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    /**
     * Gets events.
     *
     * @return Value of events.
     */
    public Set<Event> getEvents() {
        return events;
    }

    /**
     * Sets new events.
     *
     * @param events New value of events.
     */
    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
