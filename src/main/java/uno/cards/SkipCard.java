package uno.cards;

import uno.Attribute;

/**
 * SkipCard class defines how the SKIP card is implemented within the game,
 * and how it alters the rules of the game.
 */
public class SkipCard extends Card {

    //Constructor takes in the card colour but defines it's own type.
    public SkipCard(CardColour colour) {
        super(colour, CardType.SKIP);
    }

    /**
     * Uses rule builder to create a rule object that defines that
     * the the game should skip the next player.
     * @return Rule - Defined skip two card
     */
    @Override
    public Attribute useCard() {
        return new Attribute.Builder()
                .shouldSkipPlayer()
                .build();
    }
}
