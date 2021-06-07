package com.mercadolivre.bootcamp.desafio.dtos.responses;

import com.mercadolivre.bootcamp.desafio.dtos.UsersDTO;

import java.util.List;

public class UsersIFollowDTO {
    private Integer userId;
    private String username;
    private List<UsersDTO> followed;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UsersDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UsersDTO> followed) {
        this.followed = followed;
    }
}
