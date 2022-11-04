package com.pokeswap.webservice.security.domain.service;

import com.pokeswap.webservice.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {
    void seed();
    List<Role> getAll();
}
