package uno;

/**
 * State class is used to define how the game state will be altered
 * when a given card is used. When the Card object is used, it returns
 * as state which has all the information to allow the GameManager
 * to correctly alter the state of the game to account for the functionality
 * of the game.
 * 
 * This State class can only be generated using the State.Builder which then
 * generates the immutable state object.
 */
public class Rule {

    public final int cardsToDraw;
    public final int directionOfGame;
    public final boolean skipNextPlayer;

    //The constructor is private since it should only be created from the builder.
    private Rule(int cardsToNextPlayer, int directionOfGame, boolean skipNextPlayer) {
        this.cardsToDraw = cardsToNextPlayer;
        this.directionOfGame = directionOfGame;
        this.skipNextPlayer = skipNextPlayer;
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
        public Rule build() {
            return new Rule(nextPlayerDraws, directionOfGame,
                    skipNextPlayer);
        }
    }
}
