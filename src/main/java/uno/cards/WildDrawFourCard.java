package uno.cards;

import uno.State;

/**
 * Draw Four Wild Cards define the implementation and how
 * it should be used within the game. Since it is a wild
 * card, it does not have a set colour that is pre-defined.
 * The colour is left up to the player to choose.
 */
public class WildDrawFourCard extends Card {

    //Constructor that defines both the colour and the type.
    public WildDrawFourCard() {
        super(CardColour.WILD, CardType.WILD_DRAWFOUR);
    }

    /**
     * Uses state builder to create a state object that defines that
     * the next player should draw two cards before they play.
     * @return State - Defined the Wild+4 Card
     */
    @Override
    public State useCard() {
        //TODO: Place holder until wild +4 can set the colour depending on user input.
        return new State.Builder(getColour(), getType())
                .nextPlayerDraws(4)
                .build();
    }
}
