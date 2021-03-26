package uno.characters;

import uno.cards.Card;
import uno.cards.CardColour;
import uno.cards.CardType;

import java.util.ArrayList;
import java.util.List;

/**
 * Player is an abstract class that both the user and AI players
 * will extend from. Every player has a name and contains a hand
 * of cards.
 * </b>
 * Card selection implementation is left to the sub-class that extends
 * this abstract class.
 */
public abstract class Player {

    private final String name;

    protected List<Card> cardHand = new ArrayList<>();

    //Constructor that requires a name to be instantiated.
    public Player(String name) {
        this.name = name;
    }

    /**
     * Takes in a list of cards that are then added to the player's
     * card hand.
     * @param cards - This list should not be null.
     */
    public void pickUpCards(List<Card> cards) {
        cardHand.addAll(cards);
    }

    public void pickUpCard(Card card) {
        cardHand.add(card);
    }

    public String getName() {
        return name;
    }

    public boolean isOutOfCards() {
        return cardHand.size() == 0;
    }

    protected boolean isValidCard(Card chosenCard, Card topCard) {
        CardType chosenType = chosenCard.getType();
        CardColour chosenColour = chosenCard.getColour();
        return (chosenColour == topCard.getColour()) ||
                (chosenType == topCard.getType()) ||
                (chosenType == CardType.WILD) ||
                (chosenType == CardType.WILD_DRAWFOUR);
    }

    /**
     * This API is used to tell the player that they need to choose
     * a card from their hand and return their choice. Chosen cards
     * should also be removed from the player's hand.
     * @return Card - The chosen card by the player.
     */
    public abstract Card chooseCard(Card topCard);
}
