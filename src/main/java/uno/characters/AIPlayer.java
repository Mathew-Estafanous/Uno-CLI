package uno.characters;

import uno.cards.Card;

import static uno.cards.CardColour.WILD;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/** The AIPlayer class is an extension of the Player class, it 
 * randomly selects valid cards, and randomly sets the colour whenever 
 * a wild card is played. 
 */
public class AIPlayer extends Player {

  private Random rand = new Random();

  // Constructor that takes in a name from the super class
  public AIPlayer(String name) {
    super(name);
  }

  /**
   * Method that determines if the AI player has any cards left in their 
   * hand, generates random valid cards, and then removes the played card * from the AIplayers hand.
   */
  @Override
  public Card chooseCard(Card topCard) {
    List<Card> validCards = allValidCards(topCard);
    if (validCards.size() == 0)
      return null;

    // randomly chooses a card.
    int choice = rand.nextInt(validCards.size());
    // removes selected card from the hand
    Card card = cardHand.remove(cardHand.indexOf(validCards.get(choice)));
    if (card.getColour() == WILD) {
      // randomly setting the colour after a wild card is played
      choice = rand.nextInt(4);
      alterWildCardToColour(card, choice);
    }
    return card;
  }

  /**
   * This method creates a list of all the possible valid cards that can 
   * be played and does not include the cards that violate the rules of 
   * UNO. It works withthe chooseCard class to ensure the card selected 
   * from the AI is a valid play.
   */
  private List<Card> allValidCards(Card topCard) {
    return cardHand.stream().filter(card -> isValidCard(card, topCard)).collect(Collectors.toList());
  }
}
