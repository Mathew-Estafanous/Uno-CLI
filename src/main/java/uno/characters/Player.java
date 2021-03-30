package uno.characters;

import uno.cards.Card;
import uno.cards.CardColour;
import uno.cards.CardType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static uno.cards.CardColour.*;

/**
 * Player is an abstract class that both the user and AI players
 * will extend from. Every player has a name and contains a hand
 * of cards.
 * </b>
 * Card selection implementation is left to the sub-class that extends
 * this abstract class.
 */
public abstract class Player {

    //initializing a name, and cardHand
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

    //Adds a singular card to the player's hand.
    public void pickUpCard(Card card) {
        cardHand.add(card);
    }

    //Method that gets the name of the player
    public String getName() {
        return name;
    }

    //Sets the size of the card hand to zero whenever any player runs out of cards
    public boolean isOutOfCards() {
        return cardHand.size() == 0;
    }

    /**
     * Takes in the chosen card and checks if the card can be played on top
     * of the top card. When 'true' is returned, the chosen card is valid
     * and can be played.
     * @param chosenCard - The card the player intends to use.
     * @param topCard - The top card at the current point in the game.
     */
    protected boolean isValidCard(Card chosenCard, Card topCard) {
        CardType chosenType = chosenCard.getType();
        CardColour chosenColour = chosenCard.getColour();
        /* Check if card meets at least one of the rules. If it does, then
        * return true. If none are met, then return false. */
        return (chosenColour == topCard.getColour()) ||
                (chosenType == topCard.getType()) ||
                (chosenType == CardType.WILD) ||
                (chosenType == CardType.WILD_DRAWFOUR);
    }

    /**
     * Modify a WildCard colour by taking in the card and the chosen number
     * of 0 to 3. Then alters the card colour to the associated colour:
     * GREEN: 0, RED: 1, YELLOW: 2, BLUE: 3
     * @param card - The wild card that is being altered.
     * @param choice - The number choice of 0 to 3.
     */
    protected void alterWildCardToColour(Card card, int choice) {
        final Map<Integer, CardColour> numToColour = Map.of(
                0, RED, 1, BLUE,
                2, YELLOW, 3, GREEN
        );
        card.setColour(numToColour.get(choice));
    }

    /**
     * This API is used to tell the player that they need to choose
     * a card from their hand and return their choice. Chosen cards
     * should also be removed from the player's hand.
     * @return Card - The chosen card by the player.
     */
    public abstract Card chooseCard(Card topCard);
}
