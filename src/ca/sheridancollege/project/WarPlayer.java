package ca.sheridancollege.project;

/**
 * A class that models a player in the War game.
 */
public class WarPlayer extends Player {
    public WarPlayer(String name) {
        super(name);
    }

    @Override
    public Card playCard() {
        return getHand().getCards().remove(0);
    }
}
