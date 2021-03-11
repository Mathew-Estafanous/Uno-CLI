package uno;

import uno.cards.Card;
import uno.cards.CardColour;
import uno.cards.CardType;

import java.util.List;
import java.util.stream.Collectors;

public class Deck {

    private List<Card> deckOfCards;

    public Deck() {
        createNewDeckOfCards();
    }

    private void createNewDeckOfCards() {
        deckOfCards.addAll(generateAllNumericCards());
    }

    private List<Card> generateAllNumericCards() {
        return CardType.getAllNumericTypes().stream()
            .flatMap(type -> {
                return CardColour.getAllRegularColours().stream()
                    .map(colour -> new Card(colour, type))
                    .collect(Collectors.toList())
                    .stream();
            })
            .collect(Collectors.toList());
    }
}
