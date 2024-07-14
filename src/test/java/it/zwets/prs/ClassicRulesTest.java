package it.zwets.prs;

import static org.junit.jupiter.api.Assertions.*;
import static it.zwets.prs.ClassicRules.PAPER;
import static it.zwets.prs.ClassicRules.ROCK;
import static it.zwets.prs.ClassicRules.SCISSORS;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ClassicRulesTest {

	@Test
	void testGetGestures() {
		
		String[] gestures = new ClassicRules().getGestures();
		
		assertEquals(3, gestures.length);
		assertTrue(Arrays.stream(gestures).anyMatch(PAPER::equals));
		assertTrue(Arrays.stream(gestures).anyMatch(ROCK::equals));
		assertTrue(Arrays.stream(gestures).anyMatch(SCISSORS::equals));
	}

	@Test
	void testPaperBeatsRock() {
		Rules rules = new ClassicRules();
		assertEquals(1, rules.decide(PAPER, ROCK));
		assertEquals(-1, rules.decide(ROCK, PAPER));
	}

	@Test
	void testRockBeatsScissors() {
		Rules rules = new ClassicRules();
		assertEquals(1, rules.decide(ROCK, SCISSORS));
		assertEquals(-1, rules.decide(SCISSORS, ROCK));
	}

	@Test
	void testScissorsBeatsPaper() {
		Rules rules = new ClassicRules();
		assertEquals(1, rules.decide(SCISSORS, PAPER));
		assertEquals(-1, rules.decide(PAPER, SCISSORS));
	}

	@Test
	void testDraws() {
		Rules rules = new ClassicRules();
		assertEquals(0, rules.decide(PAPER, PAPER));
		assertEquals(0, rules.decide(ROCK, ROCK));
		assertEquals(0, rules.decide(SCISSORS, SCISSORS));
	}
	
	@Test
	void testInvalidGestures() {
		Rules rules = new ClassicRules();
		assertThrows(IllegalArgumentException.class, () -> rules.decide(ROCK, "not-a-gesture"));
		assertThrows(IllegalArgumentException.class, () -> rules.decide("not-a-gesture", PAPER));
	}
	
	@Test
	void testNullGestures() {
		Rules rules = new ClassicRules();
		assertThrows(NullPointerException.class, () -> rules.decide(SCISSORS, null));
		assertThrows(NullPointerException.class, () -> rules.decide(null, ROCK));
	}
}
