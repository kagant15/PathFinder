package Main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *  This class reads the contents of a given .txt file containing space delimited intersections in the form of country names.
 *  It parses each intersection into a ArrayList of Strings which it passes to either a BFS or DFS class for implementation.
 *  It outputs the countries visited and the time it took for the search expressed in milliseconds 
 * 
 * @author Tommy
 *
 */
public class Driver {
	
	static ArrayList<String> rows; // each string in this list corresponds to a row in the text file
	static String fileLine; //A line in the txt document
	/**
	 * @param args
	 * @throws FileNotFoundException
	 * 
	 * Program starts here
	 */
	 public static void main(String args[])
	  {
		
		 rows=new ArrayList<String>();
		 
		 try{
			 // Open the file
			 FileInputStream fstream = new FileInputStream("/Users/Tommy/Desktop/Maps.txt");
	  
			 // Get the object of DataInputStream
			 DataInputStream in = new DataInputStream(fstream);
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  
			 //Read File Line By Line
			 while ((fileLine = br.readLine()) != null)   {
				 //Print the content on the console
				 rows.add(fileLine);
			 }
			 //Close the input stream
			 in.close();
	  
		 }
		 catch (Exception e){//Catch exception if any
			 System.err.println("Error: " + e.getMessage());}
		 
		 DFS depthFirstSearch= new DFS(rows); 				//Instantiates a DFS object with the intersections taken from the document
		 depthFirstSearch.search();							//Searches the intersections using depthFrist technique 
		 System.out.println(depthFirstSearch.calcRunTime());	//Prints the time it took for the search expressed in milliseconds
		 depthFirstSearch.printVistedList();				//Prints the list of names of the visited countries
		 
//		 BFS breadthFirstSearch = new BFS(rows);
//		 breadthFirstSearch.search();
//		 System.out.println(breadthFirstSearch.calcTime());
//		 breadthFirstSearch.printVistedList();
		 
		 

	  }

}//end of Driver Class
