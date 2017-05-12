package br.com.guiabolso.junit.fourth

class PokemonBattle {

    private BattleSystem battleSystem;
    private ExperienceSystem expSystem;
    
    public PokemonBattle() {
        this.battleSystem = new BattleSystem();
        this.expSystem = new ExperienceSystem();
    }
    
    def battle(Trainer you, Trainer trainer) {
        while (true) {
            if (!trainer.hasPokemon()) {
                println String.format("%s was defeated!", trainer.getName())
                return you
            }
            if (!you.hasPokemon()) {
                println String.format("%s was defeated!", you.getName())
                return trainer
            }
            def yourPokemon = you.activePokemon
            def trainerPokemon = trainer.activePokemon
            def winner = this.battleSystem.winnerFrom(yourPokemon, trainerPokemon)
            if (yourPokemon == winner) {
                trainer.faintActivePokemon()
            } else {
                you.faintActivePokemon()
            }
            this.expSystem.giveExpTo(winner)
        }
    }
    
}
