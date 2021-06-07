package com.mercadolivre.bootcamp.desafio.services.impl;

import com.mercadolivre.bootcamp.desafio.DAO.FollowsDAO;
import com.mercadolivre.bootcamp.desafio.DAO.UsersDAO;
import com.mercadolivre.bootcamp.desafio.comparators.DateFollowComparator;
import com.mercadolivre.bootcamp.desafio.models.FollowsModel;
import com.mercadolivre.bootcamp.desafio.models.UsersModel;
import com.mercadolivre.bootcamp.desafio.services.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class FollowsServiceImpl implements FollowsService {
    @Autowired
    FollowsDAO followsDAO;

    @Autowired
    UsersDAO usersDAO;

    @Override
    public boolean follow(Integer idFollower, Integer idFollowed) {
        try {
            FollowsModel follow = new FollowsModel();

            UsersModel followed = usersDAO.getById(idFollowed);
            UsersModel follower = usersDAO.getById(idFollower);

            if(followsDAO.isFollowing(idFollower, idFollowed) != null || idFollower.equals(idFollowed) || !followed.isSeller()) {
                return false;
            }

            follow.setIdFollower(follower);
            follow.setIdFollowed(followed);

            followsDAO.save(follow);

            return true;
        } catch(Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean unfollow(Integer idFollower, Integer idFollowed) throws Exception {
        if(followsDAO.isFollowing(idFollower, idFollowed) != null) {
            followsDAO.deleteById(followsDAO.isFollowing(idFollower, idFollowed));
            return true;
        }
        throw new Exception();
    }

    @Override
    public Integer getFollowersCount(Integer idFollowed) {
        return followsDAO.getFollowing(idFollowed);
    }

    @Override
    public List<Integer> getFollowersId(Integer idFollower) {
        return followsDAO.getFollowersId(idFollower);
    }

    public List<Integer> getUsersIFollow(Integer idFollower, String order) {
        List<FollowsModel> follows = followsDAO.getUserIFollowId(idFollower);
        List<Integer> followsIds = new ArrayList<>();
        DateFollowComparator dateFollowComparator = new DateFollowComparator();

        if(order.split("_")[0].equals("date")) {
            if(order.split("_")[1].equals("asc") || order.split("_")[1].equals("ASC")) {
                follows.sort(dateFollowComparator);
            } else {
                follows.sort(dateFollowComparator.reversed());
            }
        }

        for (FollowsModel follow : follows) {
            followsIds.add(follow.getIdFollowed().getId());
        }

        return followsIds;
    }


}
