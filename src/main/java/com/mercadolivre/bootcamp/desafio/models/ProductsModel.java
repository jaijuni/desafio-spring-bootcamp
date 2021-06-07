package com.mercadolivre.bootcamp.desafio.models;


import javax.persistence.*;
import java.sql.Types;

@Entity
@Table(name="products")
public class ProductsModel {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @ManyToOne
    private TypesModel idType;

    @ManyToOne
    private BrandsModel idBrand;

    @Column(name="color", nullable = false)
    private String color;

    @Column(name="notes", nullable=false, length=512)
    private String notes;

    @ManyToOne
    private UsersModel idSeller;

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

    public TypesModel getIdType() {
        return idType;
    }

    public void setIdType(TypesModel idType) {
        this.idType = idType;
    }

    public BrandsModel getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(BrandsModel idBrand) {
        this.idBrand = idBrand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public UsersModel getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(UsersModel idSeller) {
        this.idSeller = idSeller;
    }
}
