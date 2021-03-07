package uno;

public class Card {

    private final CardColour colour;
    private final CardType type;

    public Card(CardColour colour, CardType type) {
        this.colour = colour;
        this.type = type;
    }

    public CardColour getColour() {
        return colour;
    }

    public CardType getType() {
        return type;
    }
}
