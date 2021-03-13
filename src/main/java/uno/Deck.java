package uno;

import uno.cards.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * sfsfafaf
 */
public class Deck {

  //Lists out all the possible card numbers
  private final static CardType[] NUMERIC_TYPES = new CardType[] { 
    CardType.ZERO, CardType.ONE, CardType.TWO, 
    CardType.THREE, CardType.FOUR, CardType.FIVE, 
    CardType.SIX, CardType.SEVEN, CardType.EIGHT, CardType.NINE 
  };

  //Lists out all the possible colours
  private final static CardColour[] REGULAR_COLOURS = new CardColour[] { 
    CardColour.BLUE, CardColour.GREEN, CardColour.RED, CardColour.YELLOW 
  };

  private List<Card> deckOfCards = new ArrayList<Card>();

  public Deck() {
    generateNewDeck();
  }

  //Creates two of each numerical cards and adds to deck
  private void generateNewDeck() { 
      for(CardType type: NUMERIC_TYPES) {
        for(CardColour colour: REGULAR_COLOURS) {
          deckOfCards.add(new Card(colour, type));
          deckOfCards.add(new Card(colour, type));
        }
      }

      //Create two of each ActionCard and adds to deck
      for(CardColour colour: REGULAR_COLOURS) {
        for(int i = 0; i < 2; i++) {
          deckOfCards.add(new DrawTwoCard(colour));
          deckOfCards.add(new SkipCard(colour));
          deckOfCards.add(new SwitchCard(colour));
        }
      }
      
      //Create 4 of each Wild Card and adds to deck
      for(int i = 0; i < 4; i++){
        deckOfCards.add(new WildCard());
        deckOfCards.add(new WildDrawFourCard());
      }

      Collections.shuffle(deckOfCards);
  }

  //This method deals a card
  public Card dealCard() {
    return deckOfCards.remove(0);
  }
}
