/**
 * SYST 17796 Project Base code.
 */
package ca.sheridancollege.project;


/**
 * @author CardAppraiser
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
