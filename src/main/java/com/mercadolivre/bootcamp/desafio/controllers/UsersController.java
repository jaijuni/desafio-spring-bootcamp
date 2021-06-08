package com.mercadolivre.bootcamp.desafio.controllers;

import com.mercadolivre.bootcamp.desafio.dtos.responses.UserAndFollowersDTO;
import com.mercadolivre.bootcamp.desafio.dtos.createUserDTO;
import com.mercadolivre.bootcamp.desafio.services.FollowsService;
import com.mercadolivre.bootcamp.desafio.services.UsersService;
import com.mercadolivre.bootcamp.desafio.services.impl.FollowsServiceImpl;
import com.mercadolivre.bootcamp.desafio.services.impl.UsersServiceImpl;
import org.hibernate.query.Query;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UsersController {

    FollowsService followsService = new FollowsServiceImpl();
    UsersService usersService = new UsersServiceImpl();

    public UsersController(FollowsService followsService, UsersService usersService) {
        this.followsService = followsService;
        this.usersService = usersService;
    }

    @PostMapping("/createUser")
    public boolean createUsers(@RequestBody List<createUserDTO> usersToCreate) {
        usersToCreate.forEach(user -> usersService.createUser(user.getUsername(), user.getIsSeller()));
        return true;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity makeAFollow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        if(followsService.follow(userId, userIdToFollow)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<Object> getFollowersCount(@PathVariable int userId) {
        try {
            UserAndFollowersDTO user = usersService.getFollowersCount(userId);
            user.setFollowersCount(followsService.getFollowersCount(userId));

            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/users/{userID}/followers/list")
    public ResponseEntity<String> getFollowersListOfAnUserByUserId(@PathVariable Integer userID, @PathParam("order") String order) {
        try {
            List<Integer> idsList = followsService.getFollowersId(userID);
            return new ResponseEntity(usersService.getFollowers(userID, idsList, order), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{userID}/followed/list")
    public ResponseEntity<String> getUsersIFollow(@PathVariable Integer userID, @PathParam("order") String order) {
        try {
            List<Integer> idsList = followsService.getUsersIFollow(userID, order);
            return new ResponseEntity(usersService.getUsersIFollow(userID, idsList), HttpStatus.OK);

        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        try {
            followsService.unfollow(userId, userIdToUnfollow);
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
