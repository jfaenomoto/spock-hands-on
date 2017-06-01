package br.com.guiabolso.junit.first

import spock.lang.Specification

class PokemonProfessorSpec extends Specification {

    private PokemonProfessor professor;

    def 'get Bulbasaur'() {
        when:
        def pokemon = professor.getPokemon()

        then:
        assert pokemon == "Bulbasaur"
    }

    def 'get Squirtle'() {
        given:
        professor.getPokemon()

        when:
        def pokemon = professor.getPokemon()

        then:
        assert pokemon == "Squirtle"
    }

    def 'get Charmander'() {
        given:
        5.times { professor.getPokemon() }

        when:
        def pokemon = professor.getPokemon()

        then:
        assert pokemon == "Charmander"
    }

    def 'out of Pokemon'() {
        given: "o professor dá 6 pokemons"
        6.times { professor.getPokemon() }

        when: "eu peço um pokemon para o professor"
        professor.getPokemon()

        then: "acabou ;("
        def exception = thrown IllegalStateException
    }
    
    def setup() {
        professor = new PokemonProfessor()
    }
}
