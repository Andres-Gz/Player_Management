package org.example.player_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private String name;

    public Player() {
    }

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Long> pokemonIds = new HashSet<>();



    public Player(String name) {
        this.name = name;
    }

    //Getters y setters

    public Set<Long> getPokemonIds() {
        return pokemonIds;
    }

    public void setPokemonIds(Set<Long> pokemonIds) {
        this.pokemonIds = pokemonIds;
    }

    public void addPokemonId(Long pokemonId) {
        this.pokemonIds.add(pokemonId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
