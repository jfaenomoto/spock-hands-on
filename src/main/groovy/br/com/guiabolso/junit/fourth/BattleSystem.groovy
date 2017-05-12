package br.com.guiabolso.junit.fourth

import java.util.Random

class BattleSystem {

    private Random random = new Random()
    
    def winnerFrom(String pokemon1, String pokemon2) {
        if (this.random.nextBoolean()) {
            println String.format("%s fainted!", pokemon2)
            return pokemon1
        } else {
            println String.format("%s fainted!", pokemon1)
            return pokemon2
        }
    }
    
}
