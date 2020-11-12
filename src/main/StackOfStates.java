//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

class StackOfStates
{
	private State head = null;
	private int size = 0;
	
	public State pop(){
		if(size==0){
			System.out.println("Pop from empty stack");
			System.exit(-1);
		}
		State tempHead = head;
		head = head.getNext();
		size --;
		return tempHead;
	}
	
	public void push(int row, int column, int maxRows, int maxColumns){
		State element = new State(row,column,maxRows,maxColumns);
		element.setNext(head);
		head = element;
		
		String[] directions = { "up", "down", "left", "right" }; 
		int noOfDirections = 4;
		
		if(size!=0)
			for(int i=0; i<noOfDirections; i++)
				if(element.getNext().getMove().equals(directions[i]))
					element.getMoveset()[i]="";	
		size ++;
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
	
	public State getHead(){
		return head;
	}
	
	public void setHead(State head){
		this.head = head;
	}
	
}