package uno.cards;

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
}
