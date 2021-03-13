package uno.characters;

import uno.cards.Card;

public class RealPlayer extends Player {

    public RealPlayer(String name) {
        super(name);
    }

    @Override
    public Card chooseCard() {
        return null;
    }
}
