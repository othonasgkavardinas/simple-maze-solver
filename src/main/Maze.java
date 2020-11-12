//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

import java.util.ArrayList;

class Maze
{
	private boolean labyrinth[][];
	private int rows;
	private int columns;
	private StackOfStates myStack = new StackOfStates();
	
	public Maze(int rows, int columns, boolean[][] labyrinth){
		this.rows = rows;
		this.columns = columns;
		this.labyrinth = labyrinth;
	}
	
	public boolean solve(){
		ArrayList<State> moreStates = new ArrayList<State>();
		int last = 0;
		int movesSize;
		int currentR = 0;
		int currentC = 0;
		boolean flag;
		
		String[] directions = { "up", "down", "left", "right" }; 
		int noOfDirections = 4;
		int[] directionsR = { currentR-1, currentR+1, currentR, currentR };
		int[] directionsC = { currentC, currentC, currentC-1, currentC+1 };
		
		myStack.push(currentR,currentC,rows,columns);
		
		while(true){
			movesSize=0;
			
			for(int i=0; i<noOfDirections; i++)
				if(myStack.getHead().getMoveset()[i].equals(directions[i])){ //DIMIOURGIA
					if(labyrinth[directionsR[i]][directionsC[i]])
						movesSize+=1;
					else
						myStack.getHead().getMoveset()[i]="";
				}
			
			flag=true;
			
			for(int i=0; i<noOfDirections; i++)
				if (myStack.getHead().getMoveset()[i].equals(directions[i]) && flag){ //1H KINHSH
					currentR-=1;
					myStack.getHead().getMoveset()[i]="";
					myStack.getHead().setMove(directions[i]);
					flag=false;
				}
			
			if(movesSize>1){ //AN PERISSOTERES APO MIA
				moreStates.add(myStack.getHead());
				last+=1;
			}
			
			if(movesSize==0){ //AN 0 KINISEIS
				if(moreStates.size()==0) //DEN LYNETAI
					return false;
				else{ //ALLH DOKIMH
					while(myStack.getHead() != moreStates.get(last-1))
						myStack.pop();
					currentR=myStack.getHead().getRow();
					currentC=myStack.getHead().getColumn();
					moreStates.remove(last-1);
					last-=1;
				}
			}else //KINISI
				if(!myStack.inStack(currentR,currentC)){
					myStack.push(currentR,currentC,rows,columns);
					if(currentR==rows-1 && currentC==columns-1) //LYNETAI
						return true;
				}
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
