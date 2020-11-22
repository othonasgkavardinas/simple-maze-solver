package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.StackOfStates;

class StackOfStatesTest {

	@Test
	public void stackOfStatesTest() {
		StackOfStates sos = new StackOfStates();
		sos.push(2, 2, 10, 10);
		sos.getHead().setMove("up");
		sos.push(1, 2, 20, 20);
		assertArrayEquals(sos.getHead().getMoveset(), new String[] { "", "down", "left", "right" });
		assertTrue(sos.inStack(2, 2));
		sos.pop();
		sos.pop();
		assertTrue(sos.isEmpty());
	}

}
