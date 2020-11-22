package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Maze;

class MazeTest {

	@Test
	public void test() {
		int digitsmaze[][] = { 	{0,1,0,0,0,0},
				{0,1,0,0,1,0},
				{0,1,1,1,1,0},
				{0,1,0,0,1,0},
				{0,0,0,0,1,0}};

		boolean tfmaze[][] = new boolean[digitsmaze.length][];
		for (int i=0; i<digitsmaze.length; i++) {
		tfmaze[i] = new boolean[digitsmaze[i].length];
		for (int j=0; j<digitsmaze[i].length; j++)
		if (digitsmaze[i][j]==0) tfmaze[i][j] = true;
		}
		
		Maze m = new Maze(tfmaze.length, tfmaze[0].length, tfmaze);
		System.out.println(m);
	}

}
