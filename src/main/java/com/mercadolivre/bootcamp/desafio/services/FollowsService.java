package com.mercadolivre.bootcamp.desafio.services;

import com.mercadolivre.bootcamp.desafio.models.FollowsModel;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FollowsService {
    boolean follow(Integer idFollower, Integer idFollowed);
    boolean unfollow(Integer idFollower, Integer idFollowed) throws Exception;

    Integer getFollowersCount(Integer idFollowed);
    List<Integer> getFollowersId(Integer idFollower);
    List<Integer> getUsersIFollow(Integer idFollower, String order);

}
