package com.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game  game;
	
	@Before
	public void setUp() {
		game= new Game();
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) 
			game.roll(pins);
	}
	
	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}

	private void rollStrike() {
		game.roll(10);
	}
	
	@Test
	public void testGutterGame() {
		rollMany(20, 0);
		assertEquals(0, game.score());		
	}

	
	@Test
	public void testAllOnes() {
		rollMany(20, 1);
		assertEquals(20, game.score());
	}
	
	@Test
	public void  testOneSpare() {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		assertEquals(16, game.score());
	}
	
	@Test
	public void testStrike() {
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		assertEquals(24, game.score());
	}
	
	@Test
	public void testPerfectGame() {
		rollMany(12, 10);
		assertEquals(300, game.score());
	}

}
