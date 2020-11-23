//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

import java.util.ArrayList;

public class Maze
{
	private boolean labyrinth[][];
	private int rows;
	private int columns;
	private StackOfStates myStack;
	public static String[] DIRECTIONS = { "up", "down", "left", "right" };
	
	public Maze(int rows, int columns, boolean[][] labyrinth){
		this.rows = rows;
		this.columns = columns;
		this.labyrinth = labyrinth;
		myStack = new StackOfStates();
	}
	
	public boolean solve(){
		ArrayList<State> moreStates = new ArrayList<State>();
		int last = 0;
		int movesSize;
		int currentR = 0;
		int currentC = 0;
		
		int[] directionsR;
		int[] directionsC;

		myStack.push(currentR,currentC,rows,columns);
		
		while(true){
			directionsR = new int[]{ currentR-1, currentR+1, currentR, currentR };
			directionsC = new int[]{ currentC, currentC, currentC-1, currentC+1 };

			movesSize = 0;
			for(int i=0; i<DIRECTIONS.length; i++)
				if(myStack.getHead().getMoveset()[i].equals(DIRECTIONS[i])) { 	//Creation
					if(labyrinth[directionsR[i]][directionsC[i]])
						movesSize++;
					else
						myStack.getHead().getMoveset()[i]="";
				}
			
			for(int i=0; i<DIRECTIONS.length; i++) {
				if (myStack.getHead().getMoveset()[i].equals(DIRECTIONS[i])){ 	//First Move
					int[] move = translateMove(currentR, currentC, DIRECTIONS[i]);
					currentR = move[0];
					currentC = move[1];
					myStack.getHead().getMoveset()[i]="";
					myStack.getHead().setMove(DIRECTIONS[i]);
					break;
				}
			}
			
			if(movesSize>1){ 						//More than one moves
				moreStates.add(myStack.getHead());
				last++;
			}
			
			if(movesSize==0){ 						//Zero Moves
				if(moreStates.size()==0) 			//Cannot be solved
					return false;
				else{ 								//Next test
					while(myStack.getHead() != moreStates.get(last-1))
						myStack.pop();
					currentR = myStack.getHead().getRow();
					currentC = myStack.getHead().getColumn();
					moreStates.remove(last-1);
					last--;
				}
			}else { 									//Then Move
				if(!myStack.inStack(currentR,currentC)){
					myStack.push(currentR, currentC, rows, columns);
					if(currentR==rows-1 && currentC==columns-1) //It can be solved
						return true;
				}
			}
		}
	}	
	
	private int[] translateMove(int currentR, int currentC, String direction) {
		switch(direction) {
			case "up":
				return new int[] { currentR-1, currentC };
			case "down":
				return new int[] { currentR+1, currentC };
			case "left":
				return new int[] { currentR, currentC-1 };
			case "right":
				return new int[] { currentR, currentC+1 };
			default:
				return null;
		}
	}
	
	public String toString(){
		String tempString = "";
		for (int i=0; i<labyrinth.length; i++){
			for (int j=0; j<labyrinth[0].length; j++){
				if(labyrinth[i][j]) tempString+="0";
				else tempString+="1";
				if(j!=columns) tempString+=" ";
			}
			tempString+="\n";
		}		
		return tempString;
	}
	
	public void printSolution(){
		String tempString = "";
		State tempState;
		String[][] tempArray = new String[rows][columns];
		for (int i=0; i<labyrinth.length; i++)
			for (int j=0; j<labyrinth[0].length; j++){
				if(labyrinth[i][j]) tempArray[i][j]="0";
				else tempArray[i][j] ="1";
			}
		
		while(!myStack.isEmpty()){
			tempState = myStack.pop();
			tempArray[tempState.getRow()][tempState.getColumn()] = "*";
		}
		
		for (int k=0; k<tempArray.length; k++){
			for (int l=0; l<tempArray[0].length; l++){
				tempString+=tempArray[k][l];
				if(l!=columns) tempString+=" ";
			}
			tempString+="\n";
		}
		System.out.println(tempString);
	}
}
