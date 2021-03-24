package uno;

import uno.cards.Card;
import uno.characters.AIPlayer;
import uno.characters.Player;
import uno.characters.RealPlayer;
import uno.frontend.Interactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Game Manager is the main class that connects each part of the code
 * together into one cohesive game. It controls the general flow of
 * the game and manages the entire state from start to finish.
 */
public class GameManager {

    //Used when interacting with the user for both input and output.
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
        System.out.println("HELLO");
    }

    //Creates all the players that will be participating in the game.
    private void createAllPlayers() {
        interaction.display("---------- \n" +
                                "PLAYER SELECTION");

        //Prompt the user for the username that they would like to use.
        String playerName = interaction.chooseString("Choose a player name: ");
        //Add the real player to the list of players.
        players.add(new RealPlayer(playerName));

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

    //Give each player in the game, 7 cards as their starting hand.
    private void assignPlayerStartingHands() {
        //Iterate over each player in the list.
        players.forEach(player -> {
            List<Card> startingHand = new ArrayList<>();
            //Iterate seven times while dealing a card to the hand.
            for(int i = 0; i < 7; i++) {
                startingHand.add(deck.dealCard());
            }
            //Make player pickup the 7 card starting hand.
            player.pickUpCards(startingHand);
        });
    }
}
