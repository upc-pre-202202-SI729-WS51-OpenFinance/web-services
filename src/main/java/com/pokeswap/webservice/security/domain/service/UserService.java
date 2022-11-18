package com.pokeswap.webservice.security.domain.service;

import com.pokeswap.webservice.security.domain.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAll();

}
