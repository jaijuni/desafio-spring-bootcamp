package com.mercadolivre.bootcamp.desafio.services.impl;

import com.mercadolivre.bootcamp.desafio.DAO.CategoriesDAO;
import com.mercadolivre.bootcamp.desafio.DAO.PostsDAO;
import com.mercadolivre.bootcamp.desafio.DAO.UsersDAO;
import com.mercadolivre.bootcamp.desafio.Exceptions.NoCategoryException;
import com.mercadolivre.bootcamp.desafio.dtos.requests.CreatePostDTO;
import com.mercadolivre.bootcamp.desafio.dtos.responses.*;
import com.mercadolivre.bootcamp.desafio.models.CategoriesModel;
import com.mercadolivre.bootcamp.desafio.models.PostsModel;
import com.mercadolivre.bootcamp.desafio.models.ProductsModel;
import com.mercadolivre.bootcamp.desafio.models.UsersModel;
import com.mercadolivre.bootcamp.desafio.services.PostService;
import com.mercadolivre.bootcamp.desafio.services.ProductService;
import org.springframework.stereotype.Service;

import javax.naming.NoPermissionException;
import java.time.Instant;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final ProductService productService;

    private final PostsDAO postsDAO;
    private final UsersDAO usersDAO;
    private final CategoriesDAO categoriesDAO;


    public PostServiceImpl(ProductService productService, PostsDAO postsDAO, UsersDAO usersDAO, CategoriesDAO categoriesDAO) {
        this.productService = productService;
        this.postsDAO = postsDAO;
        this.usersDAO = usersDAO;
        this.categoriesDAO = categoriesDAO;
    }



    @Override
    public void createPost(CreatePostDTO post) throws Exception {
        if(!usersDAO.getById(post.getUserId()).isSeller()) throw new NoPermissionException();

        ProductsModel productsInstance = productService.createProduct(post.getDetail(), post.getUserId());
        PostsModel postsModel = new PostsModel();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Instant datet = format.parse(post.getDate()).toInstant();

        postsModel.setIdProduct(productsInstance);
        postsModel.setDate(LocalDate.ofInstant(datet, ZoneId.of("America/Sao_Paulo")));
        postsModel.setIdUserPoster(usersDAO.getById(post.getUserId()));
        postsModel.setPrice(post.getPrice());

        try{
            postsModel.setIdCategory(categoriesDAO.getById(post.getCategory()));
            System.out.println(postsModel.getIdCategory().toString());
        } catch(Exception e) {
            throw new NoCategoryException(categoriesDAO.getCategoryIdByValue("Category Padrão").getId());
        }
        postsModel.setHasPromo(post.isHasPromo());
        postsModel.setDiscount(post.getDiscount());

        postsDAO.save(postsModel);
    }

    @Override
    public UserPostsDTO getListOfPostsFromAUserByUserId(Integer userId) {
        UserPostsDTO responseDTO = new UserPostsDTO();
        List<PostsDTO> responses = new ArrayList<>();
        responseDTO.setUserId(userId);

        for(int i = 0; i < postsDAO.getPostsByUserId(userId).size(); i++) {
            PostsModel postModel = postsDAO.getPostsByUserId(userId).get(i);
            PostsDTO post = new PostsDTO();

            if(LocalDate.now().minusWeeks(2).compareTo(postModel.getDate()) > 0) {
                continue;
            }

            post.setId_post(postModel.getId());
            post.setDetail(mappingProductDetailPost(postsDAO.getPostsByUserId(userId).get(i).getIdProduct()));
            post.setDate(postModel.getDate());
            post.setCategory(postModel.getIdCategory().getId());
            post.setPrice(postModel.getPrice());
            responses.add(post);
        }

        responseDTO.setPosts(responses);
        return responseDTO;
    }

    @Override
    public CountPromoPostDTO getPromoPosts(Integer userId) {
        List<PostsModel> postsModels = postsDAO.getPostsByUserId(userId);
        CountPromoPostDTO promoPosts = new CountPromoPostDTO();
        UsersModel user = usersDAO.getById(userId);
        Integer counter = 0;

        for (int i=0; i < postsModels.size(); i++ ) {
            PostsModel post = postsModels.get(i);
            if(post.isHasPromo()) {
                counter++;
            }
        }

        promoPosts.setUserId(user.getId());
        promoPosts.setUserName(user.getName());
        promoPosts.setPromoproducts_count(counter);

        return promoPosts;
    }

    @Override
    public UsersPromoPostDTO promoPosts(Integer idUser, Boolean hasPromo) {
        List<PostsModel> posts = postsDAO.getPromoPostsByUserId(idUser, hasPromo);
        System.out.println(posts);
        PromoPostListDTO promoPost = new PromoPostListDTO();
        List<PromoPostListDTO> promoPostList = new ArrayList<>();
        final UsersPromoPostDTO resultDTO = new UsersPromoPostDTO();

        posts.forEach(post -> {
            promoPost.setDate(post.getDate());
            promoPost.setCategory(post.getIdCategory().getId());
            promoPost.setHasPromo(post.isHasPromo());
            promoPost.setDetail(mappingProductDetailPost(post.getIdProduct()));
            promoPost.setDiscount(post.getDiscount());
            promoPost.setPrice(post.getPrice());
            promoPost.setId_post(post.getId());

            promoPostList.add(promoPost);
        });

        resultDTO.setUserId(usersDAO.getById(idUser).getId());
        resultDTO.setUserName(usersDAO.getById(idUser).getName());
        resultDTO.setPosts(promoPostList);
        return resultDTO;
    }

    public static ProductDetailDTO mappingProductDetailPost(ProductsModel products) {
        ProductDetailDTO detailsDTO = new ProductDetailDTO();

        detailsDTO.setProduct_id(products.getId());
        detailsDTO.setProduct_name(products.getName());
        detailsDTO.setBrand(products.getIdBrand().getName());
        detailsDTO.setNotes(products.getNotes());
        detailsDTO.setType(products.getIdType().getName());
        detailsDTO.setColor(products.getColor());

        return detailsDTO;
    }
}
