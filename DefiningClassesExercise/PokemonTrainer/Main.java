package DefiningClassesExercise.PokemonTrainer;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<Pokemon>> trainerPokemonMap = new LinkedHashMap<>();
        Map<String, Integer> trainerBadgesMap = new LinkedHashMap<>();
        String[] input = scan.nextLine().split(" ");

        Trainer trainer = null;
        Pokemon pokemon = null;
        while (!input[0].equals("Tournament")) {

            String name = input[0];

            pokemon = new Pokemon(input[1], input[2], Integer.parseInt(input[3]));
            if (trainer == null) {
                trainer = new Trainer(name, new LinkedHashSet<>());
                trainer.getPokemons().add(pokemon);
                trainer.getPokemons().add(pokemon);
                trainerPokemonMap.put(name, trainer.getPokemons());
            } else {
                boolean isExisting = false;
                for (Map.Entry<String, Set<Pokemon>> entry : trainerPokemonMap.entrySet()) {

                    if (entry.getKey().equals(name)) {
                        isExisting = true;
                        entry.getValue().add(pokemon);
                        trainerPokemonMap.put(name, entry.getValue());
                        break;

                    }
                }
                if (!isExisting) {
                    trainer = new Trainer(name, new LinkedHashSet<>());
                    trainer.getPokemons().add(pokemon);
                    trainerPokemonMap.put(name, trainer.getPokemons());
                }
            }
            trainerBadgesMap.putIfAbsent(name, 0);

            input = scan.nextLine().split("\\s+");
        }
        System.out.println();
        input = scan.nextLine().split("\\s+");
        while (!input[0].equals("End")) {

            String element = input[0];

            for (Map.Entry<String, Set<Pokemon>> entry : trainerPokemonMap.entrySet()) {
                boolean hasStrongPokemon = false;
                for (Pokemon currentPokemon : entry.getValue()) {
                    int currentHealth = currentPokemon.getHealth();
                    String pokemonElement = currentPokemon.getElement();
                    if (pokemonElement.equals(element) && currentHealth > 0) {
                        hasStrongPokemon = true;
                        trainerBadgesMap.put(entry.getKey(), trainerBadgesMap.get(entry.getKey()) + 1);
                        break;
                    }
                }
                if (!hasStrongPokemon && pokemon != null) {
                    for (Pokemon currentPokemon : trainerPokemonMap.get(entry.getKey())) {
                        currentPokemon.setHealth(currentPokemon.getHealth() - 10);
//                        if (currentPokemon.getHealth() <= 0) {
//                            entry.getValue().remove(currentPokemon); не трябва да се премахва по време на итериране
//                        }
                    }
                }
            }

            input = scan.nextLine().split(" ");
        }

       // int numberOfPokemon
        trainerBadgesMap.entrySet().stream()
                .sorted((b1, b2) -> b2.getValue().compareTo(b1.getValue())).forEach(badge -> {
            System.out.printf("%s %d %d%n", badge.getKey(), badge.getValue(),
            trainerPokemonMap.get(badge.getKey()).stream()
                    .filter(p -> p.getHealth() > 0).collect(Collectors.toSet()).size());
        });

    }
}
