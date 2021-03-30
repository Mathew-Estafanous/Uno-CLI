package uno;

import uno.cards.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import static uno.cards.CardType.*;
import static uno.cards.CardColour.*;

/**
 * The Deck class manages the creation of the deck of cards and
 * dealing the top card whenever needed. Upon instantiating a Deck
 * object, the deck of cards will automatically generate and shuffle.
 * The following are the number of each card type that is made by the deck.
 * </br>
 * Numeric Cards: 80 (2 of Each Number & Colour)
 * Action Cards: 24 (2 of Each Colour)
 * Wild Cards: 8 (4 of Each Wild Type)
 */
public class Deck {

    //List out all the possible card numbers
    private final static CardType[] NUMERIC_TYPES = new CardType[] {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
    };

    //List out all the possible colours
    private final static CardColour[] REGULAR_COLOURS = new CardColour[] {
        BLUE, GREEN, RED, YELLOW
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
        addNumericCards();
        addActionCards();
        addWildCards();

        //Use the collections library to shuffle the list.
        Collections.shuffle(deckOfCards);
    }

//Adds the corresponding amount of wild cards to the deck
    private void addWildCards() {
        //Iterate four times and add wild card types to the deck each time.
        for(int i = 0; i < 4; i++){
            deckOfCards.addAll(Arrays.asList(
                    new WildCard(),
                    new WildDrawFourCard()
            ));
        }
    }

    //Adds the corresponding amount of action cards to the deck
    private void addActionCards() {
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
    }

    //Adds the corresponding amount of numeric cards to the deck
    private void addNumericCards() {
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
    }

    /**
     * Resets the entire deck with a new set of cards that are
     * properly shuffled.
     */ 
    private void resetDeck() {
      deckOfCards.clear();
      generateNewDeck();
    }

    /**
     * This method will return the top card in the deck when called and
     * remove it from the current deck. If the deck is empty, then
     * the method will reset the deck.
     */
    public Card dealCard() {
        //Check to see if deck is empty. If it is reset the deck.
        if(deckOfCards.size() == 0) {
            resetDeck();
        }
        //Call remove on the list and return that card.
        return deckOfCards.remove(0);
    }
}
