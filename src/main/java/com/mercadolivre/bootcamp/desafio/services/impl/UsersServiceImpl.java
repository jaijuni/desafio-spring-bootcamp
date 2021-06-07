package com.mercadolivre.bootcamp.desafio.services.impl;

import com.mercadolivre.bootcamp.desafio.DAO.UsersDAO;
import com.mercadolivre.bootcamp.desafio.comparators.UserNameComparator;
import com.mercadolivre.bootcamp.desafio.dtos.UsersDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.UserAndFollowersDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.UsersFollowersListDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.UsersIFollowDTO;
import com.mercadolivre.bootcamp.desafio.models.UsersModel;
import com.mercadolivre.bootcamp.desafio.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDAO usersDAO;

    @Override
    public UserAndFollowersDTO getFollowersCount(Integer idFollower) {
        UsersModel user = usersDAO.getById(idFollower);
        UserAndFollowersDTO usersDTO = new UserAndFollowersDTO();

        usersDTO.setIdUser(user.getId());
        usersDTO.setUserName(user.getName());


        return usersDTO;
    }

    @Override
    public boolean createUser(String username, boolean isSeller) {
        UsersModel user = new UsersModel();

        user.setName(username);
        user.setSeller(isSeller);
        usersDAO.save(user);

        return true;
    }

    @Override
    public UsersFollowersListDTO getFollowers(Integer idUser, List<Integer> idFollowers, String sort) {
        List<UsersDTO> followers = new ArrayList<>();
        UsersFollowersListDTO userToReturn = new UsersFollowersListDTO();
        UsersModel userFromDatabase = usersDAO.getById(idUser);

        idFollowers.forEach(followerId -> {
            UsersModel followerFromDataBase = usersDAO.getById(followerId);
            UsersDTO follower = new UsersDTO();

            follower.setUserId(followerFromDataBase.getId());
            follower.setUserName(followerFromDataBase.getName());

            followers.add(follower);
        });

        if(sort.equals("desc")) {
            UserNameComparator userNameComparator = new UserNameComparator();
            followers.sort(userNameComparator.reversed());
        } else {
            UserNameComparator userNameComparator = new UserNameComparator();
            followers.sort(userNameComparator);
        }

        userToReturn.setUserId(userFromDatabase.getId());
        userToReturn.setUsername(userFromDatabase.getName());
        userToReturn.setFollowers(followers);

        return userToReturn;
    }

    @Override
    public UsersIFollowDTO getUsersIFollow(Integer idUser, List<Integer> idFollowers) {
        List<UsersDTO> followed = new ArrayList<>();
        UsersIFollowDTO userToReturn = new UsersIFollowDTO();
        UsersModel userFromDatabase = usersDAO.getById(idUser);

        idFollowers.forEach(followerId -> {
            UsersModel followerFromDataBase = usersDAO.getById(followerId);
            UsersDTO follower = new UsersDTO();

            follower.setUserId(followerFromDataBase.getId());
            follower.setUserName(followerFromDataBase.getName());

            followed.add(follower);
        });

        userToReturn.setUserId(userFromDatabase.getId());
        userToReturn.setUsername(userFromDatabase.getName());
        userToReturn.setFollowed(followed);

        return userToReturn;
    }
}
