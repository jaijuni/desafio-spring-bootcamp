package com.mercadolivre.bootcamp.desafio.comparators;

import com.mercadolivre.bootcamp.desafio.dtos.UsersDTO;

import java.util.Comparator;

public class UserNameComparator implements Comparator<UsersDTO> {
    @Override
    public int compare(UsersDTO o1, UsersDTO o2) {
        return o1.getUserName().compareTo(o2.getUserName());
    }

    @Override
    public Comparator<UsersDTO> reversed() {
        return Comparator.super.reversed();
    }
}
