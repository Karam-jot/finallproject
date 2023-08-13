package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models the War game.
 */
public class War extends Game {
    private GroupOfCards deck;
    private ArrayList<Card> pile;

    public War() {
        super("War");
        deck = new GroupOfCards();
        pile = new ArrayList<>();
    }

    /**
     * Initializes the deck of cards and distributes them among the players.
     */
    private void initialize() {
        deck = createDeck();
        deck.shuffle();

        ArrayList<Player> players = getPlayers();
        int numPlayers = players.size();
        int numCardsPerPlayer = deck.getCards().size() / numPlayers;

        for (Player player : players) {
            GroupOfCards hand = new GroupOfCards();
            for (int i = 0; i < numCardsPerPlayer; i++) {
                Card card = deck.getCards().remove(0);
                hand.addCard(card);
            }
            player.setHand(hand);
        }
    }

    /**
     * Creates a standard deck of 52 playing cards.
     */
    private GroupOfCards createDeck() {
        GroupOfCards deck = new GroupOfCards();

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(rank, suit);
                deck.addCard(card);
            }
        }

        return deck;
    }

    @Override
    public void play() {
        initialize();
        System.out.println("Let's play War!");

        while (!isGameOver()) {
            ArrayList<Card> cardsInPlay = new ArrayList<>();

            for (Player player : getPlayers()) {
                Card card = player.playCard();
                cardsInPlay.add(card);
                System.out.println(player.getName() + " plays: " + card);
            }

            Player roundWinner = determineRoundWinner(cardsInPlay);
            roundWinner.getPile().getCards().addAll(cardsInPlay);
            System.out.println("Round winner: " + roundWinner.getName());
        }

        declareWinner();
    }

    @Override
    public void declareWinner() {
        Player winner = getWinner();
        System.out.println("Game over!");
        System.out.println("The winner is: " + winner.getName());
    }

    /**
     * Determines the winner of a round based on the cards played by the players.
     * Returns the player who played the highest-ranking card.
     */
    private Player determineRoundWinner(ArrayList<Card> cardsInPlay) {
        Card highestCard = cardsInPlay.get(0);
        Player roundWinner = getPlayers().get(0);

        for (int i = 1; i < cardsInPlay.size(); i++) {
            Card currentCard = cardsInPlay.get(i);
            if (compareCards(currentCard, highestCard) > 0) {
                highestCard = currentCard;
                roundWinner = getPlayers().get(i);
            }
        }

        return roundWinner;
    }

    /**
     * Compares two cards based on their ranks.
     * Returns a positive number if the first card is higher, a negative number if the second card is higher,
     * or 0 if the cards have equal ranks.
     */
    private int compareCards(Card card1, Card card2) {
        int rankValue1 = CardUtil.getRankValue(card1);
        int rankValue2 = CardUtil.getRankValue(card2);
        return Integer.compare(rankValue1, rankValue2);
    }

    /**
     * Checks if the game is over.
     * Returns true if any player has no cards left in their hand.
     */
    private boolean isGameOver() {
        for (Player player : getPlayers()) {
            if (player.getHand().getCards().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines the winner of the game based on the players' pile sizes.
     * Returns the player with the largest pile.
     */
    private Player getWinner() {
        Player winner = getPlayers().get(0);
        int maxPileSize = winner.getPile().getCards().size();

        for (int i = 1; i < getPlayers().size(); i++) {
            Player player = getPlayers().get(i);
            int pileSize = player.getPile().getCards().size();
            if (pileSize > maxPileSize) {
                winner = player;
                maxPileSize = pileSize;
            }
        }

        return winner;
    }

    public static void main(String[] args) {
        War warGame = new War();
        warGame.addPlayer(new WarPlayer("Player 1"));
        warGame.addPlayer(new WarPlayer("Player 2"));
        warGame.play();
    }
}
