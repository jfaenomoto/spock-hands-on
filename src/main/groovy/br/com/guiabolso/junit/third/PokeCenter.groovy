package br.com.guiabolso.junit.third

import java.util.List;

class PokeCenter {

    private HealingMachine machine;
    
    PokeCenter() {
        this.machine = new HealingMachine();
    }
    
    def heal(List<Pokeball> pokeballs) {
        pokeballs.each { pokeball ->
            this.machine.heal(pokeball.pokemon);
        }
    }
    
}
