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
		
		String[] directions = { "up", "down", "left", "right" }; 
		int noOfDirections = 4;
		int[] directionsR = { currentR-1, currentR+1, currentR, currentR };
		int[] directionsC = { currentC, currentC, currentC-1, currentC+1 };
		
		myStack.push(currentR,currentC,rows,columns);
		
		while(true){
			movesSize = 0;
			System.out.println(currentR + " " + currentC);
			for(int i=0; i<noOfDirections; i++)
				if(myStack.getHead().getMoveset()[i].equals(directions[i])) 	//Creation
					if(directionsR[i]>=0 && directionsC[i]>=0){
						if(labyrinth[directionsR[i]][directionsC[i]])
							movesSize++;
						else
							myStack.getHead().getMoveset()[i]="";
					}
			
			for(int i=0; i<noOfDirections; i++) {
				System.out.println(myStack.getHead().getMoveset()[i]);
				if (myStack.getHead().getMoveset()[i].equals(directions[i])){ 	//First Move
					int[] move = translateMove(currentR, currentC, directions[i]);
					currentR = move[0];
					currentC = move[1];
					myStack.getHead().getMoveset()[i]="";
					myStack.getHead().setMove(directions[i]);
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
