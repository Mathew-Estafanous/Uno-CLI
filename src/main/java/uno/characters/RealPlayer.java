package uno.characters;

import uno.cards.Card;
import uno.frontend.Interactions;

public class RealPlayer extends Player {

    private final Interactions interaction;

    public RealPlayer(String name, Interactions interaction) {
        super(name);
        this.interaction = interaction;
    }

    @Override
    public Card chooseCard() {
      interaction.displayHand(cardHand);
      interaction.display("Select a card from your hand to play. ");
      int maxSize = cardHand.size()-1;
      int selectedCard = interaction.chooseInteger("Enter num from 0- "+ maxSize);
      
      //Get the user's choice for card.
      //Remove that card from the 'cardHand' list
      //Check if the card colour is CardColour.WILD
      //   if it is, then let user chose a colour
      //       set the wild card's colour to that chosen colour
      //Return the card
        return null;
    }
}
