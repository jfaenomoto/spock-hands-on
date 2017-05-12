package br.com.guiabolso.junit.fourth

import spock.lang.Specification

class PokemonBattleSpec extends Specification {

    def battle
    
    def 'you win'(){
        given:
        def you = new Trainer("João", "Squirtle", "Pidgey", "Geodude")
        def swimmer = new Trainer("Antonio", "Staryu")
        
        and:
        battle.battleSystem.winnerFrom("Squirtle", "Staryu") >> { return "Staryu" }
        battle.battleSystem.winnerFrom("Pidgey", "Staryu") >> { return "Staryu" }
        battle.battleSystem.winnerFrom("Geodude", "Staryu") >> { return "Geodude" }
        
        when:
        def winner = battle.battle(you, swimmer)
        
        then:
        assert winner == you
        
        and:
        2 * battle.expSystem.giveExpTo("Staryu")
        1 * battle.expSystem.giveExpTo("Geodude")
    }
    
    def 'you lose'() {
        given:
        def you = new Trainer("João", "Pikachu", "Magikarp")
        def hiker = new Trainer("Manuel", "Diglett")
        
        and:
        battle.battleSystem.winnerFrom("Pikachu", "Diglett") >> { return "Diglett" }
        battle.battleSystem.winnerFrom("Magikarp", "Diglett") >> { return "Diglett" }
        
        when:
        def winner = battle.battle(you, hiker)
        
        then:
        assert winner == hiker
        
        and:
        2 * battle.expSystem.giveExpTo("Diglett")
    }
    
    def setup() {
        battle = new PokemonBattle()
        battle.battleSystem = Mock(BattleSystem)
        battle.expSystem = Mock(ExperienceSystem)
    }

}
