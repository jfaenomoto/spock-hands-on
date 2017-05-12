package br.com.guiabolso.junit.fourth

import java.util.Arrays;
import java.util.LinkedList;

class Trainer {

    String name
    
    private def pokemon
    
    public Trainer(String name, String... pokemon) {
        this.name = name;
        this.pokemon = pokemon as List
    }

    public String getActivePokemon() {
        return pokemon.get(0);
    }
    
    public void faintActivePokemon() {
        pokemon.remove(0);
    }
    
    public boolean hasPokemon() {
        return pokemon;
    }
}
