package com.pse.testserver.entities;


import javax.persistence.*;
import java.util.Set;

/**
 * Entity class for the persisted group data from the "groups" table.
 * Represents an group, providing access to the group's unique id, name, description, category, subcategory,
 * creator, profile picture url and members.
 */
@Entity
@Table(name = "groups")
public class Group {

    /**
     * Incremental generated unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Name of the group.
     */
    @Column(name = "name")
    private String name;

    /**
     * Description of the group, containing extra information intended to be given from the user.
     */
    @Column(name = "description")
    private String description;

    /**
     * User, which created this group.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    /**
     * Category, into which this group falls.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * Subcategory, into which this group falls.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    /**
     * Url of the profile picture.
     */
    @Column(name = "image_url")
    private String image_url;

    /**
     * Users, which have joined this group.
     */
    @ManyToMany(mappedBy = "groups")
    private Set<User> members;


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
     * Gets members.
     *
     * @return Value of members.
     */
    public Set<User> getMembers() {
        return members;
    }

    /**
     * Sets new members.
     *
     * @param members New value of members.
     */
    public void setMembers(Set<User> members) {
        this.members = members;
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
}















