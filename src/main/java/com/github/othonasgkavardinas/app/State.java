//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package com.github.othonasgkavardinas.app;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class State{
	private @Getter int row;
	private @Getter int column;
	private @Getter String[] moveset;
	private @Getter @Setter State next = null;
	private @Getter @Setter String move;
	
	public State(int row, int column, int maxRows, int maxColumns){
		this.row = row;
		this.column = column;
		moveset = new String[] {"","","",""};
		initializeMoveset(maxRows, maxColumns);
	}
	
	private void initializeMoveset(int maxRows, int maxColumns) {
		if (row!=0)
			moveset[0]=("up");
		if (row!=maxRows-1)
			moveset[1]=("down");
		if (column!=0)
			moveset[2]=("left");
		if (column!=maxColumns-1)
			moveset[3]=("right");
	}
	
	public void removeOpositeMove(String direction) {
		int[] removeElements = { 1, 0, 3, 2 };
		for(int i=0; i<Maze.DIRECTIONS.length; i++)
			if(direction.equals(Maze.DIRECTIONS[i])) {
				moveset[removeElements[i]] = "";
				break;
			}
	}
}