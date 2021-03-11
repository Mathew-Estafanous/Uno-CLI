package uno.cards;

import java.util.List;

/**
 * CardColour defines the variety of different card colours
 * within the game and also the string literal that will
 * be used in the command line when displaying colours.
 */
public enum CardColour {
    GREEN("\u001B[32m"),
    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    WILD("\u001B[35m");

    //The string that contains string literal to chance text colour.
    private final String colour;
    public String getColour() {
        return colour;
    }

    CardColour(String colour) {
        this.colour = colour;
    }

    public static CardColour[] getAllRegularColours() {
        return new CardColour[] { GREEN, RED, YELLOW, BLUE };
    }
}
