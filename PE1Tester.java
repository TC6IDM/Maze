package PE1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class PE1Tester {
	//top
	//left
	//bottom
	//right
	
	//This array is the array which is shown in the example
	String [][] array = {{"1110", "1010", "1010", "1000","1010","1011"},
					 	 {"1010", "1000", "1001", "0101","1100","1001"},
					 	 {"1100", "0011", "0101", "0110","0011","0101"},
					 	 {"0101", "1101", "0110", "1001","1110","0000"},
					 	 {"0110", "0011", "1110", "0010","1010","0011"}};
	//This array is an alternate more complex example
	String [][] array2 = {{"0110", "1010", "1010", "1000","1010","1011"},
					 	  {"1110", "1000", "1001", "0101","1100","1001"},
					 	  {"1100", "0011", "0101", "0110","0011","0101"},
					 	  {"0101", "1101", "0110", "1001","1110","0001"},
					 	  {"0010", "0011", "1110", "0010","1010","0011"}};
	//This array is an alternate more complex example
	String [][] emptyArray = {{"0100", "1000", "1000", "1000","1000","1001"},
					 	 	  {"0100", "0000", "0000", "0000","0000","0001"},
					 	 	  {"0100", "0000", "0000", "0000","0000","0101"},
					 	 	  {"0100", "0000", "0000", "0000","0000","0001"},
					 	 	  {"0110", "0010", "0010", "0010","0010","0001"}};
	//This array does not have any
	String [][] notEnoughGatesArray = {{"1110", "1010", "1010", "1000","1010","1011"},
								 	   {"1110", "1000", "1001", "0101","1100","1001"},
								 	   {"1100", "0011", "0101", "0110","0011","0101"},
								 	   {"0101", "1101", "0110", "1001","1110","0001"},
								 	   {"0110", "0011", "1110", "0010","1010","0011"}};
	//This array only has one gate
	String [][] onlyOneGateArray = {{"1110", "1010", "1010", "1000","1010","1011"},
								  	{"1010", "1000", "1001", "0101","1100","1001"},
									{"1100", "0011", "0101", "0110","0011","0101"},
									{"0101", "1101", "0110", "1001","1110","0001"},
									{"0110", "0011", "1110", "0010","1010","0011"}};
	//This array is the array which is shown in the example
	String [][] moreThanTwoGatesArray = {{"0110", "1010", "1010", "1000","1010","1011"},
									 	 {"1010", "1000", "1001", "0101","1100","1001"},
									 	 {"1100", "0011", "0101", "0110","0011","0101"},
									 	 {"0101", "1101", "0110", "1001","1110","0000"},
									 	 {"0110", "0011", "1110", "0010","1010","0011"}};
	//This array tests out an edge case by having gates at the top left and top right corners, the gates "open" towards the top
	String [][] gatesAtTopArray = {{"0110", "1010", "1010", "1000","1010","0011"},
								   {"1110", "1000", "1001", "0101","1100","1001"},
								   {"1100", "0011", "0101", "0110","0011","0101"},
								   {"0101", "1101", "0110", "1001","1110","0001"},
								   {"0110", "0011", "1110", "0010","1010","0011"}};
	//This array tests out an edge case by having gates at the top left and top right corners, the gates "open" towards the left and right
	String [][] gatesAtTopSidesArray = {{"1010", "1010", "1010", "1000","1010","1010"},
								 		{"1110", "1000", "1001", "0101","1100","1001"},
								 		{"1100", "0011", "0101", "0110","0011","0101"},
								 		{"0101", "1101", "0110", "1001","1110","0001"},
								 		{"0110", "0011", "1110", "0010","1010","0011"}};
	//This array tests out an edge case by having gates at the bottom left and bottom right corners, the gates "open" towards the bottom
	String [][] gatesAtBottomArray = {{"1110", "1010", "1010", "1000","1010","1011"},
									  {"1110", "1000", "1001", "0101","1100","1001"},
									  {"1100", "0011", "0101", "0110","0011","0101"},
									  {"0101", "1101", "0110", "1001","1110","0001"},
									  {"0100", "0011", "1110", "0010","1010","0001"}};
	//This array tests out an edge case by having gates at the bottom left and bottom right corners, the gates "open" towards the left and right
	String [][] gatesAtBottomSidesArray = {{"1110", "1010", "1010", "1000","1010","1011"},
									 	   {"1110", "1000", "1001", "0101","1100","1001"},
									 	   {"1100", "0011", "0101", "0110","0011","0101"},
									 	   {"0101", "1101", "0110", "1001","1110","0001"},
									 	   {"0010", "0011", "1110", "0010","1010","0010"}};
	
	
	@Test
	void testisGate1() {
		//tests the isGate method
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.array); // sets up the array 
		boolean testCase; // creates a new boolean variable which is used to check if the method is correct.
		for (int row = 0; row < this.array.length; row++) { //iterates through each row in the array
	    	for (int col = 0; col< this.array[row].length;col++) { //iterates through each column in the array
	    		if (row == 1 && col == 0) testCase = true; //defines the start of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else if (row == 3 && col == 5) testCase = true;//defines the end of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else testCase = false; //any other part of the maze should return false as it is not a gate
	    		assertEquals("Failed point (" + row + ", " + col + ")", testCase, pe1.isGate(row, col)); //checks if the method got the correct answer
	    	}
	    }
	}
	@Test
	void testisGate2() {
		//tests the isGate method
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.gatesAtTopArray); // sets up the array 
		boolean testCase; // creates a new boolean variable which is used to check if the method is correct.
		for (int row = 0; row < this.gatesAtTopArray.length; row++) { //iterates through each row in the array
	    	for (int col = 0; col< this.gatesAtTopArray[row].length;col++) { //iterates through each column in the array
	    		if (row == 0 && col == 0) testCase = true; //defines the start of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else if (row == 0 && col == 5) testCase = true;//defines the end of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else testCase = false; //any other part of the maze should return false as it is not a gate
	    		assertEquals("Failed point (" + row + ", " + col + ")", testCase, pe1.isGate(row, col)); //checks if the method got the correct answer
	    	}
	    }
	}
	@Test
	void testisGate3() {
		//tests the isGate method
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.gatesAtTopSidesArray); // sets up the array 
		boolean testCase; // creates a new boolean variable which is used to check if the method is correct.
		for (int row = 0; row < this.gatesAtTopSidesArray.length; row++) { //iterates through each row in the array
	    	for (int col = 0; col< this.gatesAtTopSidesArray[row].length;col++) { //iterates through each column in the array
	    		if (row == 0 && col == 0) testCase = true; //defines the start of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else if (row == 0 && col == 5) testCase = true;//defines the end of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else testCase = false; //any other part of the maze should return false as it is not a gate
	    		assertEquals("Failed point (" + row + ", " + col + ")", testCase, pe1.isGate(row, col)); //checks if the method got the correct answer
	    	}
	    }
	}
	@Test
	void testisGate4() {
		//tests the isGate method
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.gatesAtBottomArray); // sets up the array 
		boolean testCase; // creates a new boolean variable which is used to check if the method is correct.
		for (int row = 0; row < this.gatesAtBottomArray.length; row++) { //iterates through each row in the array
	    	for (int col = 0; col< this.gatesAtBottomArray[row].length;col++) { //iterates through each column in the array
	    		if (row == 4 && col == 0) testCase = true; //defines the start of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else if (row == 4 && col == 5) testCase = true;//defines the end of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else testCase = false; //any other part of the maze should return false as it is not a gate
	    		assertEquals("Failed point (" + row + ", " + col + ")", testCase, pe1.isGate(row, col)); //checks if the method got the correct answer
	    	}
	    }
	}
	@Test
	void testisGate5() {
		//tests the isGate method
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.gatesAtBottomSidesArray); // sets up the array 
		boolean testCase; // creates a new boolean variable which is used to check if the method is correct.
		for (int row = 0; row < this.gatesAtBottomSidesArray.length; row++) { //iterates through each row in the array
	    	for (int col = 0; col< this.gatesAtBottomSidesArray[row].length;col++) { //iterates through each column in the array
	    		if (row == 4 && col == 0) testCase = true; //defines the start of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else if (row == 4 && col == 5) testCase = true;//defines the end of the maze and says the the method should return true when it checks if this part of the maze is a gate
	    		else testCase = false; //any other part of the maze should return false as it is not a gate
	    		assertEquals("Failed point (" + row + ", " + col + ")", testCase, pe1.isGate(row, col)); //checks if the method got the correct answer
	    	}
	    }
	}
	@Test
	void testtoString() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.array); // sets up the array 
		String newstring = "[1110 1010 1010 1000 1010 1011]\n" //creates the string which should be returned by the function
							+ "[1010 1000 1001 0101 1100 1001]\n"
							+ "[1100 0011 0101 0110 0011 0101]\n"
							+ "[0101 1101 0110 1001 1110 0000]\n"
							+ "[0110 0011 1110 0010 1010 0011]";
		assertEquals("Did not convert to string correctly", newstring, pe1.dogMaze.toString());//compares the given string to the string created by the method
	}
	@Test
	void testenoughGate() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.array); // sets up the array which has a good amount of gates
		assertEquals("Failed calculating ammount of gates", true, pe1.enoughGate()); //checks if the method got the correct answer
	}
	@Test
	void testnotenoughGate() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.notEnoughGatesArray); // sets up the array which does not have a good amount of gates
		assertEquals("Failed calculating ammount of gates", false, pe1.enoughGate()); //checks if the method got the correct answer
	}
	@Test
	void onlyOneGate() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.onlyOneGateArray); // sets up the array which does not have a good amount of gates
		assertEquals("Failed calculating ammount of gates", false, pe1.enoughGate()); //checks if the method got the correct answer
	}
	@Test
	void moreThanTwoGates() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.moreThanTwoGatesArray); // sets up the array which has a good amount of gates
		assertEquals("Failed calculating ammount of gates", true, pe1.enoughGate()); //checks if the method got the correct answer
	}
	
	@Test
	void testSolverCase1() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.array); // sets up a valid array which can be solved
		String testString = "(1,0)(1,1)(1,2)(2,2)(3,2)(3,3)(4,3)(4,4)(4,5)(3,5)"; //gets the actual solution
		String solvedPath = pe1.findPath(1, 0); //gets the solution found by the method
		assertEquals("Failed solving maze", testString, solvedPath); //checks if these solutions match
	}
	@Test
	void testSolverCase2() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.moreThanTwoGatesArray); // sets up a valid array which can be solved
		String testString = "(0,0)(0,1)(0,2)(0,3)(1,3)(2,3)(2,4)(1,4)(1,5)(2,5)(3,5)"; //gets the actual solution
		String solvedPath = pe1.findPath(0, 0);//gets the solution found by the method
		assertEquals("Failed solving maze", testString, solvedPath);//checks if these solutions match
	}
	@Test
	void testSolverCase3() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.gatesAtTopArray); // sets up a valid array which can be solved
		String testString = "(0,0)(0,1)(0,2)(0,3)(0,4)(0,5)"; //gets the actual solution
		String solvedPath = pe1.findPath(0, 0);//gets the solution found by the method
		assertEquals("Failed solving maze", testString, solvedPath);//checks if these solutions match
	}
	@Test
	void testSolverCase4() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.gatesAtTopSidesArray); // sets up a valid array which can be solved
		String testString = "(0,0)(0,1)(0,2)(0,3)(0,4)(0,5)"; //gets the actual solution
		String solvedPath = pe1.findPath(0, 0);//gets the solution found by the method
		assertEquals("Failed solving maze", testString, solvedPath);//checks if these solutions match
	}
	@Test
	void testSolverCase5() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.gatesAtBottomArray); // sets up a valid array which can be solved
		String testString = "(4,0)(3,0)(2,0)(2,1)(1,1)(1,2)(2,2)(3,2)(3,3)(4,3)(4,4)(4,5)"; //gets the actual solution
		String solvedPath = pe1.findPath(4, 0);//gets the solution found by the method
		assertEquals("Failed solving maze", testString, solvedPath);//checks if these solutions match
	}
	@Test
	void testSolverCase6() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.gatesAtBottomSidesArray); // sets up a valid array which can be solved
		String testString = "(4,0)(3,0)(2,0)(2,1)(1,1)(1,2)(2,2)(3,2)(3,3)(4,3)(4,4)(4,5)"; //gets the actual solution
		String solvedPath = pe1.findPath(4, 0);//gets the solution found by the method
		assertEquals("Failed solving maze", testString, solvedPath);//checks if these solutions match
	}
	@Test
	void testSolverCase7() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.array2); // sets up a valid array which can be solved
		String testString = "(0,0)(0,1)(0,2)(0,3)(1,3)(2,3)(2,4)(1,4)(1,5)(2,5)(3,5)(4,5)(4,4)(4,3)(3,3)(3,2)(2,2)(1,2)(1,1)(2,1)(2,0)(3,0)(4,0)"; //gets the actual solution
		String solvedPath = pe1.findPath(0, 0);//gets the solution found by the method
		assertEquals("Failed solving maze", testString, solvedPath);//checks if these solutions match
	}
	@Test
	void testSolverCase8() {
		PE1 pe1 = new PE1(); //Creates a new pe1 object
		pe1.setup(this.emptyArray); // sets up a valid array which can be solved
		String testString = "(0,0)(1,0)(2,0)(3,0)(4,0)(4,1)(3,1)(2,1)(1,1)(0,1)(0,2)(1,2)(2,2)(3,2)(4,2)(4,3)(3,3)(2,3)(1,3)(0,3)(0,4)(1,4)(2,4)(3,4)(4,4)(4,5)"; //gets the actual solution
		String solvedPath = pe1.findPath(0, 0);//gets the solution found by the method
		assertEquals("Failed solving maze", testString, solvedPath);//checks if these solutions match
	}
	/************** Task 1: 3 points ******************/
	@Test
	@Order(1)
	void test_mazeRows() {
		String [][] sample = {{"1110", "1010", "1010", "1000", "1010", "1011"},
                {"1010", "1000", "1001", "0101", "1100", "1001"},
                {"1100", "0011", "0101", "0110", "0011", "0101"},
                {"0101", "1101", "0110", "1001", "1110", "0000"},	
                {"0110", "0011", "1110", "0010", "1010", "0011"}
                };
		Maze maze = new Maze(sample);
		assertEquals(sample.length, maze.getMaze().length, "The # of rows in the maze is not correct. Either the problem is in the constructor od in the getetr method.");
	}
	/************** Task 1: 3 points ******************/
	@Test
	@Order(2)
	void test_mazeColumns() {
		String [][] sample = {{"1110", "1010", "1010", "1000", "1010", "1011"},
                {"1010", "1000", "1001", "0101", "1100", "1001"},
                {"1100", "0011", "0101", "0110", "0011", "0101"},
                {"0101", "1101", "0110", "1001", "1110", "0000"},	
                {"0110", "0011", "1110", "0010", "1010", "0011"}
                };
		Maze maze = new Maze(sample);
		assertEquals(sample[0].length, maze.getMaze()[0].length, "The # of columns in the maze is not correct. Either the problem is in the constructor od in the getetr method.");
		
	}
	/************** Task 1: 3 points ******************/
	@Test
	@Order(3)
	void test_maze_ref() {
		String [][] sample = {{"1110", "1010", "1010", "1000", "1010", "1011"},
                {"1010", "1000", "1001", "0101", "1100", "1001"},
                {"1100", "0011", "0101", "0110", "0011", "0101"},
                {"0101", "1101", "0110", "1001", "1110", "0000"},	
                {"0110", "0011", "1110", "0010", "1010", "0011"}
                };
		Maze maze = new Maze(sample);
		assertNotSame(sample, maze.getMaze(), "Deep copy in the constructor is not correct.");
	}
	/************** Task 1: 3 points ******************/
	@Test
	@Order(4)
	void test_maze_obj1() {
		String [][] sample = {{"1110", "1010", "1010", "1000"},
							  {"1010", "1000", "1001", "0101"},
                              {"1100", "0011", "0101", "0110"},
                              {"0101", "1101", "0110", "1001"},	
                              {"0110", "0011", "1110", "0010"}
                };
		Maze maze = new Maze(sample);
		System.out.println("test_maze_obj1");
		System.out.println(sample[0][0]+" "+ maze.getMaze()[0][0]);
		System.out.println(sample[1][1]+" "+ maze.getMaze()[1][1]);
		System.out.println(sample[2][2]+" "+ maze.getMaze()[2][2]);
		System.out.println(sample[3][3]+" "+ maze.getMaze()[3][3]);
		System.out.println(sample[4][3]+" "+ maze.getMaze()[4][3]);
		System.out.println("test_maze_obj1\n\n");
		assertEquals(sample[0][0], maze.getMaze()[0][0], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[1][1], maze.getMaze()[1][1], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[2][2], maze.getMaze()[2][2], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[3][3], maze.getMaze()[3][3], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[4][3], maze.getMaze()[4][3], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
	}

	/************** Task 1: 3 points ******************/
	@Test
	@Order(5)
	void test_maze_obj2() {
		String [][] sample = {{"1", "1", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "0", "0"},
							  {"1", "0", "1", "0", "1", "0", "0", "0", "1", "0", "0", "1", "0", "1", "0", "1"},
                              {"1", "1", "0", "0", "0", "0", "1", "1", "0", "1", "0", "1", "0", "1", "1", "0"},
                              {"0", "1", "0", "1", "1", "1", "0", "1", "0", "1", "1", "0", "1", "0", "0", "1"}
                };
		Maze maze = new Maze(sample);
		System.out.println("test_maze_obj2");
		System.out.println(sample[0][0]+" "+ maze.getMaze()[0][0]);
		System.out.println(sample[1][1]+" "+ maze.getMaze()[1][1]);
		System.out.println(sample[2][2]+" "+ maze.getMaze()[2][2]);
		System.out.println(sample[3][3]+" "+ maze.getMaze()[3][3]);
		System.out.println(sample[3][15]+" "+ maze.getMaze()[3][15]);
		System.out.println("test_maze_obj2\n\n");
		assertEquals(sample[0][0], maze.getMaze()[0][0], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[1][1], maze.getMaze()[1][1], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[2][2], maze.getMaze()[2][2], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[3][3], maze.getMaze()[3][3], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
		assertEquals(sample[3][15], maze.getMaze()[3][15], "The maze does not have a right value. Either the constructor or the getter method has a problem.");
	}

	/************** Task 2: 3 points ******************/
	@Test
	@Order(6)
	void test_maze_toString1() {
		String [][] sample = {{"1", "1", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "0", "0"},
							  {"1", "0", "1", "0", "1", "0", "0", "0", "1", "0", "0", "1", "0", "1", "0", "1"},
                              {"1", "1", "0", "0", "0", "0", "1", "1", "0", "1", "0", "1", "0", "1", "1", "0"},
                              {"0", "1", "0", "1", "1", "1", "0", "1", "0", "1", "1", "0", "1", "0", "0", "1"}
                };
		Maze maze = new Maze(sample);
		String str = "[1 1 1 0 1 0 1 0 1 0 1 0 1 0 0 0]\n"
				+ "[1 0 1 0 1 0 0 0 1 0 0 1 0 1 0 1]\n"
				+ "[1 1 0 0 0 0 1 1 0 1 0 1 0 1 1 0]\n"
				+ "[0 1 0 1 1 1 0 1 0 1 1 0 1 0 0 1]";
		
		assertTrue(maze.toString().compareToIgnoreCase(str) == 0, " toString() does not work properly.");
	}
	
	/************** Task 2: 2 points ******************/
	@Test
	@Order(7)
	void test_maze_toString2() {
		String [][] sample = {{"1110", "1010", "1010", "1000"},
				  {"1010", "1000", "1001", "0101"},
                  {"1100", "0011", "0101", "0110"},
                  {"0101", "1101", "0110", "1001"},	
                  {"0110", "0011", "1110", "0010"}};
		Maze maze = new Maze(sample);
		String str = "[1110 1010 1010 1000]\n"
				+ "[1010 1000 1001 0101]\n"
				+ "[1100 0011 0101 0110]\n"
				+ "[0101 1101 0110 1001]\n"
				+ "[0110 0011 1110 0010]";
		
		assertTrue(maze.toString().compareToIgnoreCase(str) == 0, " toString() does not work properly.");
	}

	/************** Task 3: 3 points ******************/
	@Test
	@Order(8)
	void test_maze_setUp1() {
		String [][] sample = {{"1110", "1010", "1010", "1000"},
				  {"1010", "1000", "1001", "0101"},
                  {"1100", "0011", "0101", "0110"},
                  {"0101", "1101", "0110", "1001"},	
                  {"0110", "0011", "1110", "0010"}};
		Maze maze = new Maze(sample);
		PE1 pe = new PE1(); 
		pe.setup(sample);
		System.out.println("test_maze_setUp1");
		System.out.println(sample[0][0]+" "+ pe.dogMaze.getMaze()[0][0]);
		System.out.println(sample[1][1]+" "+ pe.dogMaze.getMaze()[1][1]);
		System.out.println(sample[2][2]+" "+ pe.dogMaze.getMaze()[2][2]);
		System.out.println(sample[3][3]+" "+ pe.dogMaze.getMaze()[3][3]);
		System.out.println(sample[4][3]+" "+ pe.dogMaze.getMaze()[4][3]);
		System.out.println("test_maze_setUp1\n\n");
		assertEquals(sample[0][0], pe.dogMaze.getMaze()[0][0], "The Setup method is nto correct");
		assertEquals(sample[1][1], pe.dogMaze.getMaze()[1][1], "The Setup method is nto correct");
		assertEquals(sample[2][2], pe.dogMaze.getMaze()[2][2], "The Setup method is nto correct");
		assertEquals(sample[3][3], pe.dogMaze.getMaze()[3][3], "The Setup method is nto correct");
		assertEquals(sample[4][3], pe.dogMaze.getMaze()[4][3], "The Setup method is nto correct");
	}
	/************** Task 3: 2 points ******************/
	@Test
	@Order(9)
	void test_maze_setUp2() {
		String [][] sample = {{"1110", "1010", "1010", "1000"},
							  {"1010", "1000", "1001", "0101"},
			                  {"1100", "0011", "0101", "0110"},
			                  {"0101", "1101", "0110", "1001"},	
			                  {"0110", "0011", "1110", "0010"}};
		Maze maze = new Maze(sample);
		PE1 pe = new PE1(); 
		pe.setup(sample);
		assertNotSame(sample, pe.dogMaze, "The setup method is not correct. The dogMaze shoudl be stored in different place in memory.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(10)
	void test_maze_enoughGate1() {
		String [][] sample = {{"1110", "1010", "1010", "1001"},
							  {"1110", "1000", "1001", "0101"},
			                  {"1100", "0011", "0101", "0111"},
			                  {"0101", "1101", "0110", "1001"},	
			                  {"0110", "0011", "1110", "0011"}};
		PE1 pe = new PE1(); 
		pe.setup(sample);

		assertFalse(pe.enoughGate(), "The maze has no entrance and the method does not work for this example.");
	}
	/************** Task 4: 4 points ******************/
	@Test
	@Order(11)
	void test_maze_enoughGate2() {
		String [][] sample = {{"0110", "1010", "1010", "1001"},
							  {"1110", "1000", "1001", "0101"},
			                  {"1100", "0011", "0101", "0111"},
			                  {"0101", "1101", "0110", "1001"},	
			                  {"0110", "0011", "1110", "0011"}};
		PE1 pe = new PE1(); 
		pe.setup(sample);
		assertFalse(pe.enoughGate(), "The maze has one entrance on top and the method does not work for this example.");
	}
	/************** Task 4: 4 points ******************/
	@Test
	@Order(12)
	void test_maze_enoughGate3() {
		String [][] sample = {{"0110", "0010", "0010", "0001"},
							  {"1010", "1000", "1001", "0101"},
			                  {"1100", "0011", "0101", "0111"},
			                  {"0101", "1101", "0110", "1001"},	
			                  {"0110", "0001", "1110", "0011"}};
		PE1 pe = new PE1(); 
		pe.setup(sample);
		assertTrue(pe.enoughGate(), "The maze has one entrance at left  and 4 at top, and the method does not work for this example.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(13)
	void test_maze_enoughGate4() {
		String [][] sample = {{"0110", "1010", "1010", "1001"},
				              {"1010", "1000", "1001", "0101"},
                              {"1100", "0011", "0101", "0111"},
                              {"0101", "1101", "0110", "1001"},	
                              {"0110", "0011", "1110", "0011"}};
		PE1 pe = new PE1(); 
		pe.setup(sample);

		assertTrue(pe.enoughGate(), "The maze has exactly two entrances (top and left) entrance and the method does not work for this example.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(14)
	void test_maze_enoughGate5() {
		String [][] sample = {{"1110", "1010", "1010", "1001"},
							  {"1110", "1000", "1001", "0101"},
			                  {"1100", "0011", "0101", "0111"},
			                  {"0101", "1101", "0110", "1001"},	
			                  {"0110", "0011", "1110", "0001"}};
		PE1 pe = new PE1(); 
		pe.setup(sample);
		assertFalse(pe.enoughGate(), "The maze has one entrance at the bottom and the method does not work for this example.");
	}
	/************** Task 4: 3 points ******************/
	@Test
	@Order(16)
	void test_maze_enoughGate7() {
		String [][] sample = {{"0000", "1010", "1010", "1001"},
				  {"1110", "1000", "1001", "0101"},
                  {"1100", "0011", "0101", "0111"},
                  {"0101", "1101", "0110", "1001"},	
                  {"0110", "0011", "1110", "0000"}};
		PE1 pe = new PE1(); 
		pe.setup(sample);
		assertTrue(pe.enoughGate(), "The maze has 4 entrance at left top corner and right bottom corner and the method does not work for this example.");
	}
	/************** Task 5: 5 points ******************/
	@Test
	@Order(17)
	public void testFindPath1() {
		String path = "(0,0)(1,0)(1,1)";
		String [][] sample = {{"1001", "1101"},
                {"0110", "0010"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		boolean result = (pe.findPath(0, 0)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 2x2"); 
	}
	/************** Task 5: 5 points ******************/
	@Test
	@Order(18)
	public void testFindPath2() {
		String path = "(0,0)(0,0)";
		String [][] sample = {{"0001", "1101"},
                {"0110", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		boolean result = (pe.findPath(0, 0)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 2x2, where the gates are perpendicular."); 
	}

	/************** Task 5: 5 points ******************/
	@Test
	@Order(19)
	public void testFindPath3() {
		String path = "(0,0)(1,0)(2,0)(2,1)(2,2)(1,2)(0,2)";
		String [][] sample = {{"1000", "1001", "1100"},
                {"0101", "0111", "0101"},
                {"0110", "1010", "0011"},
                };
		PE1 pe = new PE1();
		pe.setup(sample);
		boolean result = (pe.findPath(0, 0)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 3x3, where one gate is (0, 0) and another at (0,2)"); 
	}
	
	/************** Task 5: 5 points ******************/
	@Test
	@Order(20)
	public void testFindPath4() {
		String path1 = "(3,0)(3,1)(2,1)(2,2)(1,2)(0,2)(0,3)";
		String path2 = "(3,0)(3,1)(3,2)(3,3)(2,3)(1,3)(0,3)";
		String [][] sample = {{"1100", "1001", "1100", "0001"},
							  {"0100", "0011", "0101", "0101"},
							  {"0111", "1100", "0011", "0101"},
							  {"1010", "0010", "1010", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		String res = pe.findPath(3, 0);
		boolean result = (res.compareTo(path1) == 0 || res.compareTo(path2) == 0)? true: false;
		assertTrue(result, "findPath is not correct for a maze of 4x4, where two paths are possible. The gates are at (3, 0)and (0,3)"); 
	}
	/************** Task 5: 5 points ******************/
	@Test
	@Order(21)
	public void testFindPath5() {
		String path = "(3,1)(2,1)(1,1)(1,2)(2,2)(3,2)(3,3)(2,3)(1,3)(0,3)(0,2)";
		String [][] sample = {{"1101", "1110", "0010", "1001"},
							  {"0101", "1100", "1001", "0101"},
							  {"0100", "0001", "0101", "0101"},
							  {"0111", "0101", "0110", "0011"}};
		PE1 pe = new PE1();
		pe.setup(sample);
		boolean result = (pe.findPath(3, 1)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 4x4, where one gate is (3, 1) and another at (0,2)"); 
	}
	/************** Task 5: 5 points ******************/
	@Test
	@Order(22)
	public void testFindPath6() {
		String path = "(1,0)(1,1)(1,2)(2,2)(3,2)(3,3)(4,3)(4,4)(4,5)(3,5)";
		String [][] sample = {{"1110", "1010", "1010", "1000", "1010", "1011"},
                {"1010", "1000", "1001", "0101", "1100", "1001"},
                {"1100", "0011", "0101", "0110", "0011", "0101"},
                {"0101", "1101", "0110", "1001", "1110", "0000"},	
                {"0110", "0011", "1110", "0010", "1010", "0011"}
                };
		PE1 pe = new PE1();
		pe.setup(sample);
		boolean result = (pe.findPath(1, 0)).compareTo(path) == 0? true: false;
		assertTrue(result, "findPath is not correct for a maze of 5x6, where one gate is (1, 0) and another at (3,5)"); 
	}
}
