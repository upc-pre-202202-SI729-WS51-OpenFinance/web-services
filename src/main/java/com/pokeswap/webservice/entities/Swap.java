package com.pokeswap.webservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "criptocurrencies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Swap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "criptoOrigin")
    private String criptoOrigin;
    @Column(name = "criptoDestiny")
    private String criptoDestiny;
    @Column(name = "cuantity")
    private String cuantity;
}
