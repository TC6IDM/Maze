package PE1;

import java.util.ArrayList;
import java.util.List;




public class PE1 {
	Maze dogMaze; 
    /**
	 * This method sets up the maze using the given input argument
	 * @param maze is a maze that is used to construct the dogMaze
	 */
	public void setup(String[][] maze) {
		this.dogMaze = new Maze(maze);//sets the instance variable dogMaze equal to a new Maze given the input parameter
	}
	
	/**
	 * This method returns true if the number of 
	 * gates in dogMaze >= 2. 
	 * @return it returns true, if enough gate exists (at least 2), otherwise false.
	 */
	public boolean enoughGate() {
		if (totalGates(0,0)>=2) return true; //if there are more than 2 gates in the maze return true
		return false;//returns false if there is less than 2 gates
	}
	
	/**
	 * This method recursively finds the amount of gates in the maze
	 * @param row is an integer depicting the current row of the element, it should start off as 0
	 * @param col is an integer depicting the current row of the element, it should start off as 0
	 * @return it returns the amount of gates in the maze
	 */
	public int totalGates(int row,int col) {
		int gateCount = 0;//Initializes the gateCount variable to 0
		if(this.dogMaze.getMaze()[row].length==col){ //checks if the iteration has reached the end of the row
			row++;//increments the row to move to the next row
			col=0;//sets the column back to 0
        }
        if (this.dogMaze.getMaze().length <= row) return 0; //returns 0 once every element of the list has been checked (the recursive function has moved from the top left of the maze to the bottom right)
        if (isGate(row,col)) gateCount +=1; //if the current element is a gate, increment the amount of gates by 1
        col++;//increments the column to move to the next column
        return gateCount + totalGates(row,col); //recursively calls itself to iterate through the 2D array while adding up the amount of gates
	}
	
	/**
	 * This method uses the given input arguments; row and column 
	 * of the 2D maze and returns true if the specified position is a gate.
	 * @param row is an integer depicting the row of the element
	 * @param column is an integer depicting the column of the element
	 * @return it returns true if the given row and column marks a gate in the maze, otherwise false.
	 */
	public boolean isGate (int row,int column) {
		int rowlen = this.dogMaze.getMaze().length; //gets the length of each row in the maze
		int collen = this.dogMaze.getMaze()[0].length; // gets the length of each column in the maze
		List<Integer> directionCheck = new ArrayList<Integer>(); //creates an ArrayList of which directions of the element should be checked (up,left,down,right)
		boolean gate = false; //Initializes this position as not a gate
		
		int lookup[][] = {{row,0}, 				//indicates that we are in the first row (row 0)
				  		  {column,0},			//indicates that we are in the first column (column 0)
				  		  {row,rowlen-1},		//indicates that we are in the last row (row -1)
				  		  {column,collen-1}};	//indicates that we are in the last column (column -1)
		
		for(int side = 0; side < 4; side++) { // iterates this code 4 times to check each side (up, left, down, right)
			/*
			 * This if statement checks if this current element is along any side and appends that side to the ArrayList
			 * for example, if this element is on the left side, then the side 1 will be added to the ArrayList
			 * if the element is on a corner like the top left corner, the side 0 will be added to the ArrayList 
			 * then the side 1 will be added to the ArrayList (depending on which corner it is looking at)
			 */
			if (lookup[side][0] == lookup[side][1]) directionCheck.add(side);
		}
		
		if (directionCheck.size()==0) return false; //returns false if the given element is not along any of the edges of the maze
		
		for(int i = 0; i < directionCheck.size(); i++) { //loops through every possible direction where there could be an opening which will make the element a gate
			gate = (gate || ((this.dogMaze.getMaze()[row][column]).charAt(directionCheck.get(i)) == '0')); //checks if the element is open along the side which it needs to be, to be considered a gate
		}
		    
		return gate; //returns true if this element is a gate and returns false if it is not a gate
	}

	/**
	 * This method recursively finds a solution to to a given maze
	 * @param row is an integer depicting the row of the element
	 * @param column is an integer depicting the column of the element
	 * @param startRow is an integer depicting the starting row of the element
	 * @param startCol is an integer depicting the starting column of the element
	 * @param modifiedMaze is a maze which is being edited as the search moves through it
	 * @returns the solution to the maze when it is solved.
	 */
	public String solve(int startRow, int startCol, int row, int col, Maze modifiedMaze) {
		String returnVal = ""; //creates a return string, this will store the moves in the maze
		int lookup[][] = {{-1,0}, //moving up, subtract the row by 1
				  {0,-1}, //moving left, subtract the column by 1
				  {1,0},  //moving down, add 1 to the row
				  {0,1}}; //moving right, add 1 to the column.
		
		if (isGate(row,col) && !(row==startRow && col==startCol)) { //checks if the current element is a gate but not the entrance gate
			return "("+row+","+col+")"; //returns the final point in the maze  if the end of the maze has been reached
		}
		
		for (int side=0;side<4;side++) { //loops through each side, (up left down right)
			int newRow = row+lookup[side][0]; // gets the row for the new element
			int newCol = col+lookup[side][1]; // gets the column for the new element 
			
			if (returnVal=="") {//looks in the next direction if looking in the previous direction did not return with the solution to the maze
				if (validPoint(newRow,newCol,modifiedMaze.getMaze(),side)) { //checks if the point can be in the given direction
					/* 
					marks the current element as "closed" by putting walls on all sides
					and then adds a wall on the new element depending the direction it moves to the new element from
					for example if we are moving to the right, it will close the left wall on the new element.
					Then, makes a copy of that modified maze to send back through the recursive function
					*/ 
					Maze changedMaze = new Maze(modifiedMaze.closePath(row, col,newRow,newCol,side));
					returnVal = solve(startRow,startCol,newRow,newCol,changedMaze);//looks for the next step in the maze recursively using the modified maze
				}
				else {
					returnVal = "";//returns an empty string if the point can not move in the given direction
				}
			}
		}
		if (returnVal!="") { //checks if we have reached an exit
			returnVal = "("+row+","+col+")" + returnVal; //adds each point to the path except the exit, that was done above
		}
	    
	    return returnVal;//returns the solution to the maze 
	  }
	
	/**
	 * This method checks if we can move in the given direction
	 * @param row is an integer depicting the row of the element
	 * @param column is an integer depicting the column of the element
	 * @param maze is the maze which is being solved
	 * @param side is the side of the element which is being looked up
	 * @returns true we can move to the point above, otherwise false
	 */
	public boolean validPoint(int row, int col, String[][] maze,int side) {
		int [] lookup = {2,3,0,1}; //gets the opposite side, for example, if the function is fed the side (0) for top, it will find the bottom side (2)
		if (row>=0 && row<maze.length && col>=0 && col<maze[0].length) { //checks if the point is in bounds of the maze
			return maze[row][col].charAt(lookup[side])=='0'; //depending on which side it is given, we check if the wall is open on that side,if it is, it returns true, if there is a wall it returns false
		}
		return false;//if the point is not in bounds of the maze returns false 
	}
	
	/**
	 * This method finds a path from the entrance gate to 
	 * the exit gate. 
	 * @param row is the index of the row, where the entrance is.
	 * @param column is the index of the column, where the entrance is.
	 * @return it returns a string that contains the path from the start to the end. 
	 * The return value should have a pattern like this (i,j)(k,l),...
	 * The first pair of the output must show the entrance given as the 
	 * input parameter (i.e. (row,column)
	 * No whitespace is allowed in the output.  
	 */
	public String findPath (int row, int column) {
		return solve(row,column,row,column,new Maze(dogMaze.getMaze())); //solves the maze by giving the solver a copy of the dogMaze
	}
}


/**
 * This class defines a <code> maze </code> using a 2D array. 
 * To complete the code, you should not change the method 
 * signatures (header). 
 *
 */
class Maze{
	private String [][] maze; 
	
	/**
	 * This constructor makes the maze. 
	 * @param maze is a 2D array that contains information 
	 * on how each cell of the array looks like. 
	 */
	public Maze(String[][] maze) {//make a 2D array deep copy of the given input and deep copies it to the instance variable
		this.maze = new String[maze.length][maze[0].length];//defines the instance variable as a 2D String array with the same dimensions as the given maze
	    for (int row = 0; row < maze.length; row++) { //iterates through each row in the input
	    	for (int col = 0; col< maze[row].length;col++) { //iterates through each column in the input
	    		this.maze[row][col]=maze[row][col]; //sets the value at position [row][col] in the instance variable to the exact same value as the value in the same position in the input
	    	}
	    }
	}
	/**
	 * This method effectively closes off a path once it is passed through
	 * it will put walls on all sides of the given index by changing it to "1111"
	 * it will also put a wall on the side which it moves through on the new index
	 * ex: moving from the first element to the second element from left to right
	 * this function will make the left wall of the second element into a wall "1"
	 * @param row is an integer depicting the row of the element
	 * @param column is an integer depicting the column of the element
	 * @param newRow is an integer depicting the row of the next element
	 * @param newColumn is an integer depicting the column of the next element
	 * @param side is the side which a wall should be added to
	 * @return returns the edited maze
	 */
	public String[][]closePath(int row,int column, int newRow, int newColumn, int side){
		String [][]newMaze = new Maze(this.maze).getMaze();//clones the maze
		newMaze[row][column] = "1111"; //sets all directions at this point to closed to seal off this point in the path
		newMaze[newRow][newColumn]= newMaze[newRow][newColumn].substring(0,side)+'1'+ newMaze[newRow][newColumn].substring(side+1,4); //shuts off the side which we are coming from in the next element
		return newMaze; //returns the edited maze
	}	
	
	/**
	 * This accessor (getter) method returns a 2D array that
	 * represents the maze
	 * @return it returns a reference to the maze
	 */
	public String[][] getMaze(){ //creates a clone of the 2D array instance variable maze and returns said clone to the user
		String[][] mazeCopy = new String[this.maze.length][this.maze[0].length]; // defines a new 2D array called mazeCopy with the same dimensions as the instance variable
		for (int row = 0; row < this.maze.length; row++) { //iterates through each row in the instance variable
	    	for (int col = 0; col< this.maze[row].length;col++) {//iterates through each column in the instance variable
	    		mazeCopy[row][col]=this.maze[row][col]; //sets the value at position [row][col] in the clone to the exact same value as the value in the same position in the instance variable
	    	}
	    }
		return mazeCopy; //returns the clone
	}
	
	/**
	 * This method returns a String representation of the maze
	 * @return the maze in a more readable string
	 */
	@Override 
	public String toString() { //copies the instance variable into a string which can be read more easily by the user, and then returns the string to the user
		String newString = ""; //initializes a string called newString, it starts as an empty string
		for (int row = 0; row < this.maze.length; row++) { //iterates through each row in the instance variable
			newString+="["; //At the beginning of each row we add a open square bracket
	    	for (int col = 0; col< this.maze[row].length;col++) {//iterates through each column in the instance variable
	    		newString+=this.maze[row][col]; //adds the value in the instance variable at the position [row][col] to the end of the newString
	    		if (this.maze[row].length != col+1) newString+=" ";//since there is no space added to the last element in each column, this if statement only adds a space on the end of the string if the current element is not the last one in the column 
	    	}
	    	newString+="]";//At the end of each row we add a closed square bracket
	    	if (this.maze.length != row+1) newString+="\n"; //since there is no newline character added to the last row, this if statement only adds a newline character on the end of the row if the current row is not the last row
	    }
		return newString; //this returns the newly created string
	}
	
}// end of class Maze
