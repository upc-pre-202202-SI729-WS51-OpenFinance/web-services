package com.pokeswap.webservice.security.service;

import com.pokeswap.webservice.security.domain.model.entity.Role;
import com.pokeswap.webservice.security.domain.model.enumeration.Roles;
import com.pokeswap.webservice.security.domain.persistence.RoleRepository;
import com.pokeswap.webservice.security.domain.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    private static String[] DEFAULT_ROLES = {"ROLE_USER", "ROLE_INSTRUCTOR", "ROLE_ADMIN"};

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seed() {
        Arrays.stream(DEFAULT_ROLES).forEach(name -> {
            Roles roleName = Roles.valueOf(name);
            if(!roleRepository.existsByName(roleName)) {
                roleRepository.save((new Role()).withName(roleName));
            }
        });
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
