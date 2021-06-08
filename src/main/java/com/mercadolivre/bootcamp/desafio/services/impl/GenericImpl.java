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
    private final UsersModel sellerUser = new UsersModel();
    private final UsersModel simpleUser = new UsersModel();
    private PostsModel post = new PostsModel();
    private ProductsModel product = new ProductsModel();
    private CategoriesModel category = new CategoriesModel();
    private TypesModel type = new TypesModel();
    private BrandsModel brand = new BrandsModel();

    public GenericImpl(UsersDAO usersDAO, PostsDAO postsDAO, CategoriesDAO categoriesDAO, TypesDAO typesDAO, BrandsDAO brandsDAO, ProductsDAO productsDAO) {
        this.usersDAO = usersDAO;
        this.postsDAO = postsDAO;
        this.categoriesDAO = categoriesDAO;
        this.typesDAO = typesDAO;
        this.brandsDAO = brandsDAO;
        this.productsDAO = productsDAO;
    }

    public void initUsers() {
        simpleUser.setName("John Doe Non Seller");
        simpleUser.setSeller(false);

        sellerUser.setName("John Doe Seller");
        sellerUser.setSeller(true);

        usersDAO.save(simpleUser);
        usersDAO.save(sellerUser);
    }

    public void initPosts() {
        product.setIdSeller(sellerUser);
        product.setNotes("Isso é apenas um teste");
        product.setColor("Vermelho testeado");
        product.setIdType(type);
        product.setIdBrand(brand);
        product.setName("Produto");

        this.product = productsDAO.save(product);

        post.setPrice(100.0);
        post.setIdProduct(product);
        post.setIdUserPoster(sellerUser);
        post.setDate(LocalDate.now());
        post.setIdCategory(category);

        postsDAO.save(post);
    }

    public void initCategories(){
        category.setName("Categoria de teste");
        categoriesDAO.save(category);
    }

    public void initTypes() {
        type.setName("Tipo de teste");
        typesDAO.save(type);
    }

    public void initBrands() {
        brand.setName("Marca de teste");
        brandsDAO.save(brand);
    }

}
