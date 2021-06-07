package com.mercadolivre.bootcamp.desafio.DAO;

import com.mercadolivre.bootcamp.desafio.models.FollowsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowsDAO extends JpaRepository<FollowsModel, Integer> {

    @Query(value = "SELECT ID FROM FOLLOWS where ID_FOLLOWER_ID= :idFollower AND ID_FOLLOWED_ID= :idFollowed", nativeQuery = true)
    Integer isFollowing(@Param("idFollower") Integer idFollower,@Param("idFollowed") Integer idFollowed);

    @Query(value = "select Follows.id_follower_id FROM Follows inner join Users ON Users.id = Follows.id_follower_id where Follows.id_followed_id = :idFollowed", nativeQuery = true)
    List<Integer> getFollowersId(@Param("idFollowed") Integer idFollowed);

    @Query(value = "SELECT * FROM FOLLOWS where ID_FOLLOWER_ID=:idFollower", nativeQuery = true)
    List<FollowsModel> getUserIFollowId(@Param("idFollower") int idFollower);

    @Query(value = "SELECT count(*) FROM follows where id_followed_id=:idFollowed", nativeQuery = true)
    Integer getFollowing(@Param("idFollowed") Integer idFollowed);
}


