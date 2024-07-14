package it.zwets.prs;

/**
 * Represents a (generic) paper-rock-scissors game between two players.
 * 
 * In the {@link #play()} loop, each player is asked for their gesture
 * (which can be any string as far as this class is concerned), then
 * notified of the opponent's gesture.
 * 
 * The play loop continues until either player quits the game.
 */
public class Game {
	
	private final Player playerA;
	private final Player playerB;
	
	/**
	 * Set up the game between two players.
	 * 
	 * @param playerA
	 * @param playerB
	 */
	public Game(Player playerA, Player playerB) {
		this.playerA = playerA;
		this.playerB = playerB;
	}

	/**
	 * Run the game until either player returns <tt>null</tt> as
	 * their move, to signal they quit the game.
	 */
	public void play() {
		
		while (true) {
			
			// Ask both players for their next move
			String moveA = playerA.nextMove();
			String moveB = playerB.nextMove();
			if (moveA == null || moveB == null) {
				break;
			}
			
			// Notify both players of the moves made in this round
			playerA.roundPlayed(moveA, moveB);
			playerB.roundPlayed(moveA, moveB);
		}
	}
}
