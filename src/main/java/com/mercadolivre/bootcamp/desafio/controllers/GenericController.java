package com.mercadolivre.bootcamp.desafio.controllers;

import com.mercadolivre.bootcamp.desafio.services.impl.GenericImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {
    private GenericImpl impl;

    public GenericController(GenericImpl impl) {
        this.impl = impl;
    }

    @PostMapping("/init")
    public ResponseEntity initApp() {
        try {
            impl.initUsers();
            impl.initCategories();
            impl.initBrands();
            impl.initTypes();
            impl.initPosts();
            return new ResponseEntity("Jarvis acabou de iniciar a aplicação, bom proveito", HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
