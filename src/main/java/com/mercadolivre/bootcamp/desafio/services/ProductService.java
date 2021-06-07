package com.mercadolivre.bootcamp.desafio.services;

import com.mercadolivre.bootcamp.desafio.dtos.requests.ProductsDTO;
import com.mercadolivre.bootcamp.desafio.models.ProductsModel;

public interface ProductService {
    ProductsModel createProduct(ProductsDTO product, Integer idUser);
}
