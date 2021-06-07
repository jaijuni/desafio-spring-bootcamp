package com.mercadolivre.bootcamp.desafio.dtos.responses;

import java.util.List;

public class UsersPromoPostDTO {
    private Integer userId;
    private String userName;
    private List<PromoPostListDTO> posts;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<PromoPostListDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PromoPostListDTO> posts) {
        this.posts = posts;
    }
}
