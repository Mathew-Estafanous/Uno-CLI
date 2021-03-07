package uno;

public enum CardColour {
    GREEN("\u001B[32m"),
    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    WILD("\u001B[35m");

    private final String colour;
    public String getColour() {
        return colour;
    }

    CardColour(String colour) {
        this.colour = colour;
    }
}
