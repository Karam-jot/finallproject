/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {
    private final String name;
    private GroupOfCards hand;
    private GroupOfCards pile;

    public Player(String name) {
        this.name = name;
        this.hand = new GroupOfCards();
        this.pile = new GroupOfCards();
    }

    public String getName() {
        return name;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    public GroupOfCards getPile() {
        return pile;
    }

    public void setPile(GroupOfCards pile) {
        this.pile = pile;
    }

    public abstract Card playCard();
}
