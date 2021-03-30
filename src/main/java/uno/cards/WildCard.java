package uno.cards;

import uno.Rule;

/**
 * WildCard class defines how the WILD card is implemented within the game,
 * and how it alters the rules of the game.
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
        return new Rule.Builder()
                .build();
    }
}
