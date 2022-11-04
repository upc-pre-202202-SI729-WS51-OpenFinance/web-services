package com.pokeswap.webservice.security.mapping;

import com.pokeswap.webservice.security.domain.model.entity.User;
import com.pokeswap.webservice.security.resource.UserResource;
import com.pokeswap.webservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping

    public UserResource toResource(Object object) {
        return mapper.map(object, UserResource.class);
    }

    public Page<UserResource> modelListToPage(List<User> all, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(all, UserResource.class), pageable, all.size());
    }
}
