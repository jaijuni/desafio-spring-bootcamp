package com.mercadolivre.bootcamp.desafio.dtos;

public class createUserDTO {
    private String username;
    private boolean isSeller;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getIsSeller() {
        return isSeller;
    }

    public void setSeler(boolean seler) {
        isSeller = seler;
    }
}
