package uno;

/**
 * Attribute class is used to define how the game rules will the game when the
 * card is used. When the Card object is used, it returns rules which have 
 * all the information to allow the GameManager to correctly alter the state 
 * of the game by using the defined rules by the card.
 * 
 * This Attribute class can only be generated using the Attribute.Builder which then
 * generates the immutable Rule object.
 */
public class Attribute {

    public final int cardsToDraw;
    public final boolean flipDirection;
    public final boolean skipNextPlayer;

    //The constructor is private since it should only be created from the builder.
    private Attribute(int cardsToNextPlayer, boolean flipDirection, boolean skipNextPlayer) {
        this.cardsToDraw = cardsToNextPlayer;
        this.flipDirection = flipDirection;
        this.skipNextPlayer = skipNextPlayer;
    }

    /**
     * Rule Builder is used to create a well defined Rule object. It uses
     * the builder pattern, where optional settings are given but not enforced.
     * Once complete, the build method will be called, which will "build" and
     * return a Attribute object with the chosen options.
     */
    public static class Builder {

        private int nextPlayerDraws = 0;
        private boolean flipDirection = false;
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
         * draw at the beginning of their turn.
         * @param total
         */
        public Builder nextPlayerDraws(int total) {
            this.nextPlayerDraws = total;
            return this;
        }

        /**
         * When this method is used in the builder, the direction of the
         * game will be flipped to -1 (Reverse).
         * The flip direction of game will be set to true when this method * is called.
         */
        public Builder flipDirectionOfGame() {
            this.flipDirection = true;
            return this;
        }

        /**
         * Generates a rule object that contains all the options that
         * were set in the builder.
         * @return Attribute - the generated object containing the chosen
         * options.
         */
        public Attribute build() {
            return new Attribute(nextPlayerDraws, flipDirection,
                    skipNextPlayer);
        }
    }
}
