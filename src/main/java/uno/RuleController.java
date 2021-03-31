package uno;

import uno.frontend.Interactions;

import java.io.*;
import java.net.URL;

public class RuleController {

    private final Interactions interactions;

    public RuleController(Interactions interactions) {
        this.interactions = interactions;
    }

    public void displayRules() {
        File ruleFile = retrieveRuleFile();
        if (ruleFile == null) return;

        try(BufferedReader reader = new BufferedReader(new FileReader(ruleFile))) {
            reader.lines().forEach(interactions::display);
        } catch (IOException e) {
            interactions.display("We were unable to read the file. Maybe try again!");
        }
    }

    private File retrieveRuleFile() {
        URL fileLocation = getClass().getClassLoader().getResource("rules.txt");
        if (fileLocation == null) {
            interactions.display("We were unable to find our rules file!\n" +
                    "Please try again or read through these rules (https://www.ultraboardgames.com/uno/game-rules.php)");
            return null;
        }
        return new File(fileLocation.getFile());
    }
}
