package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This is the super class used for the polymorphism implementation of the depth and breadth first search methods
 * 
 * @author Thomas M Kagan
 * 
 */
public abstract class Search {
	
	private ArrayList<String> visited = new ArrayList<String>();
    private ArrayList<String> lines;
	private static String delimiter="[ ]+";
	private static String[] tokens;
    private long startTime;
    private long endTime;
	
	public Search(ArrayList<String> fileLines){
		lines=fileLines;
	}
	
	/**
	 * This gets overridden in it's subclasses
	 * @param country
	 */
	public void search(String country){
		
	}
	
	/**
	 * Sets the start time, performs the search, adds the starting location to the list of visited places, and sets the end time
	 */
	public void run(){
		setStartTime();
		search(getStart());
		addToVisited(getStart());
		setEndTime();
	}
	
	/**
	 * Returns the name of the country from which the travel begins
	 * @return Starting location
	 */
	public String getStart(){
		String firstLine=lines.get(0); 
		tokens = firstLine.split(delimiter);
		String startingLocation = tokens[0];
		return startingLocation;
	 }
	
	/**
	 * Returns the name of the final destination
	 * @return
	 */
	public String getEnd(){
		String lastLine=lines.get(lines.size()-1);
		tokens = lastLine.split(delimiter);
		 
		return tokens[tokens.length-1]; 
	 }
	
	/**
	 * Gets the list of possible destination locations from a given country and returns them in a stack
	 * @param country
	 * @return possible destination countries
	 */
	public Stack<String> getDestinations(String country){
		String[] connection;
		Stack<String> connections = new Stack<String>();
		
		for(int i=0; i<lines.size(); i++){
			connection=lines.get(i).split(delimiter);
			if (country.equals(connection[0])){
				connections.add(connection[1]);
			}
		}
		return connections;
	}

	/**
	 * Gets the list of possible destination locations from a given country and returns them in a queue.
	 * This method gets passed a null param so that it can be overloaded.
	 * @param country, null
	 * @return possible destination countries
	 */
	public Queue<String> getDestinations(String country, String other){
		String[] connection;
		Queue<String> connections = new LinkedList<String>();
		
		for(int i=0; i<lines.size(); i++){
			connection=lines.get(i).split(delimiter);
			if (country.equals(connection[0])){
				connections.add(connection[1]);
			}
		}
		return connections;
	}
	
	/**
	 * Prints the list of countries which have been visited
	 */
	public void printVistedList(){
		System.out.println("Path:" );
		
		for(int i=visited.size(); i>0; i--){
			System.out.println("\t"+visited.get(i-1));
		}
	}
	
	public void addToVisited(String country){
		visited.add(country);
	}
	
	public void setStartTime(){
		startTime = System.currentTimeMillis();
	}
	
	public long getStartTime(){
		return startTime;
	}
	
	public void setEndTime(){
		endTime = System.currentTimeMillis();
	}
	
	public long getEndTime(){
		return endTime;
	}
	
	/**
	 * Returns the time it took for the search to complete
	 * @return
	 */
	public long calcRunTime(){
		long runTime=endTime-startTime;
		
		return runTime;
	}

}//end of Search class
