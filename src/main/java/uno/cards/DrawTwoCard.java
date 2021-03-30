package uno.cards;

import uno.Rule;

/**
 * DrawTwoCard class defines how the DRAWTWO card is implemented within 
 * the game, and how it alters the rules of the game.
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
