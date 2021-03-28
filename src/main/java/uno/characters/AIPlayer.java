package uno.characters;

import uno.cards.Card;

import static uno.cards.CardColour.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/* The AIPlayer class is an extension of the player class, it 
 * randomly selects cards, and randomly sets the colour whenever 
 * a wild card is played. 
 */
public class AIPlayer extends Player {

  private Random rand = new Random();

    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public Card chooseCard(Card topCard) {
      List<Card> validCards = allValidCards(topCard);
      if (validCards.size() == 0)
        return null;

      //randomly chooses a card.
      int choice = rand.nextInt(validCards.size());
      //removes selected card from the hand
      Card card = cardHand.remove(cardHand.indexOf(validCards.get(choice)));
      if(card.getColour() == WILD) {
        //randomly setting the colour after a wild card is played
        choice = rand.nextInt(4);
        alterWildCardToColour(card, choice);
      }
      return card;
    }

  private List<Card> allValidCards(Card topCard) {
    return cardHand.stream()
            .filter(card -> isValidCard(card, topCard))
            .collect(Collectors.toList());
  }
}
