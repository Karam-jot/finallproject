/**
 * SYST 17796 Project Base code.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @author CardAppraiser
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private final ArrayList<Card> cards;

    public GroupOfCards() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}//end class
