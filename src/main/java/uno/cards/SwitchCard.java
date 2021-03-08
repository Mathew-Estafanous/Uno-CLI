package uno.cards;

/**
 * Switch card defines its own implementation and how it is
 * used within the uno game. It shows how it will alter
 * the state of the game.
 */
public class SwitchCard extends Card {

    //Constructor that takes in the card colour but defines it's own type.
    public SwitchCard(CardColour colour) {
        super(colour, CardType.SWITCH);
    }
}
