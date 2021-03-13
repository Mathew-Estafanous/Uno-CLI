package uno;

import uno.cards.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Deck class manages the creation of the deck of cards and
 * dealing the top card whenever needed. Upon instantiating a Deck
 * object, the deck of cards will automatically generate and shuffled.
 * The following are the number of each card type that is made by the deck.
 * </br>
 * Numeric Cards: 80 (2 of Each Number & Colour)
 * Action Cards: 24 (2 of Each Colour)
 * Wild Cards: 8 (4 of Each Wild Type)
 */
public class Deck {

    //List out all the possible card numbers
    private final static CardType[] NUMERIC_TYPES = new CardType[] {
        CardType.ZERO, CardType.ONE, CardType.TWO,
        CardType.THREE, CardType.FOUR, CardType.FIVE,
        CardType.SIX, CardType.SEVEN, CardType.EIGHT, CardType.NINE
    };

    //List out all the possible colours
    private final static CardColour[] REGULAR_COLOURS = new CardColour[] {
        CardColour.BLUE, CardColour.GREEN, CardColour.RED, CardColour.YELLOW
    };

    private final List<Card> deckOfCards = new ArrayList<Card>();

    //Constructor that generates the deck of cards when it is called.
    public Deck() {
        generateNewDeck();
    }

    /**
     * Generates an entirely new deck by creating multiple of each type of card
     * and adding it to the deck of cards list.
     */
    private void generateNewDeck() {
        //Iterate over every numeric type of card.
        for(CardType type: NUMERIC_TYPES) {
            //Iterate over each regular colour
            for(CardColour colour: REGULAR_COLOURS) {
                //For-each colour & type generate 2 numeric cards.
                deckOfCards.addAll(Arrays.asList(
                    new Card(colour, type),
                    new Card(colour, type)
                ));
            }
        }

        //Iterate over each regular colour.
        for(CardColour colour: REGULAR_COLOURS) {
            //Iterate 2 times for each colour.
            for(int i = 0; i < 2; i++) {
                //Add each action card to the deck every iteration.
                deckOfCards.addAll(Arrays.asList(
                    new DrawTwoCard(colour),
                    new SkipCard(colour),
                    new SwitchCard(colour)
                ));
            }
        }

        //Iterate four times and add wild card types to the deck each time.
        for(int i = 0; i < 4; i++){
            deckOfCards.addAll(Arrays.asList(
                    new WildCard(),
                    new WildDrawFourCard()
            ));
        }

        //Use the collections library to shuffle the list.
        Collections.shuffle(deckOfCards);
    }

    /**
     * This method will return the top card in the deck when called and
     * remove it from the current deck. If the deck is empty, then
     * the method will return a null object.
     */
    public Card dealCard() {
        //Check to see if deck is empty. If it is, return null.
        if(deckOfCards.size() == 0) {
            return null;
        }
        //Call remove on the list and return that card.
        return deckOfCards.remove(0);
    }
}