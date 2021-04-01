package uno.players;

import uno.cards.Card;
import uno.frontend.Interactions;

import static uno.cards.CardColour.WILD;

/**
 * The RealPlayer class is an extension of the Player class.
 * It allows the human player to select a card from their current hand.
 * If the human player chooses a WILD card, the player is given the
 * choice to choose what colour that card will be.
 * */
public class RealPlayer extends Player {

    private final Interactions interaction;

    public RealPlayer(String name, Interactions interaction) {
        super(name);
        this.interaction = interaction;
    }

    /* This method will prompt the user asking for the card they would like
     * to play. It will then validate the user choice, also give the option to
     * chose the colour if the card they chose is a Wild card. 'null' is returned
     * if the user would like to pickup a card. */
    @Override
    public Card chooseCard(Card topCard) {
        int selectedCard;
        boolean chosenACard = false;
        do {
            //Display player's current hand
            interaction.displayHand(cardHand);

            //The player chooses which card they will select from their array of cards
            interaction.display("Select a card from your hand to play. ");
            int maxSize = cardHand.size() - 1;
            String question = String.format("Enter num from 0-%s or -1 (pick up card): ", maxSize);
            selectedCard = interaction.chooseInteger(question);

            /* Checks that integer corresponds with an element. If not, then
            prompt the user that it was not valid. */
            if (selectedCard < -1 || selectedCard > maxSize) {
                interaction.display("This is not a valid choice.");
                continue;
            }

            //Check if the user chose -1. If so, then they want to pick-up a card.
            if (selectedCard == -1) {
                return null;
            }

            Card chosenCard = cardHand.get(selectedCard);
            //Check that the chosen card is valid. If not then continue looping.
            if (!isValidCard(chosenCard, topCard))
                continue;

            chosenACard = true;
        } while (!chosenACard);

        //The card selected by the player is removed the array
        Card card = cardHand.remove(selectedCard);

        //If the player selects a WILD card, they must choose what colour the card will be
        if (card.getColour() == WILD) {
            changeToRegularColour(card);
        }
        return card;
    }

    /* Prompts the user for the colour they would like and changes the colour of
     * the passed in wild card */
    private void changeToRegularColour(Card wilCard) {
        int colourSelect;
        do {
            interaction.display("Red: 0 || Blue: 1 || Yellow: 2 || Green 3");
            //The player must select what colour their WILD card will be
            colourSelect = interaction.chooseInteger("Select which colour your wild card will be: ");
            if (colourSelect < 0 || colourSelect > 3) {
                interaction.display("This is not a valid choice.");
            }
        } while (colourSelect < 0 || colourSelect > 3); //Ensures the user must enter a valid integer in order to choose the colour
        alterWildCardToColour(wilCard, colourSelect);
    }
}
