package uno.characters;

import uno.cards.Card;
import uno.frontend.Interactions;
import static uno.cards.CardColour.*;

/*The RealPlayer class is an extension of the Player class. 
 * It allows the human player to select a card from their current 
 * hand. If the human player chooses a WILD card, the player is given the
 * choice to choose what colour the card will be. */
public class RealPlayer extends Player {

  private final Interactions interaction;

  public RealPlayer(String name, Interactions interaction) {
    super(name);
    this.interaction = interaction;
  }

  @Override
  public Card chooseCard() {
    int selectedCard;
    int maxSize;
    do {
      //Display player's current hand
      interaction.displayHand(cardHand);
      
      //The player chooses which card they will select from their array of cards
      interaction.display("Select a card from your hand to play. ");
      maxSize = cardHand.size() - 1;
      String question = String.format("Enter num from 0-%s: ", maxSize);
      selectedCard = interaction.chooseInteger(question);
      
      /* Cheks that integer corresponds with an element. If not,  then
      prompt the user that it was not valid. */ 
      if (selectedCard < 0 || selectedCard > maxSize) {
        interaction.display("This is not a valid choice.");
      }
    } while (selectedCard < 0 || selectedCard > maxSize); //The player must continure to select a card until a valid option is chosen

    //The card selected by the player is removed the array
    Card card = cardHand.remove(selectedCard);
    
    
    //If the player selects a WILD card, they must choose what colour the card will be
    if (card.getColour() == WILD) {
      interaction.display("Select which colour your wild card will be: ");
      //The player must select what colour their WILD card will be
      int colourSelect = interaction.chooseInteger("Red: 1\nBlue: 2\nYellow: 3\n Green: 4");
      if (colourSelect == 1) {
        card.setColour(RED);
      } else if (colourSelect == 2) {
        card.setColour(BLUE);
      } else if (colourSelect == 3) {
        card.setColour(YELLOW);
      } else if (colourSelect == 4) {
        card.setColour(GREEN);
      }
    }
    return card; //The cards returned

  }
}
