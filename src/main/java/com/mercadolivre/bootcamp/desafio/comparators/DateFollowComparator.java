package com.mercadolivre.bootcamp.desafio.comparators;

import com.mercadolivre.bootcamp.desafio.models.FollowsModel;

import java.util.Comparator;
import java.util.Date;

public class DateFollowComparator implements Comparator<FollowsModel> {

    @Override
    public int compare(FollowsModel o1, FollowsModel o2) {
        return o1.getDateFollow().compareTo(o2.getDateFollow());
    }

    @Override
    public Comparator<FollowsModel> reversed() {
        return Comparator.super.reversed();
    }
}
