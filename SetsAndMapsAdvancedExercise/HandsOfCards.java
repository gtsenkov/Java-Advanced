package SetsAndMapsAdvancedExercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Set<String>> playerHand = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("JOKER")) {
            String[] draw = input.split(": ");
            String player = draw[0];
            String[] cards = draw[1].split(", ");
            for (int i = 0; i < cards.length; i++) {
                String currentCard = cards[i];
                playerHand.putIfAbsent(player, new LinkedHashSet<>());
                playerHand.get(player).add(currentCard);
            }
            input = scan.nextLine();
        }
        Map<String, Integer> playerSore = new LinkedHashMap<>();

        for (Map.Entry<String, Set<String>> entry : playerHand.entrySet()) {
            int score = 0;
            for (String currentCard : entry.getValue()) {
                int currentPowerScore = 0;
                char currentPower = currentCard.charAt(0);
                switch (currentPower) {
                    case 'J':
                        currentPowerScore = 11;
                        break;
                    case 'Q':
                        currentPowerScore = 12;
                        break;
                    case 'K':
                        currentPowerScore = 13;
                        break;
                    case 'A':
                        currentPowerScore = 14;
                        break;
                    default:
                        currentPowerScore = Integer.parseInt(String.valueOf(currentCard.charAt(0)));
                }
                char currentCardMultiplier = currentCard.charAt(1);
                if (currentCard.length() == 3) {
                    currentPowerScore = 10;
                    currentCardMultiplier = currentCard.charAt(2);
                }
                switch (currentCardMultiplier) {
                    case 'S':
                        score += currentPowerScore * 4;
                        break;
                    case 'H':
                        score += currentPowerScore * 3;
                        break;
                    case 'D':
                        score += currentPowerScore * 2;
                        break;
                    case 'C':
                        score += currentPowerScore;
                        break;
                }
            }
            playerSore.put(entry.getKey(), score);
        }
//        for (Map.Entry<String, Integer> integerEntry : playerSore.entrySet()) {
//            System.out.println(String.format("%s: %d", integerEntry.getKey(), integerEntry.getValue()));
//        }
        playerHand.entrySet()
                .forEach((p-> System.out.println(String.format("%s: %d", p.getKey(), playerSore.get(p.getKey())))) );
    }
}
