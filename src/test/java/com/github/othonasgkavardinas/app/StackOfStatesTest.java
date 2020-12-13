package com.github.othonasgkavardinas.app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackOfStatesTest {

	@Test
	public void stackOfStatesTest() {
		StackOfStates sos = new StackOfStates();
		sos.push(2, 2, 10, 10);
		sos.getHead().setMove("up");
		sos.push(1, 2, 20, 20);
		assertArrayEquals(sos.getHead().getMoveset(), new String[] { "up", "", "left", "right" });
		assertTrue(sos.inStack(2, 2));
		sos.pop();
		sos.pop();
		assertTrue(sos.isEmpty());
	}

}
