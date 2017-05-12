package br.com.guiabolso.junit.first

class PokemonProfessor {

    private int contador;

    PokemonProfessor() {
        this.contador = 0;
    }

    String getPokemon() {
        if (contador > 5) {
            throw new IllegalStateException("no more pokemon ;(");
        }
        def pokemon;
        if (contador % 3 == 0) {
            pokemon = "Bulbasaur";
        } else if (contador % 3 == 1) {
            pokemon = "Squirtle";
        } else {
            pokemon = "Charmander";
        }
        this.contador++;
        return pokemon;
    }
}
