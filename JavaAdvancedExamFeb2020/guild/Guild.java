package JavaAdvancedExamFeb2020.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(player -> name.equals(player.getName()));
    }


    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        int playersToRemove = 0;
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                playersToRemove++;
            }
        }
        Player[] removedPlayers = new Player[playersToRemove];

        int i = 0;
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                removedPlayers[i++] = player;
            }
                   this.roster = this.roster.stream()
                           .filter(p-> !p.getClazz().equals(clazz))
                   .collect(Collectors.toList());

        }
        return removedPlayers;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:", getName()));
        sb.append(System.lineSeparator());
        for (Player player : roster) {
            sb.append(player);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

}
