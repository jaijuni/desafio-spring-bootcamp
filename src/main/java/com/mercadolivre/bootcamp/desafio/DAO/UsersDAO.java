package com.mercadolivre.bootcamp.desafio.DAO;

import com.mercadolivre.bootcamp.desafio.dtos.UsersDTO;
import com.mercadolivre.bootcamp.desafio.models.FollowsModel;
import com.mercadolivre.bootcamp.desafio.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDAO extends JpaRepository<UsersModel, Integer> {
    @Query(value="SELECT follows.ID_FOLLOWER_ID FROM users INNER JOIN follows ON users.id = follows.ID_FOLLOWED_ID WHERE follows.ID_FOLLOWED_ID = :idUser ORDER BY users.user_name :order", nativeQuery = true)
    List<Integer> getFollowersOrderneded(@Param("idUser") Integer idUser, @Param("order") String order);

    @Query(value="SELECT follows.ID_FOLLOWED_ID FROM users INNER JOIN follows ON users.id = follows.ID_FOLLOWER_ID WHERE follows.ID_FOLLOWER_ID = :idUser ORDER BY users.user_name :order", nativeQuery = true)
    List<Integer> getFollowsOrderneded(@Param("idUser") Integer idUser, @Param("order") String order);
}
