package uno.cards;

import uno.State;

/**
 * Switch card defines its own implementation and how it is
 * used within the uno game. It shows how it will alter
 * the state of the game.
 */
public class SwitchCard extends Card {

    //Constructor that takes in the card colour but defines it's own type.
    public SwitchCard(CardColour colour) {
        super(colour, CardType.SWITCH);
    }

    /**
     * Uses state builder to create a state object that defines that
     * the the direction of the game should switch upon the use of
     * this card.
     * @return State - Defined Switch Card
     */
    @Override
    public State useCard() {
        return new State.Builder(getColour(), getType())
                .flipDirectionOfGame()
                .build();
    }
}
