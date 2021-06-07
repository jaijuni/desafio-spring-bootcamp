package com.mercadolivre.bootcamp.desafio.DAO;

import com.mercadolivre.bootcamp.desafio.models.BrandsModel;
import com.mercadolivre.bootcamp.desafio.models.TypesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesDAO extends JpaRepository<TypesModel, Integer> {
    @Query(value = "SELECT * FROM TYPES WHERE NAME=?1 LIMIT 0,1", nativeQuery = true)
    TypesModel getTypeIdByValue(String value);
}
