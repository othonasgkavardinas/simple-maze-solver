//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

class MazeTest
{
	public static void main(String args[])
	{
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

		if (!m.solve())
			System.out.println("Maze is insoluble");
		else m.printSolution();

		System.out.println();
		tfmaze[2][2]=true;
		m = new Maze(tfmaze.length, tfmaze[0].length, tfmaze);
		System.out.println(m);

		if (!m.solve())
			System.out.println("Maze is insoluble");
		else m.printSolution();
	}
}
