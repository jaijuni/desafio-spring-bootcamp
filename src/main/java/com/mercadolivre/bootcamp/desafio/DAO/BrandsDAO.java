package com.mercadolivre.bootcamp.desafio.DAO;

import com.mercadolivre.bootcamp.desafio.models.BrandsModel;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsDAO extends JpaRepository<BrandsModel, Integer> {
    @Query(value = "SELECT * FROM BRANDS WHERE NAME=?1 LIMIT 0,1", nativeQuery = true)
    BrandsModel getBrandIdByValue(String name);
}