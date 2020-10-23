package DefiningClassesExercise.PokemonTrainer;

import java.util.List;
import java.util.Set;

public class Trainer {

    private String name;
    private int badges;
    private Set<Pokemon> pokemons;

    public Trainer(String name, Set<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
        this.badges = 0;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
