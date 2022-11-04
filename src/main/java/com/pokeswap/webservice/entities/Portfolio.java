package com.pokeswap.webservice.entities;

import com.pokeswap.webservice.security.domain.model.entity.User;

import java.util.List;

public class Portfolio {
    private Long id;
    User user;
    List<Swap> swaps;

}
