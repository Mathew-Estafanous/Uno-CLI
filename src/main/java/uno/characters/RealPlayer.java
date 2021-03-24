package uno.characters;

import uno.cards.Card;
import uno.frontend.Interactions;

public class RealPlayer extends Player {

    private final Interactions interaction;

    public RealPlayer(String name, Interactions interaction) {
        super(name);
        this.interaction = interaction;
    }

    @Override
    public Card chooseCard() {
        return null;
    }
}
