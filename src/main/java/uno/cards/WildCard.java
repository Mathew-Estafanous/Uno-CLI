package uno.cards;

import uno.Rule;

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
     * Uses rule builder to create a rule object that defines that
     * the next player should draw two cards before they play.
     * @return Rule - Defined the Wild Card
     */
    @Override
    public Rule useCard() {
        //TODO: Placeholder till wild card can determine the user selected colour.
        return new Rule.Builder()
                .build();
    }
}
