package uno.frontend;

import uno.cards.Card;
import uno.characters.Player;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This Command Line interactions class is the direct implementation
 * of the different interactions that are available. Interactions
 * here will occur using the command line and user input through that.
 */
public class CommandLineInteraction implements Interactions {

    //Scanner object that will be used to get user input.
    private final Scanner input = new Scanner(System.in);

    //Formatting variables that will be used to make text look nicer.
    private static final String RESET = "\u001b[0m";
    private static final String BOLD = "\u001b[1m";
    private static final String REVERSE = "\u001b[7m";

    /**
     * This overridden method will used the passed in Cards and display
     * each of them by using their associated display name and their
     * card colour.
     */
    @Override
    public void displayHand(List<Card> cards) {
        //Set all colours to alter background and set text bold.
        System.out.print(REVERSE + BOLD);
        //Iterate over each card in the list of cards.
        cards.forEach(card -> {
            //Get the associated colour and display name
            String colour = card.getColour().colour();
            String displayName = card.getType().displayName();
            //Display the card with the colour and display name.
            System.out.printf("%s %-1s ", colour, displayName);
        });
        //Reset all the formatting back to regular text.
        System.out.println(RESET);

        /* We want to display each card's index below each card. We do this
        * by iterating over each index and displaying the number. */
        for(int i = 0; i < cards.size(); i++) {
            //Get the length of the display name string, for the card.
            int length = cards.get(i).getType()
                    .displayName().length();
            //Display that card's index and account for length spacing.
            System.out.printf(" %s%s", i, " ".repeat(length));
        }
        //Move to the next line for future output.
        System.out.println();
    }

    /**
     * Very simply, uses the passed in String argument and outputs it to
     * the user using the command line.
     */
    @Override
    public void display(String text) {
        //Display text to the user.
        System.out.println(text);
    }

    @Override
    public void displayCard(String text, Card card) {
        System.out.print(text);
        System.out.print(REVERSE + BOLD);
        String colour = card.getColour().colour();
        String displayName = card.getType().displayName();
        System.out.printf("%s %s ", colour, displayName);
        System.out.println(RESET);
    }

    @Override
    public void playerWon(Player player) {
        System.out.print(BOLD);
        System.out.println("CONGRATS, " + player.getName().toUpperCase() + " HAS WON!");

        String fireworks = "      .''.      .        *''*    :_\\/_:     .\n" +
                "      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\n" +
                "  .''.: /\\ :    /)\\   ':'* /\\ *  : '..'.  -=:o:=-\n" +
                " :_\\/_:'.:::.  | ' *''*    * '.\\'/.'_\\(/_ '.':'.'\n" +
                " : /\\ : :::::  =  *_\\/_*     -= o =- /)\\     '  *\n" +
                "  '..'  ':::' === * /\\ *     .'/.\\'.  ' ._____\n" +
                "      *        |   *..*         :       |.   |' .---\"|\n" +
                "        *      |     _           .--'|  ||   | _|    |\n" +
                "        *      |  .-'|       __  |   |  |    ||      |\n" +
                "     .-----.   |  |' |  ||  |  | |   |  |    ||      |\n" +
                " ___'       ' /\"\\ |  '-.\"\".    '-'   '-.'    '`      |____\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "   ~~~~~~              ~-~-~-~-~-~-~-~-~-~   /|\n" +
                "                 ~-~-~-~-~-~-~-~  /|~       /_|\\\n" +
                "        _-H-__  -~-~-~-~-~-~     /_|\\    -~======-~\n" +
                "~-\\XXXXXXXXXX/~     ~-~-~-~     /__|_\\ ~-~-~-~\n" +
                "~-~-~-~-~-~    ~-~~-~-~-~-~    ========  ~-~-~-~\n" +
                "      ~-~~-~-~-~-~-~-~-~-~-~-~-~ ~-~~-~-~-~-~\n" +
                "                        ~-~~-~-~-~-~";
        System.out.println(fireworks);
    }

    /**
     * Prompts the request to the user and proceeds to ask them for an integer
     * input. Ensures that the input is a valid integer input. If not, the user
     * is then prompted again.
     */
    @Override
    public int chooseInteger(String prompt) {
        Integer userInput = null;
        //Keep iterating until the Integer input is not null.
        while(userInput == null) {
            try {
                System.out.print(prompt);
                //Get the user input using the scanner nextInt()
                userInput = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Only numeric (whole) values are permitted. (i.e 2 or 3)");
                //Need to move to next line or else scanner will keep reading previous print statement.
                input.nextLine();
            }
        }
        input.nextLine();
        return userInput;
    }

    /**
     * Similar to chooseInteger, however the user is asked to input a String input.
     * Since it is a String, then almost any input will work.
     */
    @Override
    public String chooseString(String prompt) {
        //Display the request prompt.
        System.out.print(prompt);
        //Return the user string input.
        return input.nextLine();
    }
}
