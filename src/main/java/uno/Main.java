 package uno;

import uno.frontend.CommandLineInteraction;
import uno.frontend.Interactions;

public class Main {
    public static void main(String[] args) {
        Interactions interaction = new CommandLineInteraction();
        RuleDisplayer ruleDisplay = new RuleDisplayer(interaction);
        GameManager game = new GameManager(interaction);

        ruleDisplay.displayRules();
        game.play();
    }
}
