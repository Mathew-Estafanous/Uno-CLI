package uno.cards;

/**
 * This card defines the the implementation for how the draw
 * two cards works for the uno game and how it alters the
 * state of the game when played.
 */
public class DrawTwoCard extends Card {

    //Constructor that takes in the card colour but defines the card type itself.
    public DrawTwoCard(CardColour colour) {
        super(colour, CardType.DRAWTWO);
    }
}
