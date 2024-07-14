package it.zwets.prs;

/**
 * Application main class, runs the game and outputs the game summary.
 * 
 * <b>Design note:</b> I would normally implement command line option
 * parsing (of at least the <tt>-h/--help</tt> option), but have omitted
 * for simplicity.
 * 
 * Also, we "hard construct" the players and the game rather than having
 * them dependency injected, which would make sense in a real life setup.
 */
public class Main {

	public static void main(String[] args) {
		
		Rules rules = new ClassicRules();
		AbstractPlayer human = new InteractivePlayer(rules);
		AbstractPlayer computer = new RandomGuessPlayer(rules);
		
		Game game = new Game(human, computer);
		game.play();
		
		System.out.println("\nFinal score: you won %d, I won %d, we drew %d."
				.formatted(human.getWins(), human.getLosses(), human.getDraws()));
	}
}
