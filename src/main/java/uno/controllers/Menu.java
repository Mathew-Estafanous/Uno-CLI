package uno.controllers;

import uno.frontend.Interactions;

public class Menu {

    private final Interactions interaction;

    private final RuleDisplayer ruleDisplay;
    private final GameManager game;

    public Menu(Interactions interaction) {
        this.interaction = interaction;
        ruleDisplay = new RuleDisplayer(interaction);
        game = new GameManager(interaction);
    }

    public void openMenu() {
        int choice;
        do {
            interaction.display("==== GAME MENU ====");
            interaction.display("1) Read the Uno Rules \n" +
                    "2) Play a game of UNO \n" +
                    "3) Exit Application");
            choice = interaction.chooseInteger("Choose Option: ");
            switch (choice) {
                case 1: ruleDisplay.displayRules(); break;
                case 2: game.play(); break;
            }
        } while (choice != 3);
        interaction.display("Thanks for playing! Good Bye!");
    }
}
