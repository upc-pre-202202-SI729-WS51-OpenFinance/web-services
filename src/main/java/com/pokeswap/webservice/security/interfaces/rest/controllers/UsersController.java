package com.pokeswap.webservice.security.interfaces.rest.controllers;
import com.pokeswap.webservice.security.domain.service.UserService;
import com.pokeswap.webservice.security.domain.service.communication.AuthenticateRequest;
import com.pokeswap.webservice.security.domain.service.communication.RegisterRequest;
import com.pokeswap.webservice.security.mapping.UserMapper;
import com.pokeswap.webservice.security.resource.UserResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Users", description = "Create, read, update and delete users")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UsersController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome home!";
    }

    @PostMapping("/auth/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticateRequest request) {
        return userService.authenticate(request);
    }

    @PostMapping("/auth/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public Page<UserResource> getAllUsers(Pageable pageable) {
        return userMapper.modelListToPage(userService.getAll(), pageable);
    }
}