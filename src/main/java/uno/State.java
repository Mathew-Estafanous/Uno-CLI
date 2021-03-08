package uno;

import uno.cards.CardColour;
import uno.cards.CardType;

public class State {

    private final int cardsToDraw;
    private final int directionOfGame;
    private final boolean skipNextPlayer;
    private final CardColour topColour;
    private final CardType topType;

    private State(int cardsToNextPlayer, int directionOfGame, boolean skipNextPlayer,
                 CardColour topCardColour, CardType topCardType) {
        this.cardsToDraw = cardsToNextPlayer;
        this.directionOfGame = directionOfGame;
        this.skipNextPlayer = skipNextPlayer;
        this.topColour = topCardColour;
        this.topType = topCardType;
    }

    public int getCardsToDraw() {
        return cardsToDraw;
    }

    public int getDirectionOfGame() {
        return directionOfGame;
    }

    public boolean isSkipNextPlayer() {
        return skipNextPlayer;
    }

    public CardColour getTopColour() {
        return topColour;
    }

    public CardType getTopType() {
        return topType;
    }


    /**
     * State Builder is used to create a well defined State object. It uses
     * the builder pattern where, optional settings are given but not enforced.
     * Once complete, the build method will be called, which will "build" and
     * return a state object with the chosen options.
     */
    public static class Builder {

        private int nextPlayerDraws = 0;
        private int directionOfGame = 1;
        private boolean skipNextPlayer = false;
        private final CardColour topColour;
        private final CardType topType;

        /**
         * This constructor enforces that there are two required fields when
         * creating a state object. Other variables are optional.
         * @param colour
         * @param type
         */
        public Builder(CardColour colour, CardType type) {
            this.topColour = colour;
            this.topType = type;
        }

        /**
         * The skip next player will be set to true when this method is
         * called.
         */
        public Builder shouldSkipPlayer() {
            this.skipNextPlayer = true;
            return this;
        }

        /**
         * Set the total number of cards that the next player should
         * draw during their round.
         * @param total
         */
        public Builder nextPlayerDraws(int total) {
            this.nextPlayerDraws = total;
            return this;
        }

        /**
         * When this method is used in the builder, the direction of the
         * game will be flipped to -1 (Reverse).
         */
        public Builder flipDirectionOfGame() {
            this.directionOfGame = -1;
            return this;
        }

        /**
         * Generates a state object that contains all the options that
         * were set in the builder.
         * @return State - the generated object containing the chosen
         * options.
         */
        public State build() {
            return new State(nextPlayerDraws, directionOfGame,
                    skipNextPlayer, topColour, topType);
        }
    }
}
