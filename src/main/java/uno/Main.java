package uno;

import uno.frontend.CommandLineInteraction;
import uno.frontend.Interactions;

public class Main {
    public static void main(String[] args) {
        Interactions interaction = new CommandLineInteraction();
        RuleController controller = new RuleController(interaction);

        controller.displayRules();

        GameManager game = new GameManager(interaction);
        game.play();
    }
}
