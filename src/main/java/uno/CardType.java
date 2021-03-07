package uno;

public enum CardType {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    SWITCH("↺"),
    SKIP("⮿"),
    PLUSTWO("+2"),
    WILD_PLUSFOUR("+4"),
    WILD("W");

    private final String displayName;
    public String getDisplayName() {
        return displayName;
    }
    CardType(String displayName) {
        this.displayName = displayName;
    }
}
