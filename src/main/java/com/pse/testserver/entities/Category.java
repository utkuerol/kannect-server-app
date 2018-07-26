package com.pse.testserver.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Entity class for the persisted category data from the "categories" table.
 * Represents a category, providing access to the category's unique id, name, subcategories,
 * groups and events.
 */
@Entity
@Table(name = "categories")
public class Category {

    /**
     * Subcategories, which fall into this category.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonManagedReference(value = "subcategorycategory")
    private List<Subcategory> subcategories;

    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Name of the category.
     */
    @Column(name = "name", columnDefinition = "LONGTEXT")
    private String name;
    /**
     * Events, which fall into this category.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonManagedReference(value = "eventcategory")
    private List<Event> events;
    /**
     * Groups, which fall into this category.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Group> groups;

    public Category() {
        groups = new LinkedList<>();
        subcategories = new LinkedList<>();
        events = new LinkedList<>();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Category other = ((Category) obj);

        return id == other.id;
    }

    /**
     * Gets Groups, which fall into this category..
     *
     * @return Value of Groups, which fall into this category..
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Sets new Groups, which fall into this category..
     *
     * @param groups New value of Groups, which fall into this category..
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * Gets Events, which fall into this category..
     *
     * @return Value of Events, which fall into this category..
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Sets new Events, which fall into this category..
     *
     * @param events New value of Events, which fall into this category..
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
     * Sets new Incremental generated unique id..
     *
     * @param id New value of Incremental generated unique id..
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets Name of the category..
     *
     * @return Value of Name of the category..
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new Name of the category..
     *
     * @param name New value of Name of the category..
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets Subcategories, which fall into this category..
     *
     * @return Value of Subcategories, which fall into this category..
     */
    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    /**
     * Sets new Subcategories, which fall into this category..
     *
     * @param subcategories New value of Subcategories, which fall into this category..
     */
    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}