package it.zwets.prs;

/**
 * Paper-rock-scissors player that plays a random move in each round.
 * 
 * The player picks its random gesture from the ones allowed by the
 * rules that it receives in its constructor.
 */
public class RandomGuessPlayer extends AbstractPlayer {
	
	// The gestures allowed by the rules of the game.
	private final String[] gestures;
	
	/**
	 * Create a random guessing player for a game with the given rules.
	 * @param rules the rules of this game
	 */
	public RandomGuessPlayer(Rules rules) {
		super(rules);
		gestures = rules.getGestures();
	}

	@Override
	public String nextMove() {
		return gestures[(int) (Math.random() * gestures.length)];
	}
}
