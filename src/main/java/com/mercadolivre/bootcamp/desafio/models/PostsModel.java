package com.mercadolivre.bootcamp.desafio.models;

import com.mercadolivre.bootcamp.desafio.dtos.responses.ProductDetailDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class PostsModel {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="date")
    private LocalDate date;

    @ManyToOne
    private ProductsModel idProduct;

    @ManyToOne
    private CategoriesModel idCategory;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    private UsersModel idUserPoster;

    @Column(name="has_promo")
    private boolean hasPromo = false;

    @Column(name="discount")
    private double discount = 0.0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ProductsModel getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(ProductsModel idProduct) {
        this.idProduct = idProduct;
    }

    public CategoriesModel getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(CategoriesModel idCategory) {
        this.idCategory = idCategory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UsersModel getIdUserPoster() {
        return idUserPoster;
    }

    public void setIdUserPoster(UsersModel idUserPoster) {
        this.idUserPoster = idUserPoster;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "PostsModel{" +
                "id=" + id +
                ", date=" + date +
                ", idProduct=" + idProduct +
                ", idCategory=" + idCategory +
                ", price=" + price +
                ", idUserPoster=" + idUserPoster +
                '}';
    }
}
