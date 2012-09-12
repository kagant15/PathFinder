package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;

public abstract class Search {
	
	static ArrayList<String> visited = new ArrayList<String>();
	String current;
	static ArrayList<String> lines;
	private static String delimiter="[ ]+";
	private static String[] tokens;
	static long startTime;
	static long endTime;
	
	
	public static void setStartTime(){
		startTime = new Date().getTime();
	}
	
	public static long getStartTime(){
		return startTime;
	}
	
	public static void setEndTime(){
		endTime = new Date().getTime();
	}
	
	public static long getEndTime(){
		return endTime;
	}

	/**
	 * Returns the name of the country from which the travel begins
	 * @return Starting location
	 */
	public static String getStart(){
		String firstLine=lines.get(0); 
		tokens = firstLine.split(delimiter);
		 
		String startingLocation = tokens[0];
		return startingLocation; 
	 }
	
	/**
	 * Returns the name of the final destination
	 * @return
	 */
	public static String getEnd(){
		String lastLine=lines.get(lines.size()-1);
		tokens = lastLine.split(delimiter);
		 
		return tokens[tokens.length-1]; 
	 }
	
	/**
	 * Gets the list of possible destination locations from a given country
	 * @param country
	 * @return
	 */
	public static Queue<String> getConnections(String country){
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
	 * Returns true if the given country has already been added to the list of visited countries
	 * @param country
	 * @return
	 */
	public static boolean haveVisited(String country){
		for(int i=0; i<visited.size(); i++){
			if(country.equals(visited.get(i))){
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints the ArrayList<String> of countries which have been visited
	 */
	public void printVistedList(){
		for(int i=0; i<visited.size(); i++){
			System.out.println(visited.get(i));
		}
	}
	
	public static void addToVisited(String country){
		visited.add(country);
	}
	
	/**
	 * Returns the time it took for the search to complete
	 * @return
	 */
	public long calcRunTime(){
		long runTime=endTime-startTime;
		
		return runTime;
	}
}
