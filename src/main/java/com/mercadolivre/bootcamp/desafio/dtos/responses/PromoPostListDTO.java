package com.mercadolivre.bootcamp.desafio.dtos.responses;

import java.time.LocalDate;

public class PromoPostListDTO {
    private Integer id_post;
    private LocalDate date;
    private ProductDetailDTO detail;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private Double discount;

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ProductDetailDTO getDetail() {
        return detail;
    }

    public void setDetail(ProductDetailDTO detail) {
        this.detail = detail;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
