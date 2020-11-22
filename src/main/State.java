//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

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
		String[] moveset = {"","","",""};
		this.row = row;
		this.column = column;
		if (row!=0)
			moveset[0]=("up");
		if (row!=maxRows-1)
			moveset[1]=("down");
		if (column!=0)
			moveset[2]=("left");
		if (column!=maxColumns-1)
			moveset[3]=("right");
		this.moveset = moveset;
	}
}