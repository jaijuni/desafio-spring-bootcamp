package com.mercadolivre.bootcamp.desafio.dtos.responses;

public class UserAndFollowersDTO {
    private Integer idUser;
    private String userName;
    private Integer followersCount;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    @Override
    public String toString() {
        return "UserAndFollowersDTO{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", followersCount=" + followersCount +
                '}';
    }
}
