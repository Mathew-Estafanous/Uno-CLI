package uno;

import uno.cards.Card;
import uno.cards.CardColour;
import uno.cards.CardType;
import uno.characters.AIPlayer;
import uno.characters.Player;
import uno.characters.RealPlayer;
import uno.frontend.Interactions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Game Manager is the main class that connects each part of the code
 * together into one cohesive game. It controls the general flow of
 * the game and manages the entire state from start to finish.
 */
public class GameManager {

    //Used when interacting with the user for both input and output.
    private final Interactions interaction;
    private Deck deck = new Deck();

    /* GAME STATE VARIABLES:
    * The following instance variables will be widely used to keep track
    * of the current game state. */
    private List<Player> players = new ArrayList<>();
    private Card topCard;
    //The index of the current player.
    private int currentPlayer = -1;
    //Determines the direction of either reverse (-1) or forward (1).
    private int directionOfGame = 1;

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
        placeStartingTopCard();
        gameLoop();
    }

    private void placeStartingTopCard() {
        topCard = deck.dealCard();
        interaction.display("Starting card is : " + topCard.getColour().name().toLowerCase());
    }

    private void gameLoop() {
        Player player = moveToNextPlayer();
        Card chosenCard = null;

        boolean validCard = false;
        while (!validCard) {
            chosenCard = player.chooseCard();
            validCard = cardIsValid(chosenCard);
            if (!validCard)
                player.pickUpCard(chosenCard);
        }

        String cardName = chosenCard.getColour().name().toLowerCase().concat(" ");
        String cardType = chosenCard.getType().name().toLowerCase();
        interaction.display(player.getName() + " played " + cardName + cardType + ".");

        if (player.isOutOfCards()) {
            playerWon(player);
            return;
        }

        Rule cardRules = chosenCard.useCard();
        topCard = chosenCard;
        applyCardRulesToGameState(cardRules);
    }

    private void applyCardRulesToGameState(Rule cardRules) {
        directionOfGame *= (cardRules.flipDirection)? -1: 1;

        if (cardRules.skipNextPlayer)
            moveToNextPlayer();
        //TODO: Apply the 'cardsToDraw' variable to the game state.
    }

    private void playerWon(Player player) {
        //TODO: Make a proper congrats message and stuff.
        interaction.display("Congrats, " + player.getName() + " has won!");
    }

    private boolean cardIsValid(Card chosenCard) {
        CardType chosenType = chosenCard.getType();
        CardColour chosenColour = chosenCard.getColour();
        /* Return true of any of these requirements are met. If none of these
        * requirements are met, then it is invalid and return false. */
        return (chosenColour == topCard.getColour()) ||
                (chosenType == topCard.getType()) ||
                (chosenType == CardType.WILD) ||
                (chosenType == CardType.WILD_DRAWFOUR);
    }

    /**
     * Moves to the next player depending on the current direction
     * of the game. It also returns the next player
     */
    private Player moveToNextPlayer() {
        currentPlayer += directionOfGame;

        /* Series of checks that ensure that current player index maintains
        * the range of 0 to the total number of players - 1. That way a 'circular'
        * motion is maintained when moving between each player. */
        if (currentPlayer >= players.size())
            currentPlayer = 0;
        else if(currentPlayer <= -1)
            currentPlayer = players.size() - 1;

        return players.get(currentPlayer);
    }

    //Creates all the players that will be participating in the game.
    private void createAllPlayers() {
        interaction.display("---------- \n" +
                                "PLAYER SELECTION");

        //Prompt the user for the username that they would like to use.
        String playerName = interaction.chooseString("Choose a player name: ");
        players.add(new RealPlayer(playerName, interaction));

        //Prompt the user, asking how many opponents they want to verse.
        interaction.display("How many AI players do you want to verse?");
        int numOfAI;
        //Keep prompting the use for their choice until they choice a number within range.
        do {
            numOfAI = interaction.chooseInteger("(2-4): ");
        } while (numOfAI < 2 || numOfAI > 4);

        //Add the total number of AI players that the use wants to verse.
        List<String> AINames = setOfAINames(numOfAI);
        for (String name: AINames) {
            //TODO: Make randomly generated AI player names.
            players.add(new AIPlayer(name));
        }
    }

    private List<String> setOfAINames(int numOfAI) {
        List<String> names = new ArrayList<>();
        

        return names;
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
