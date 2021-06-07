package com.mercadolivre.bootcamp.desafio.dtos.responses;

import com.mercadolivre.bootcamp.desafio.models.PostsModel;

import java.util.List;

public class UserPostsDTO {
    private Integer userId;
    private List<PostsDTO> posts;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<PostsDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsDTO> posts) {
        this.posts = posts;
    }
}
