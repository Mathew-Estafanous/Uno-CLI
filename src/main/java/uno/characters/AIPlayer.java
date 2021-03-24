package uno.characters;

import uno.cards.Card;

import static uno.cards.CardColour.*;

public class AIPlayer extends Player {

    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public Card chooseCard() {
        int choice = (Math.random() * cardHand.size()) + 1;
        
        Card card = cardHand.get(choice);
        if(card.getColour() == WILD) {
            choice = Math.random() * 4;
            if(choice == 1) {
              card.setColour(GREEN);
            } else if(choice == 2) {
              card.setColour(RED);
            } else if(choice == 3) {
              card.setColour(YELLOW);
            } else {
              card.setColour(BLUE);
            }
        }
        return card;
    }
}
