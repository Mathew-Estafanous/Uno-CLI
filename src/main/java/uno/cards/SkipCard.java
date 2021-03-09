package uno.cards;

import uno.State;

/**
 * SkipCard class, defines the implementation of how it is
 * used within the game, and how it alters the state of the
 * game.
 */
public class SkipCard extends Card {

    //Constructor takes in the card colour but defines it's own type.
    public SkipCard(CardColour colour) {
        super(colour, CardType.SKIP);
    }

    /**
     * Uses state builder to create a state object that defines that
     * the the game should skip the next player.
     * @return State - Defined skip two card
     */
    @Override
    public State useCard() {
        return new State.Builder(getColour(), getType())
                .shouldSkipPlayer()
                .build();
    }
}
