package br.com.guiabolso.junit.third;

import spock.lang.*

class PokeCenterSpec extends Specification{

    def pokeCenter

    def 'heal all pokemon'() {
        given:
        def pokeballs = [
            new Pokeball("Squirtle"),
            new Pokeball("Pidgey"),
            new Pokeball("Caterpie")
        ]
        
        when:
        pokeCenter.heal(pokeballs)
        
        then:
        1 * pokeCenter.machine.heal("Squirtle")
        1 * pokeCenter.machine.heal("Pidgey")
        1 * pokeCenter.machine.heal("Caterpie")
    }
    
    def 'heal if no pokemon'() {
        when:
        pokeCenter.heal(null)
        
        then:
        0 * pokeCenter.machine.heal(_)
    }

    def setup() {
        pokeCenter = new PokeCenter()
        pokeCenter.machine = Mock(HealingMachine)
    }
}
