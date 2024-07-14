package it.zwets.prs;

/**
 * Interface to be implemented by players of the paper-rock-scissors game.
 * 
 * In each round, the game controller first invokes {@link #nextMove()} on
 * each player, in response to which the player must return their pick.
 * 
 * The controller then invokes {@link #roundPlayed(String, String)} to
 * notify each player of the gestures played by them and their opponent.
 * 
 * <b>Design note:</b> for ultimate generality, we could have given
 *   <tt>roundPlayed()</tt> the signature 
 *   <tt>roundPlayed(String... otherGestures)</tt> instead
 * and support game variants with arbitrary numbers of players, but that
 * starts to reek of <a href="https://xkcd.com/974/">The General Problem</a>.
 */
public interface Player {
	
	/**
	 * Return the gesture the player picks for this round or null to quit.
	 * 
	 * @return one of the allowed gestures, or <tt>null</tt> if player quits.
	 */
	String nextMove();
	
	/**
	 * Receive notification of the gestures played in this round.
	 * 
	 * Players can use this to keep score and/or track what moves their
	 * opponent makes, in order to try and predict their future moves.
	 * 
	 * @param myGesture the gesture played by self, i.e. the latest {@link #nextMove()}
	 * @param theirGesture the gesture played by the opponent
	 */
	void roundPlayed(String myGesture, String theirGesture);
}
