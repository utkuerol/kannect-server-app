package com.pse.testserver.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Entity class for the persisted group data from the "groups" table.
 * Represents an group, providing access to the group's unique id, name, description, category, subcategory,
 * creator, profile picture url and members.
 */
@Entity
@Table(name = "[groups]")
public class Group {

    /**
     * Users, which have joined this group.
     */


    @OneToMany(mappedBy = "group")
    @JsonBackReference(value = "userJoinGroup")
    private List<GroupMember> groupMembers;

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
    @Column(name = "name", columnDefinition = "LONGTEXT")
    private String name;

    /**
     * Description of the group, containing extra information intended to be given from the user.
     */
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    /**
     * User, which created this group.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    @JsonBackReference(value = "groupuser")
    private User creator;

    /**
     * Category, into which this group falls.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "groupcategory")
    private Category category;

    /**
     * Subcategory, into which this group falls.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    @JsonBackReference(value = "groupsubcategory")
    private Subcategory subcategory;

    /**
     * Url of the profile picture.
     */
    @Column(name = "image_url")
    private String image_url;
    @Transient
    private List<User> members;

    public Group() {
        this.members = new LinkedList<User>();
        this.groupMembers = new LinkedList<GroupMember>();
    }

    /**
     * Gets Users, which have joined this group..
     *
     * @return Value of Users, which have joined this group..
     */
    public List<User> getMembers() {
        List<User> joinedUsers = new LinkedList<>();
        for (GroupMember groupMember : groupMembers) {
            joinedUsers.add(groupMember.getUser());
        }
        return joinedUsers;

    }


    /**
     * Sets new Users, which have joined this group..
     *
     * @param members New value of Users, which have joined this group..
     */
    public void setMembers(List<User> members) {
        this.members = members;
    }

    /**
     * Sets new Subcategory, into which this group falls..
     *
     * @param subcategory New value of Subcategory, into which this group falls..
     */
    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    /**
     * Gets Description of the group, containing extra information intended to be given from the user..
     *
     * @return Value of Description of the group, containing extra information intended to be given from the user..
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new User, which created this group..
     *
     * @param creator New value of User, which created this group..
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * Sets new Description of the group, containing extra information intended to be given from the user..
     *
     * @param description New value of Description of the group, containing extra information intended to be given from the user..
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Gets Incremental generated unique id..
     *
     * @return Value of Incremental generated unique id..
     */
    public int getId() {
        return id;
    }

    /**
     * Gets Url of the profile picture..
     *
     * @return Value of Url of the profile picture..
     */
    public String getImage_url() {
        return image_url;
    }


    /**
     * Sets new Name of the group..
     *
     * @param name New value of Name of the group..
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets new Category, into which this group falls..
     *
     * @param category New value of Category, into which this group falls..
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Sets new Url of the profile picture..
     *
     * @param image_url New value of Url of the profile picture..
     */
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    /**
     * Gets User, which created this group..
     *
     * @return Value of User, which created this group..
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Gets Name of the group..
     *
     * @return Value of Name of the group..
     */
    public String getName() {
        return name;
    }

    /**
     * Gets Subcategory, into which this group falls..
     *
     * @return Value of Subcategory, into which this group falls..
     */
    public Subcategory getSubcategory() {
        return subcategory;
    }

    /**
     * Gets Category, into which this group falls..
     *
     * @return Value of Category, into which this group falls..
     */
    public Category getCategory() {
        return category;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Group other = ((Group) obj);

        return id == other.id;
    }
}