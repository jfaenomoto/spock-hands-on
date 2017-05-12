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
        5.times {professor.getPokemon() }
        
        when:
        def pokemon = professor.getPokemon()
        
        then:
        assert pokemon == "Charmander"
    }
    
    def 'out of Pokemon'() {
        given:
        6.times {professor.getPokemon() }
        
        when:
        professor.getPokemon()
        
        then:
        def exception = thrown IllegalStateException
    }
    
    def setup() {
        professor = new PokemonProfessor()
    }
}
