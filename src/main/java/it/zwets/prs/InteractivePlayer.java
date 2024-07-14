package it.zwets.prs;

import java.io.Console;

/**
 * The keyboard-interactive human player.
 * 
 * This implementation of {@link Player} implements <tt>nextMove()</tt>
 * by prompting the user for their move, and overrides <tt>roundPlayed()</tt>
 * to report the outcome of the round to the user.
 * 
 * <b>Design note</b>: I would not normally do console I/O inside a "domain
 * model" class (instead separate it out into a presentation controller), but
 * our tiny problem size warrants the shortcut.
 */
public class InteractivePlayer extends AbstractPlayer {

	private final String[] gestures;
	
	/**
	 * Construct the interactive player with the rules of the game.
	 * @param rules the game's gestures and their relative strengths
	 */
	public InteractivePlayer(Rules rules) {
		super(rules);
		this.gestures = rules.getGestures();
	}
	
	@Override
	public String nextMove() {

		// Assume that we have the system console
		Console console = System.console();

		// Set up the user prompt
		StringBuilder prompt = new StringBuilder();

		prompt.append("\nPick your move:");
		for (int i = 0; i < gestures.length; ++i) {
			prompt.append(' ').append(i+1).append("=").append(gestures[i]);
		}
		prompt.append(" q=Quit? ");

		// Loop until the user picks a valid option or we hit end of input
		while (true) {
			
			String input = console.readLine(prompt.toString());
			
			// End-of-file and q signal user wants to quit
			if (input == null || "q".equals(input)) {
				return null;
			}
			else {
				try {
					int choice = Integer.parseInt(input);
					if (1 <= choice && choice <= gestures.length) {
						return gestures[choice - 1];
					}
					else {
						console.printf("\nInvalid choice: %d\n", choice);
					}
				}
				catch (NumberFormatException nfe) {
					console.printf("\nInvalid input: %s\n", input);
				}
			}
		}
	}
	
	@Override
	public void roundPlayed(String myGesture, String theirGesture) {
	
		// Delegate updating the tallies to superclass
		tallyOutcome(myGesture, theirGesture);
	
		// Present the outcome of this round.  Note: 'myGesture' is relative to the
		// human player, so we use "I" here to refer to "us", their robotic opponent.
		int outcome = rules.decide(myGesture, theirGesture);
		String result = outcome == -1 ? "I win" : outcome == 0 ? "It's a draw" : outcome == 1 ? "You win" : "LPT1 is on fire!"; 
		System.console().printf("\nYou play %s, I play %s. %s.\n", myGesture, theirGesture, result);
	}
}
