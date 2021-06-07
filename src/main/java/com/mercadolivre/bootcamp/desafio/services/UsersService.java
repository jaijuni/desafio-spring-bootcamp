package com.mercadolivre.bootcamp.desafio.services;

import com.mercadolivre.bootcamp.desafio.dtos.UsersDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.UserAndFollowersDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.UsersFollowersListDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.UsersIFollowDTO;

import java.util.List;

public interface UsersService{
    UserAndFollowersDTO getFollowersCount(Integer idFollower);
    boolean createUser(String username, boolean isSeller);
    UsersFollowersListDTO getFollowers(Integer idUser, List<Integer> idFollowers, String sort);
    UsersIFollowDTO getUsersIFollow(Integer idUser, List<Integer> idFollowing);
}
