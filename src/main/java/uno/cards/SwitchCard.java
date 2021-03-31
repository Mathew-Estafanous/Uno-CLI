package uno.cards;

import uno.Attribute;

/**
 * SwitchCard class defines how the SWITCH card is implemented within the 
 * game, and how it alters the rules of the game.
 */
public class SwitchCard extends Card {

    //Constructor that takes in the card colour but defines it's own type.
    public SwitchCard(CardColour colour) {
        super(colour, CardType.SWITCH);
    }

    /**
     * Uses rule builder to create a rule object that defines that
     * the the direction of the game should switch upon the use of
     * this card.
     * @return Rule - Defined Switch Card
     */
    @Override
    public Attribute useCard() {
        return new Attribute.Builder()
                .flipDirectionOfGame()
                .build();
    }
}
