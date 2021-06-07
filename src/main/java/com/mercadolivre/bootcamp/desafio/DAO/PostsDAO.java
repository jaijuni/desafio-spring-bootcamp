package com.mercadolivre.bootcamp.desafio.DAO;

import com.mercadolivre.bootcamp.desafio.models.PostsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsDAO extends JpaRepository<PostsModel, Integer> {
    @Query(value="SELECT * FROM Posts where ID_USER_POSTER_ID = :idUser", nativeQuery = true)
    List<PostsModel> getPostsByUserId(@Param("idUser") Integer idUSer);

    @Query(value="SELECT * FROM Posts where ID_USER_POSTER_ID = :idUser and has_promo= :hasPromo", nativeQuery = true)
    List<PostsModel> getPromoPostsByUserId(@Param("idUser") Integer idUSer, @Param("hasPromo") Boolean hasPromo);
}
