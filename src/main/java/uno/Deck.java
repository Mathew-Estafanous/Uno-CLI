package uno;

import uno.cards.Card;
import uno.cards.CardColour;
import uno.cards.CardType;

import java.util.List;

public class Deck {

    private List<Card> deckOfCards;

    private final static CardType[] NUMERIC_TYPES = new CardType[] {
            CardType.ZERO, CardType.ONE, CardType.TWO, CardType.THREE,
            CardType.FOUR, CardType.FIVE, CardType.SIX, CardType.SEVEN,
            CardType.EIGHT, CardType.NINE
    };

    private final static CardColour[] REGULAR_COLOURS = new CardColour[] {
            CardColour.BLUE, CardColour.GREEN, CardColour.RED, CardColour.YELLOW
    };

    public Deck() {
        generateNewDeck();
    }

    private void generateNewDeck() {
        
    }
}
