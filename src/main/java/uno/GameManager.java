package uno;

import uno.cards.Card;
import uno.characters.AIPlayer;
import uno.characters.Player;
import uno.characters.RealPlayer;
import uno.frontend.Interactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {

    private final Interactions interaction;
    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();

    public GameManager(Interactions interaction) {
        this.interaction = interaction;
    }

    /**
     * A simple starting point to begin playing the game. Call
     * this when ready to start UNO.
     */
    public void play() {
        interaction.display("WELCOME TO UNO");
        createAllPlayers();
        assignPlayerStartingHands();
    }

    /**
     * Creates all the players that will be participating in the game.
     */
    private void createAllPlayers() {
        interaction.display("---------- \n" +
                                "PLAYER SELECTION");

        //Prompt the user for the username that they would like to use.
        String playerName = interaction.chooseString("Choose a player name: ");
        //Add the real player to the list of players.
        players.add(new RealPlayer(playerName, interaction));

        //Prompt the user, asking how many opponents they want to verse.
        interaction.display("How many AI players do you want to verse?");
        int numOfAI;
        //Keep prompting the use for their choice until they choice a number within range.
        do {
            numOfAI = interaction.chooseInteger("(2-4): ");
        } while (numOfAI < 2 || numOfAI > 4);

        //Add the total number of AI players that the use wants to verse.
        for (int i = 1; i <= numOfAI; i++) {
            players.add(new AIPlayer("AI " + i));
        }
    }

    private void assignPlayerStartingHands() {
        players.forEach(player -> {
            List<Card> startingHand = Collections.nCopies(7, deck.dealCard());
            player.pickUpCards(startingHand);
        });
    }
}
