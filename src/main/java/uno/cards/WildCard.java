package uno.cards;

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
}
