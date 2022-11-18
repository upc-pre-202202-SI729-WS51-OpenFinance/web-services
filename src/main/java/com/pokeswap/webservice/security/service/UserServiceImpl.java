package com.pokeswap.webservice.security.service;

import com.pokeswap.webservice.security.domain.model.entity.User;
import com.pokeswap.webservice.security.domain.persistence.UserRepository;
import com.pokeswap.webservice.security.domain.service.UserService;
import com.pokeswap.webservice.security.middleware.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User not found with username: %s", username)));
        return UserDetailsImpl.build(user);
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


}
