package it.zwets.prs;

/**
 * Implements the rules of the "classic" paper-rock-scissors game.
 */
public class ClassicRules implements Rules {

	public static final String PAPER = "Paper";
	public static final String ROCK = "Rock";
	public static final String SCISSORS = "Scissors";

	@Override
	public String[] getGestures() {
		return new String[] { PAPER, ROCK, SCISSORS };
	}

	@Override
	public int decide(String myGesture, String theirGesture) {
		switch (myGesture) {
		case PAPER:
			switch (theirGesture) {
			case PAPER:
				return 0;
			case ROCK:
				return 1;
			case SCISSORS:
				return -1;
			default:
				throw new IllegalArgumentException("Not a valid gesture: %s".formatted(theirGesture));
			}
		case ROCK:
			switch (theirGesture) {
			case PAPER:
				return -1;
			case ROCK:
				return 0;
			case SCISSORS:
				return 1;
			default:
				throw new IllegalArgumentException("Not a valid gesture: %s".formatted(theirGesture));
			}
		case SCISSORS:
			switch (theirGesture) {
			case PAPER:
				return 1;
			case ROCK:
				return -1;
			case SCISSORS:
				return 0;
			default:
				throw new IllegalArgumentException("Not a valid gesture: %s".formatted(theirGesture));
			}
		default:
			throw new IllegalArgumentException("Not a valid gesture: %s".formatted(myGesture));
		}
	}
}
