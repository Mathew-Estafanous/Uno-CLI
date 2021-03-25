package uno.cards;

import uno.Rule;

/**
 * This card defines the the implementation for how the draw
 * two cards works for the uno game and how it alters the
 * rule of the game when played.
 */
public class DrawTwoCard extends Card {

    //Constructor that takes in the card colour but defines the card type itself.
    public DrawTwoCard(CardColour colour) {
        super(colour, CardType.DRAW_TWO);
    }

    /**
     * Uses rule builder to create a rule object that defines that
     * the next player should draw two cards before they play.
     * @return Rule - Defined draw two cards
     */
    @Override
    public Rule useCard() {
        return new Rule.Builder()
                .nextPlayerDraws(2)
                .build();
    }
}
