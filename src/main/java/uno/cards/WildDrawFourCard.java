package uno.cards;

import uno.Attribute;

/**
 * WildDrawFourCard class defines how the WILDDrawFour card is implemented * within the game, and how it alters the rules of the game.
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
    public Attribute useCard() {
        return new Attribute.Builder()
                .nextPlayerDraws(4)
                .build();
    }
}
