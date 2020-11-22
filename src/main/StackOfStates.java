//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

import lombok.Getter;
import lombok.Setter;

public class StackOfStates{
	private @Setter @Getter State head = null;
	private int size = 0;
	
	public State pop(){
		if((size--)==0){
			System.out.println("Pop from empty stack");
			System.exit(-1);
		}
		State tempHead = head;
		head = head.getNext();
		return tempHead;
	}
	
	public void push(int row, int column, int maxRows, int maxColumns){
		State element = new State(row,column,maxRows,maxColumns);
		element.setNext(head);
		head = element;
		
		String[] directions = { "up", "down", "left", "right" }; 
		int noOfDirections = 4;
		if((size++)!=0)
			for(int i=0; i<noOfDirections; i++)
				if(element.getNext().getMove().equals(directions[i]))
					element.getMoveset()[i]="";
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public boolean inStack(int row,int column){
		State tempHead = head;
		for(int i=size; i>0; i--){
			if(row==head.getRow() && column==head.getColumn()){
				head = tempHead;
				return true;
			}
			head = head.getNext();
		}
		head = tempHead;
		return false;
	}
	
}