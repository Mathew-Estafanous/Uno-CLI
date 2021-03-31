package uno;

import uno.frontend.Interactions;

import java.io.*;
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
    
    /* Retrieves the rules from the resource folder and displays each
     * rule on a separate line. */
    public void displayRules() {
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
