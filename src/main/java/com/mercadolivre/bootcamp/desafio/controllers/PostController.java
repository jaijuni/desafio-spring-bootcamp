package com.mercadolivre.bootcamp.desafio.controllers;

import com.mercadolivre.bootcamp.desafio.dtos.requests.CreatePostDTO;
import com.mercadolivre.bootcamp.desafio.services.PostService;
import org.apache.coyote.Response;
import org.hibernate.annotations.ParamDef;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping("/products/newpost")
    private ResponseEntity addPost(@RequestBody CreatePostDTO postDTO){
        try {
            postService.createPost(postDTO);
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/products/newpromopost")
    private ResponseEntity addPromoPost(@RequestBody CreatePostDTO postDTO){
        try {
            postService.createPost(postDTO);
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products/{userId}/list/")
    private ResponseEntity getPromoPostList(@PathVariable Integer userId, @PathParam("promo")  boolean promo) {
        try {
            System.out.println(userId);
            return new ResponseEntity(postService.promoPosts(userId, promo),HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/products/followed/{userId}/list")
    private ResponseEntity getPostsFromAUserById(@PathVariable Integer userId) {
        try {
            return new ResponseEntity(postService.getListOfPostsFromAUserByUserId(userId), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products/{userId}/countPromo/")
    public ResponseEntity getCountityOfPromoPostFromAUser(@PathVariable Integer userId) {
        try {
            return new ResponseEntity(postService.getPromoPosts(userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
