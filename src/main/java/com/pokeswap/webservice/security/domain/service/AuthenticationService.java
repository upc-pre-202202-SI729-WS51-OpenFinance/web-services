package com.pokeswap.webservice.security.domain.service;

import com.pokeswap.webservice.security.domain.service.communication.AuthenticateRequest;
import com.pokeswap.webservice.security.domain.service.communication.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<?> authenticate(AuthenticateRequest request);
    ResponseEntity<?> register(RegisterRequest request);
}
