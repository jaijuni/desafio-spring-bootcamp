package com.mercadolivre.bootcamp.desafio.services.impl;

import com.mercadolivre.bootcamp.desafio.DAO.BrandsDAO;
import com.mercadolivre.bootcamp.desafio.DAO.ProductsDAO;
import com.mercadolivre.bootcamp.desafio.DAO.TypesDAO;
import com.mercadolivre.bootcamp.desafio.DAO.UsersDAO;
import com.mercadolivre.bootcamp.desafio.dtos.requests.ProductsDTO;
import com.mercadolivre.bootcamp.desafio.models.BrandsModel;
import com.mercadolivre.bootcamp.desafio.models.ProductsModel;
import com.mercadolivre.bootcamp.desafio.models.TypesModel;
import com.mercadolivre.bootcamp.desafio.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ProductsServiceImpl implements ProductService {
    private final BrandsDAO brandsDAO;
    private final TypesDAO typesDAO;
    private final UsersDAO usersDAO;
    private final ProductsDAO productsDAO;


    public ProductsServiceImpl(BrandsDAO brandsDAO, TypesDAO typesDAO, UsersDAO usersDAO, ProductsDAO productsDAO) {
        this.brandsDAO = brandsDAO;
        this.typesDAO = typesDAO;
        this.usersDAO = usersDAO;
        this.productsDAO = productsDAO;
    }


    @Override
    public ProductsModel createProduct(ProductsDTO product, Integer idUser) {
        ProductsModel productModel = new ProductsModel();

        BrandsModel productBrandId = brandsDAO.getBrandIdByValue(product.getBrand());
        TypesModel productTypedId = typesDAO.getTypeIdByValue(String.format(product.getType()));

        if(productTypedId == null) {
            productTypedId = new TypesModel();
            productTypedId.setName(String.format(product.getType()));
            productTypedId = typesDAO.save(productTypedId);
        }


        productModel.setName(product.getProductName());
        productModel.setIdBrand(productBrandId);
        productModel.setIdType(productTypedId);
        productModel.setColor(product.getColor());
        productModel.setNotes(product.getNotes());
        productModel.setIdSeller(usersDAO.getById(idUser));

        return productsDAO.save(productModel);
    }
}
