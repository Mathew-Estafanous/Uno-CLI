package uno.cards;

import uno.Rule;

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
     * Uses rule builder to create a rule object that defines that
     * the next player should draw two cards before they play.
     * @return Rule - Defined the Wild+4 Card
     */
    @Override
    public Rule useCard() {
        return new Rule.Builder()
                .nextPlayerDraws(4)
                .build();
    }
}
