package uno;

import uno.cards.Card;
import uno.characters.AIPlayer;
import uno.characters.Player;
import uno.characters.RealPlayer;
import uno.frontend.Interactions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static uno.cards.CardColour.WILD;

/**
 * Game Manager is the controller that connects each part of the code together
 * into one cohesive game. It controls the general flow of the game and manages
 * the entire state from start to finish.
 */
public class GameManager {

  // Used when interacting with the user for both input and output.
  private final Interactions interaction;
  private Deck deck = new Deck();

  /*
   * GAME STATE VARIABLES: The following instance variables will be used to keep
   * track of the current game state.
   */
  private List<Player> players = new ArrayList<>();
  private Card topCard;
  // The index of the current player.
  private int currentPlayer = -1;
  // Determines the direction of either reverse (-1) or forward (1).
  private int directionOfGame = 1;
  // How many cards the next player should pickup.
  private int nextPlayerDraws = 0;

  // Generates a list of possible names
  private List<String> possibleNames = Arrays.asList("Glenn", "Sam", "Emily", "Colin", "Adriana");

  // Constructor to the game manager class
  public GameManager(Interactions interaction) {
    this.interaction = interaction;
  }

  /* A simple starting point to begin playing the game. Call this when ready 
   * to start UNO. */
  public void play() {
    /* prints out a message to start the game, creates players, and 
     * assigns them all cards */
    interaction.display("==== WELCOME TO UNO ====");
    setupAllPlayers();
    assignPlayerStartingHands();

    //Does not allow the starting top card to be a wild card.
    do {
      topCard = deck.dealCard();
    } while (topCard.getColour() == WILD);

    interaction.display("STARTING UNO GAME");
    gameLoop();
  }

  // Creates all the players that will be participating in the game.
  private void setupAllPlayers() {
    interaction.display("PLAYER SELECTION");

    // Prompt the user for the username that they would like to use.
    String playerName = interaction.chooseString("Choose a player name: ");
    players.add(new RealPlayer(playerName, interaction));

    // Prompt the user, asking how many opponents they want to verse.
    interaction.display("How many AI players do you want to verse?");
    int numOfAI;
    // Keep prompting for their choice until they choose a number within range.
    do {
      numOfAI = interaction.chooseInteger("(2-4): ");
    } while (numOfAI < 2 || numOfAI > 4);

    // Add the total number of AI players that the use wants to verse.
    List<String> AINames = setOfAINames(numOfAI);
    for (String name : AINames) {
      players.add(new AIPlayer(name));
    }
  }

  // Generates a list of AI names for the AI players that will be in the game.
  private List<String> setOfAINames(int numOfAI) {
    Random rand = new Random();
    // creates a list for the names
    List<String> names = new ArrayList<>();
    while (names.size() < numOfAI) {
      // randomly selects the name of a player
      int index = rand.nextInt(possibleNames.size());
      String word = possibleNames.get(index);

      // If the name is already added to the list of names, continue to loop.
      if (names.contains(word))
        continue;
      // add the name to the list
      names.add(word);
    }
    return names;
  }

  // Give each player in the game, 7 cards as their starting hand.
  private void assignPlayerStartingHands() {
    // Iterate over each player in the list.
    players.forEach(player -> {
      List<Card> startingHand = new ArrayList<>();
      // Iterate seven times while dealing a card to the list each time.
      for (int i = 0; i < 7; i++) {
        startingHand.add(deck.dealCard());
      }
      // Make player pickup the 7 card starting hand.
      player.pickUpCards(startingHand);
    });
  }

  /**
   * The series of interactions each player goes through during their turn,
   * combining together to make a seemless game experience.
   */
  private void gameLoop() {
    // Delay & reset terminal before loop.
    delayAndResetScreen();
    interaction.display("-------------");
    // Get the next player who is going.
    Player player = moveToNextPlayer();

    // Make player pick up card, depending `nextPlayerDraws` total.
    for (int i = 0; i < nextPlayerDraws; i++) {
      player.pickUpCard(deck.dealCard());
    }

    interaction.displayCard("Top Card: ", topCard);
    // Prompt the player to select a valid card to play.
    Card chosenCard = player.chooseCard(topCard);
    // Check if chosen card returned is 'null'.
    if (chosenCard == null) {
      // It was, so the player picks up a card and moves to next player.
      player.pickUpCard(deck.dealCard());
      interaction.display(player.getName() + " picked up a card!");
      // Continue the game loop which moves on to the next player.
      gameLoop();
      return;
    }

    interaction.displayCard(player.getName() + " played ", chosenCard);

    // Check if the player who dropped the card, is out of cards.
    if (player.isOutOfCards()) {
      // The player has won, so display that they won.
      interaction.playerWon(player);
      //Resets the game in preparation for the possibility of another game.
      resetGame();
      return;
    }

    /* To use the chosen card, we call 'userCard' which will return an object that
     * defines how the card can be used. */
    Attribute cardAttribute = chosenCard.useCard();
    topCard = chosenCard;
    // Apply the defined rules to the current state of the game.
    applyCardRulesToGameState(cardAttribute);

    // Move on to the next player by calling back to the gameloop.
    gameLoop();
  }

  // Delays the thread for a period of time, then clears the screen.

  private void delayAndResetScreen() {
    // delays the screen for three seconds
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // Clears the screen after the three seconds
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  /*
   * Applies the card rules that was passed to the state of the game. Displays a
   * message describing the state of the game.
   */

  private void applyCardRulesToGameState(Attribute cardAttribute) {
        /*changes the direction of the game if a flip direction card is played. Displays that the direction has been changed.*/
        directionOfGame *= (cardAttribute.flipDirection)? -1: 1;
        if(cardAttribute.flipDirection) {
          interaction.display("Direction of the game has been flipped!");
        }
        //skips the next player if a skip player card is played. Displays a message, mentionning who's turn was skipped
        if (cardAttribute.skipNextPlayer) {
            Player skippedPlayer = moveToNextPlayer();
            interaction.display(skippedPlayer.getName() + "'s turn is skipped");
        }

        //determines how many cards should be drawn based on the state of the game. Displays
        nextPlayerDraws = cardAttribute.cardsToDraw;
        if(nextPlayerDraws > 0) {
            String prompt = String.format("Next player is picking-up %s cards!", nextPlayerDraws);
            interaction.display(prompt);
        }
    }
  /*
   * Moves to the next player depending on the current direction of the game. It
   * then returns that next player.
   */

  private Player moveToNextPlayer() {
    currentPlayer += directionOfGame;

    /* Series of checks ensuring that current player index stays within the
     * range of the list. */
    if (currentPlayer >= players.size())
      currentPlayer = 0;
    else if (currentPlayer <= -1)
      currentPlayer = players.size() - 1;

    return players.get(currentPlayer);
  }

  //Resets the game state back to the starting state.
  private void resetGame() {
    players.clear();
    deck = new Deck();
    //Set game state variables back to original values.
    currentPlayer = -1;
    nextPlayerDraws = 0;
    directionOfGame = 1;
  }
}
