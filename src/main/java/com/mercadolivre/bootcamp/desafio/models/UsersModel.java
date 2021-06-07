package com.mercadolivre.bootcamp.desafio.models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UsersModel {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="user_name", nullable = false)
    private String userName;

    @Column(name="is_seller")
    private boolean isSeller;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }
}
