package uno.characters;

import uno.cards.Card;

import static uno.cards.CardColour.*;

import java.util.Random;

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
    public Card chooseCard() {
      //randomly chooses a card.
      int choice = rand.nextInt(cardHand.size());
      //removes selected card from the hand
      Card card = cardHand.remove(choice);
      if(card.getColour() == WILD) {
        //randomly setting the colour after a wild card is played
        choice = rand.nextInt(4);
        if(choice == 0) {
          card.setColour(GREEN);
        } else if(choice == 1) {
          card.setColour(RED);
        } else if(choice == 2) {
          card.setColour(YELLOW);
        } else {
          card.setColour(BLUE);
        }
      }
      return card;
    }
}
