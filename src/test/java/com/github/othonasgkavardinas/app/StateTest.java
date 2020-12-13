package com.github.othonasgkavardinas.app;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class StateTest {

	@Test
	public void stateTest() {
		State state = new State(1, 1, 10, 10);
		assertArrayEquals(state.getMoveset(), new String[] { "up", "down", "left", "right" });
		State state2 = new State(0, 0, 10, 10);
		assertArrayEquals(state2.getMoveset(), new String[] { "", "down", "", "right" });
		State state3 = new State(9, 9, 10, 10);
		assertArrayEquals(state3.getMoveset(), new String[] { "up", "", "left", "" });
	}
}
