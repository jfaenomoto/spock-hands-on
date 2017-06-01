package br.com.guiabolso.junit.first

import spock.lang.Specification

class PokemonProfessorSpec extends Specification {

    PokemonProfessor oak
    
    def setup() {
        oak = new PokemonProfessor()
    }
    
    def 'pegar charmander'() {
        given: 'depois de pegar 2 pokes'
        oak.getPokemon()
        oak.getPokemon()
        
        when: 'pego outro'
        def charmander = oak.getPokemon()
        
        then: 'deve ser um chamander'
        assert charmander == "Charmander"
    }
    
    def 'nao ha mais pokemons pra pegar'() {
        given: 'depois de pegar 6 pokemons'
        oak.getPokemon()
        oak.getPokemon()
        oak.getPokemon()
        oak.getPokemon()
        oak.getPokemon()
        oak.getPokemon()
        
        when: 'pego outro'
        oak.getPokemon()
        
        then: 'nao posso conseguir'
        thrown IllegalStateException
    }
}