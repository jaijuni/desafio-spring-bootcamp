package com.mercadolivre.bootcamp.desafio.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="follows")
public class FollowsModel {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private UsersModel idFollower;

    @ManyToOne
    private UsersModel idFollowed;

    @Column(name="date_follow")
    @GeneratedValue
    private LocalDate dateFollow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsersModel getIdFollower() {
        return idFollower;
    }

    public void setIdFollower(UsersModel idFollower) {
        this.idFollower = idFollower;
    }

    public UsersModel getIdFollowed() {
        return idFollowed;
    }

    public void setIdFollowed(UsersModel idFollowed) {
        this.idFollowed = idFollowed;
    }

    public LocalDate getDateFollow() {
        return dateFollow;
    }

    public void setDateFollow(LocalDate dateFollow) {
        this.dateFollow = dateFollow;
    }
}
