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
 * @author Thomas M Kagan
 * 
 */
public class Driver {
	
	private static String fileLine; //A line in the txt document
	private static ArrayList<String> lines; // a list of lines from the txt document
	private static String file="/Users/Tommy/Desktop/Maps.txt";
	/**
	 * @param args
	 * @throws FileNotFoundException
	 * 
	 * Program starts here
	 */
	 public static void main(String args[])
	  {
		 lines=new ArrayList<String>();
		 
		 try{
			 // Open the file
			 FileInputStream fstream = new FileInputStream(file);
	  
			 // Get the object of DataInputStream
			 DataInputStream in = new DataInputStream(fstream);
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
			 
			 // Read file line by line and add each line into the list
			 while ((fileLine = br.readLine()) != null){
				 lines.add(fileLine);
			 }
			 // Close the input stream
			 in.close();
	  
		 }
		 catch (Exception e){//Catch exception if any
			 System.err.println("Error: " + e.getMessage());
		 }
		 
		 Search depthFirstSearch = new DFS(lines); 			// Instantiates a DFS object with the intersections taken from the document
		 depthFirstSearch.run();
		 depthFirstSearch.printVistedList();				// Prints the list of names of the visited countries
		 System.out.println("DFS runtime: "+depthFirstSearch.calcRunTime()+" miliseconds\n");//Prints the time it took for the search expressed in milliseconds
		 
		 Search breadthFirstSearch = new BFS(lines);		// Instantiates a BFS object with the intersections taken from the document
		 breadthFirstSearch.run();
		 breadthFirstSearch.printVistedList();				// Prints the list of countries that were visited in the breadth first search
		 System.out.println("BFS runtime: "+breadthFirstSearch.calcRunTime()+" miliseconds");//Prints the time it took for the search expressed in milliseconds

	  }//end of main()

}//end of Driver Class
