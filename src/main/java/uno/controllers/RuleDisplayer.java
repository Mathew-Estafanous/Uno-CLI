package uno.controllers;

import uno.cards.*;
import uno.frontend.Interactions;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * The RuleDisplayer class handles the rules file and displaying all 
 * the relevant rules to the player.
 */
public class RuleDisplayer {

    private final Interactions interactions;

    public RuleDisplayer(Interactions interactions) {
        this.interactions = interactions;
    }

    public void displayInfo() {
        displayRules();
        interactions.chooseString("Input any value to move on: ");
        interactions.clear();
        displayCards();
        interactions.chooseString("Input any value to move on: ");
        interactions.clear();
    }

    /* Retrieves the rules from the resource folder and displays each
     * rule on a separate line. */
    private void displayRules() {
        InputStream inStream = retrieveRuleFile();
        //Check if the inputsteam is null
        if (inStream == null) return;

        Scanner scan = new Scanner(inStream);
        //Continues to scan all the lines in the file until there is no next line
        while(scan.hasNextLine()) {
          interactions.display(scan.nextLine());
        }
        //Closes the scanner after all lines have been scanned
        scan.close();
    }

    /**
     * Display several example cards and their associated names, so that the user
     * knows what to expect when they are playing the game.
     */
    private void displayCards() {
        interactions.display("=== EXAMPLE CARDS ===");
        //Create a list of example cards to show.
        List<Card> exampleCards = List.of(
            new Card(CardColour.YELLOW, CardType.FIVE),
            new DrawTwoCard(CardColour.RED),
            new SkipCard(CardColour.BLUE),
            new SwitchCard(CardColour.GREEN),
            new WildCard(), new WildDrawFourCard()
        );

        //Iterate over the list and show the name and how it is expected to look.
        exampleCards.forEach(card -> {
            interactions.displayCard(card.toString().concat(": "), card);
        });
    }

    /* Gets the 'rules.txt' file from the resources folder and opens
     * the file in a stream. If no file is found then the user is told
     * and the method returns null. */
    private InputStream retrieveRuleFile() {
        //Use the class loader to get the resource as an inputstream.
        InputStream fileStream = getClass().getClassLoader().getResourceAsStream("rules.txt");    
        
        //Check if the inputstream is null.
        if (fileStream == null) {
            interactions.display("We were unable to find our rules file!\n" +
                    "Please try again or read through these rules (https://www.ultraboardgames.com/uno/game-rules.php)");
            return null;
        }
        return fileStream;
    }
}
