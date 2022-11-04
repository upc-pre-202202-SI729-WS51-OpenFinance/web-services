package com.pokeswap.webservice.security.domain.service.communication;

import com.pokeswap.webservice.security.resource.AuthenticateResource;
import com.pokeswap.webservice.shared.domain.service.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {
    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }
}
