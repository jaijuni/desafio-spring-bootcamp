package com.mercadolivre.bootcamp.desafio.services;

import com.mercadolivre.bootcamp.desafio.dtos.requests.CreatePostDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.CountPromoPostDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.UserPostsDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.UsersPromoPostDTO;

public interface PostService {
    void createPost(CreatePostDTO post) throws Exception;
    UserPostsDTO getListOfPostsFromAUserByUserId(Integer userId);
    CountPromoPostDTO getPromoPosts(Integer userId);
    UsersPromoPostDTO promoPosts(Integer idUser, Boolean hasPromo);
}
