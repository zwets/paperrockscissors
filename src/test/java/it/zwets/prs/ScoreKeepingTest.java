package it.zwets.prs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Tests the score keeping implemented in the AbstractPlayer class.
 */
class ScoreKeepingTest {
	
	@Test
	void testTalliesAtStart() {
		AbstractPlayer player = stubPlayer(null);
		
		assertEquals(0, player.getRoundsPlayed());
		assertEquals(0, player.getWins());
		assertEquals(0, player.getDraws());
		assertEquals(0, player.getLosses());
	}
	
	@Test
	void testWinsCounter() {
		AbstractPlayer player = stubPlayer(rulesThatAlwaysDecide(1));
		player.tallyOutcome(null, null);
		
		assertEquals(1, player.getRoundsPlayed());
		assertEquals(1, player.getWins());
		assertEquals(0, player.getDraws());
		assertEquals(0, player.getLosses());
	}

	@Test
	void testDrawsCounter() {
		AbstractPlayer player = stubPlayer(rulesThatAlwaysDecide(0));
		player.tallyOutcome(null, null);
		
		assertEquals(1, player.getRoundsPlayed());
		assertEquals(0, player.getWins());
		assertEquals(1, player.getDraws());
		assertEquals(0, player.getLosses());
	}

	@Test
	void testLossesCounter() {
		AbstractPlayer player = stubPlayer(rulesThatAlwaysDecide(-1));
		player.tallyOutcome(null, null);
		
		assertEquals(1, player.getRoundsPlayed());
		assertEquals(0, player.getWins());
		assertEquals(0, player.getDraws());
		assertEquals(1, player.getLosses());
	}

	// Creators for stub rules and player
	
	/* Return a rules implementation that always yields the same fixed decision,
	 * regardless of what is passed to its decide method (even null is fine). */
	private Rules rulesThatAlwaysDecide(int decision) {
		return new Rules() {
			@Override public String[] getGestures() { return null; }
			@Override public int decide(String a, String b) { return decision; }
		};
	}

	/* Return a stub player, whose nextMove will never be invoked. */
	private AbstractPlayer stubPlayer(Rules rules) {
		return new AbstractPlayer(rules) {
			@Override public String nextMove() { return null; }
		};
	}
}
