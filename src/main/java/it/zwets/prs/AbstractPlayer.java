package it.zwets.prs;

/**
 * Convenience abstract base class for {@link Player} implementations.
 * 
 * This class holds a reference to the game rules, and implements the 
 * {@link Player#roundPlayed(String, String)} interface method to keep
 * track of the number of wins, losses, and draws.
 * 
 * Concrete subclasses must still implement {@link Player#nextMove()}.
 * 
 * Subclasses may further override <tt>roundPlayed()</tt> for additional
 * bookkeeping, for instance to track opponent moves to detect patterns
 * and outsmart them.
 */
public abstract class AbstractPlayer implements Player {
	
	protected final Rules rules; // protected so subclasses can use rules
	
	private int wins;
	private int draws;
	private int losses;
	
	/**
	 * Create player for a game with the given rules.
	 * @param rules the rules that apply to this game
	 */
	public AbstractPlayer(Rules rules) {
		this.rules = rules;
	}
	
	/**
	 * Base implementation of interface method; keeps track of score.
	 * 
	 * If you override this method in a concrete subclass, remember
	 * to call {@link #tallyOutcome(String, String)}
	 */
	@Override
	public void roundPlayed(String myGesture, String theirGesture) {
		tallyOutcome(myGesture, theirGesture);
	}

	/**
	 * Tallies the outcome of the round as a win, draw, or loss.
	 * 
	 * This method is invoked by {@link #roundPlayed(String, String)},
	 * which gets notified by the game controller after each round.
	 * 
	 * @param myGesture what self played in the round
	 * @param theirGesture what the opponent played in in the round
	 */
	public void tallyOutcome(String myGesture, String theirGesture) {
		switch (rules.decide(myGesture, theirGesture)) {
		case -1:
			++losses;
			break;
		case 0:
			++draws;
			break;
		case 1:
			++wins;
			break;
		default: // defensive programming
			throw new IllegalStateException("Method %s.decide() violates its contract"
					.formatted(rules.getClass().getName()));
		}		
	}
	
	/**
	 * Reports the number of rounds played.
	 * @return the number of rounds played
	 */
	public int getRoundsPlayed() {
		return wins + draws + losses;
	}

	/**
	 * The number of rounds won by the player.
	 * @return the number of rounds won
	 */
	public int getWins() {
		return wins;
	}
	
	/**
	 * The number of rounds where neither player won.
	 * @return the number of tied rounds
	 */
	public int getDraws() {
		return draws;
	}
	
	/**
	 * The number of rounds lost by the player.
	 * @return the number of rounds lost
	 */
	public int getLosses() {
		return losses;
	}	
}
