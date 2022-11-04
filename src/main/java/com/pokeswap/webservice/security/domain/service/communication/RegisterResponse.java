package com.pokeswap.webservice.security.domain.service.communication;

import com.pokeswap.webservice.security.resource.UserResource;
import com.pokeswap.webservice.shared.domain.service.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}
