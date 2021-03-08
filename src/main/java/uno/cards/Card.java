package uno.cards;

/**
 * The Card class is involved in outlining each card's colour,
 * the card type. The card also outlines it's own implementation
 * of how it should be used in the the game.
 */
public class Card {

    private final CardColour colour;
    private final CardType type;

    //Constructor to create a card with the colour and type.
    public Card(CardColour colour, CardType type) {
        this.colour = colour;
        this.type = type;
    }

    /**
     * Outlines the card's implementation and how it should change
     * the state of the game whenever it is used.
     * @return State - how the game state should be altered from
     * using the card.
     */
    public int useCard() {
        //TODO: Place holder integer until state class is created.
        return 0;
    }

    public CardColour getColour() {
        return colour;
    }

    public CardType getType() {
        return type;
    }
}