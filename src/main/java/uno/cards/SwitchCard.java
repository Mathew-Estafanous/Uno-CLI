package uno.cards;

import uno.Rule;

/**
 * Switch card defines its own implementation and how it is
 * used within the uno game. It shows how it will alter
 * the rule of the game.
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
    public Rule useCard() {
        return new Rule.Builder()
                .flipDirectionOfGame()
                .build();
    }
}
