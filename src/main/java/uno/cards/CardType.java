package uno.cards;

/**
 * Used to associate a card with its type. Each type has an
 * associated display name that is used when displaying the
 * card on the command line.
 */
public enum CardType {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    SWITCH("↺"),
    SKIP("⮿"),
    DRAWTWO("+2"),
    WILD_DRAWFOUR("+4"),
    WILD("W");

    //The string variable that contains the associated display value.
    private final String displayName;
    public String getDisplayName() {
        return displayName;
    }
    CardType(String displayName) {
        this.displayName = displayName;
    }
}
