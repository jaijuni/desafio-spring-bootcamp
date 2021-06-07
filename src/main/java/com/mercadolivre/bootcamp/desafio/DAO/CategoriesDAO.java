package com.mercadolivre.bootcamp.desafio.DAO;

import com.mercadolivre.bootcamp.desafio.models.CategoriesModel;
import com.mercadolivre.bootcamp.desafio.models.PostsModel;
import com.mercadolivre.bootcamp.desafio.models.TypesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDAO extends JpaRepository<CategoriesModel, Integer> {
    @Query(value = "SELECT * FROM CATEGORIES WHERE NAME LIKE '%:value%' LIMIT 0,1", nativeQuery = true)
    CategoriesModel getCategoryIdByValue(@Param("value") String value);
}
