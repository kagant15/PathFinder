package Main;

import java.util.ArrayList;
import java.util.Queue;


/**
 * This class is responsible for implementing the breadth first search technique using a queue
 * 
 * @author Thomas M Kagan
 * 
 */
public class BFS extends Search{

	static boolean foundDestination = false; // Indicates if the final destination has been found on a branch
	
	/**
	 * Sets the list of intersections to be used in the search
	 * @param fileLines
	 */
	public BFS(ArrayList<String> fileLines) {
		super(fileLines);	
	}
	
	/**
	 * Uses recursion to solve the search problem.
	 * @param country
	 */
	public void search(String country){
		String current = country; // The current Country in the tree structure
		Queue<String> destinations = getDestinations(current, null); // The list of all destination locations from the given country
		
		if(current.equals(getEnd())){
			foundDestination=true;
		}
		else{
			while(!destinations.isEmpty() && !foundDestination){
				current=destinations.remove();
				search(current);
			}
		if(foundDestination){
			addToVisited(current);
			}
		}	
	}//end of search()
	
}//end of BFS class