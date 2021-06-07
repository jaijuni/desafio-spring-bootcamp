package com.mercadolivre.bootcamp.desafio.services.impl;

import com.mercadolivre.bootcamp.desafio.DAO.*;
import com.mercadolivre.bootcamp.desafio.dtos.responses.PostsDTO;
import com.mercadolivre.bootcamp.desafio.models.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GenericImpl {

    private final UsersDAO usersDAO;
    private final PostsDAO postsDAO;
    private final CategoriesDAO categoriesDAO;
    private final TypesDAO typesDAO;
    private final BrandsDAO brandsDAO;
    private final ProductsDAO productsDAO;

    public GenericImpl(UsersDAO usersDAO, PostsDAO postsDAO, CategoriesDAO categoriesDAO, TypesDAO typesDAO, BrandsDAO brandsDAO, ProductsDAO productsDAO) {
        this.usersDAO = usersDAO;
        this.postsDAO = postsDAO;
        this.categoriesDAO = categoriesDAO;
        this.typesDAO = typesDAO;
        this.brandsDAO = brandsDAO;
        this.productsDAO = productsDAO;
    }

    public void initUsers() {
        UsersModel sellerUser = new UsersModel();
        UsersModel simpleUser = new UsersModel();

        simpleUser.setName("John Doe Non Seller");
        simpleUser.setSeller(false);

        sellerUser.setName("John Doe Seller");
        sellerUser.setSeller(true);

        usersDAO.save(simpleUser);
        usersDAO.save(sellerUser);
    }

    public void initPosts() {
        PostsModel post = new PostsModel();
        ProductsModel product = new ProductsModel();

        product.setIdSeller(usersDAO.getById(1));
        product.setNotes("Isso é apenas um teste");
        product.setColor("Vermelho testeado");
        product.setIdType(typesDAO.getById(1));
        product.setIdBrand(brandsDAO.getById(1));
        product.setName("Produto");

        product = productsDAO.save(product);

        post.setPrice(100.0);
        post.setIdProduct(product);
        post.setIdUserPoster(usersDAO.getById(1));
        post.setDate(LocalDate.now());
        post.setIdCategory(categoriesDAO.getById(1));

        postsDAO.save(post);
    }

    public void initCategories(){
        CategoriesModel category = new CategoriesModel();
        category.setName("Categoria de teste");
        categoriesDAO.save(category);
    }

    public void initTypes() {
        TypesModel type = new TypesModel();
        type.setName("Tipo de teste");
        typesDAO.save(type);
    }

    public void initBrands() {
        BrandsModel brand = new BrandsModel();
        brand.setName("Marca de teste");
        brandsDAO.save(brand);
    }

}
