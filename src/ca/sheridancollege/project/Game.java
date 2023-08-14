/**
 * SYST 17796 Project Base code.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;


/**
 * @author CardAppraiser
 */
public abstract class Game {
    private final String name;
    private final ArrayList<Player> players;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public abstract void play();

    public abstract void declareWinner();
}

