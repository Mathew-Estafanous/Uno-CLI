package uno.cards;

import uno.Attribute;

/**
 * The Card class is involved in outlining each card's colour and
 * the card type. The card also outlines it's own implementation
 * of how it should be used in the the game.
 */
public class Card {

    private CardColour colour;
    private CardType type;
    
    //Constructor to create a card with the colour and type.
    public Card(CardColour colour, CardType type) {
        this.colour = colour;
        this.type = type;
    }

    /**
     * Outlines the card's implementation and how it should change
     * the state of the game whenever it is used.
     * @return Attribute - how the game state should be altered from
     * using the card.
     */
    public Attribute useCard() {
        /* Creates an Attribute by using the builder. Since this
        is a base card, the card does not modify many special states. */
        return new Attribute.Builder().build();
    }

    public CardColour getColour() {
        return colour;
    }

    public CardType getType() {
        return type;
    }

    public void setColour(CardColour colour) {
      this.colour = colour;
    }

    @Override
    public String toString() {
        String cardColour = getColour().name().concat(" ");
        String cardName = getType().name();
        return cardColour + cardName;
    }
}