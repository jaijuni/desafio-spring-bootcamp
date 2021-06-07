package com.mercadolivre.bootcamp.desafio.models;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoriesModel {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
