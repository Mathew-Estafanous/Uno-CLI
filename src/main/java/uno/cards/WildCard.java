package uno.cards;

import uno.State;

/**
 * Wild Card is a class that defines its special implementation
 * of how it should be used within the game. Since it is a wild
 * card, the card colour is not pre-defined and is left up for
 * the user to select.
 */
public class WildCard extends Card {

    //Constructor that defines both tye colour an the type.
    public WildCard() {
        super(CardColour.WILD, CardType.WILD);
    }

    /**
     * Uses state builder to create a state object that defines that
     * the next player should draw two cards before they play.
     * @return State - Defined the Wild Card
     */
    @Override
    public State useCard() {
        //TODO: Placeholder till wild card can determine the user selected colour.
        return new State.Builder(getColour(), getType())
                .build();
    }
}
