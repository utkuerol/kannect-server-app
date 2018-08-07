package com.pse.testserver.entities;


import javax.persistence.*;

@Entity
@Table(name = "group_members")

public class GroupMember {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "group_id")
    private Group group;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;


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
     * gets the group Id
     *
     * @return groupId
     */
    public Group getGroup() {
        return group;
    }

    /**
     * sets the group Id
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * gets the user Id
     *
     * @return userId
     */
    public User getUser() {
        return user;
    }


    /**
     * sets the user Id
     */
    public void setUser(User user) {
        this.user = user;
    }
}
