package com.pse.testserver.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity class for the persisted subcategory data from the "subcategories" table.
 * Represents a subcategory, providing access to the subcategory's unique id, name, parent category,
 * groups and events.
 */
@Entity
@Table(name = "subcategories")
public class Subcategory {

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
    @Column(name = "name")
    private String name;

    /**
     * Parent category of this subcategory.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * Events, which fall into this subcategory.
     */
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> events;

    /**
     * Groups, which fall into this subcategory.
     */
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> groups;


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
}
