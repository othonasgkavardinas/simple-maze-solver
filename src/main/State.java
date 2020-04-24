//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

class State
{
	private int row;
	private int column;
	private String[] moveset;
	private State next = null;
	private String move;
	
	public State(int row, int column, int maxRows, int maxColumns){
		String[] moveset = {"","","",""};
		this.row = row;
		this.column = column;
		if(row==0 && column==0){
			moveset[1]=("down");
			moveset[3]=("right");
		}else{
			if (row!=0){
				moveset[0]=("up");
			}
			if (row!=maxRows-1){
				moveset[1]=("down");
			}
			if (column!=0){
				moveset[2]=("left");
			}
			if (column!=maxColumns-1){
				moveset[3]=("right");
			}
		}
		this.moveset = moveset;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
	
	public State getNext(){
		return next;
	}
	
	public String[] getMoveset(){
		return moveset;
	}
	
	public void setNext(State element){
		next = element;
	}
	//DEN XREIAZETAI
	public String toString(){
		return "row:"+row+" column:"+column;
	}
	
	public String getMove(){
		return move;
	}
	
	public void setMove(String move){
		this.move=move;
	}
}