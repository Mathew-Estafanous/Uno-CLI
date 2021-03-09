package uno.cards;

import uno.State;

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

    /**
     * Uses state builder to create a state object that defines that
     * the next player should draw two cards before they play.
     * @return State - Defined draw two cards
     */
    @Override
    public State useCard() {
        return new State.Builder(getColour(), getType())
                .nextPlayerDraws(2)
                .build();
    }
}
