package uno.frontend;

import uno.cards.Card;
import uno.players.Player;

import java.util.List;

/**
 * The Interactions interface is used as an interface that guarantees
 * that any user interaction will include all of the following methods.
 *
 * By having an interface for input/output, we can have a clear separation
 * between the game logic and the front-end. We can also have flexibility
 * with the implementation. We can easily switch to a different front-end
 * format like JSwing, etc and still be confident that the interactions
 * should be similar.
 */
public interface Interactions {

    /**
     * Display Hand will take in a list of cards and display it to the user
     * depending on the given implementation.
     * @param card
     */
    void displayHand(List<Card> card);

    /**
     * Simply display the text or statement to the user.
     * @param text
     */
    void display(String text);

    void displayCard(String text, Card card);

    /**
     * Called with the passed in player who won the game.
     * @param player
     */
    void playerWon(Player player);

    /**
     * Gets integer input by prompting the question and validating the int.
     * @param prompt - The question or request to the user.
     * @return int - the user's choice.
     */
    int chooseInteger(String prompt);

    /**
     * Gets String input by prompting the question.
     * @param prompt - The question or request to the user.
     * @return String - The user's choice.
     */
    String chooseString(String prompt);

    /**
     * Will reset the front-end to a default state.
     */
    void clear();
}
