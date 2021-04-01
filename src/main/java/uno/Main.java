 package uno;

import uno.controllers.Menu;
import uno.frontend.CommandLineInteraction;
import uno.frontend.Interactions;

public class Main {
    public static void main(String[] args) {
        Interactions interaction = new CommandLineInteraction();
        Menu menu = new Menu(interaction);
        menu.openMenu();
    }
}
