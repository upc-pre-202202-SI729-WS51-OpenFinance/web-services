package com.pokeswap.webservice.security.resource;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class UserResource {
    private Long id;
    private String email;
    private String username;
    private List<String> roles;
}
