package it.zwets.prs;

/**
 * <tt>Rules</tt> defines the set of gestures and which beats which.
 * 
 * This interface, albeit somewhat contrived, allows for implementations
 * with rules that differ from the classic paper-rock-scissors, such as
 * the with 5 different gestures.
 * 
 * See the description of {@link Player} for a discussion of allowing
 * for generalisation to variants with more than two players.
 */
public interface Rules {
	
	/**
	 * The list of gestures the players must pick from in each round.
	 * @return the gestures as a list of strings
	 */
	String[] getGestures();
	
	/**
	 * Decides the outcome of <tt>myGesture</tt> versus <tt>theirGesture</tt>.
	 * 
	 * If <tt>myGesture</tt> wins, returns <tt>1</tt>. If it loses, returns
	 * <tt>-1</tt>. In case of a draw, returns <tt>0</tt>.
	 * 
	 * @param myGesture the gesture played by the invoker
	 * @param theirGesture the gesture played by the opponent
	 * @return <tt>-1</tt> if invoker loses, <tt>0</tt> for a draw, <tt>1</tt> if invoker wins
	 * @throws {@link IllegalArgumentException} if either of the picks is an invalid item
	 * @throws {@link NullPointerException} if either of the picks is null
	 */
	int decide(String myGesture, String theirGesture);
}
