package Main;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
/**
 * This class is responsible for implementing the depth first search technique using a stack
 * 
 * @author Tommy
 *
 */
public class DFS extends Search {

	//Stack used to implement depth first search
	static Stack<String> lifo=new Stack<String>();
	static boolean foundDestination=false;
	/**
	 * sets the list of intersections to be used in the search
	 * @param fileLines
	 */
	DFS(ArrayList<String> fileLines){
		lines=fileLines;
	}
	
	/**
	 * performs the breadth first search;
	 */
	public void search(){
		setStartTime();
		
		String start=getStart();
		String end=getEnd();
		current=start;
		
		lifo.push(start);
		
		//Loop continues until stack is empty or the destination has been found
		while(!lifo.isEmpty()){
			current=lifo.pop();
			//If final destination has been found then end
			if(current.equals(end)){
				addToVisited(current);
				break;
			}
			else{
				Queue<String> destinations=getConnections(current);//List containing all the possible destinations from a given country
				
				//While the country has destinations and those destinations have not been visited
				while(!destinations.isEmpty()){
					if(!haveVisited(destinations.peek())){
						lifo.push(destinations.remove());
					}
				}
				addToVisited(current);
			}
		}
		setEndTime();
	}//end of search()
	
	
	public void search2(String country){
		
		String current = country;
		Queue<String> destinations = getConnections(current);
		
		if(current.equals(getEnd())){
		//	addToVisited(current);
			foundDestination=true;
		}
		else{
		 while(!destinations.isEmpty() && !foundDestination){
			 current=destinations.remove();
			 search2(current);
		 }
		 if(foundDestination){
			 addToVisited(current);
		 }
		}
		
	}
	
//	public void containsEnding(String currents){
//		Queue<String> destinations = getConnections(currents);
//		
//		if(!currents.equals(getEnd()) && destinations.isEmpty()){
//			return;
//		}
//		else{
//			while(!destinations.isEmpty()){
//				if(destinations.contains(getEnd())){
//					addToVisited(currents);
//					System.out.println("added "+currents+" to visited list");
//					return;
//				}
//				currents=destinations.remove();
//				containsEnding(currents);
//			}
//		}
//		
//	}//end of containsEnding()
	
	//SUDO CODE
// method(pointer){	
//	current=point
//	if (current==finalDestination){
//   add current to final list;
//   end=found;
//   return;}
//	while(current.hasUnvisitedChildren && end!=found){
//	  current=children.remove();
//	  method(current);}
//	if(end==found){
//   add current to final list; 
//	 }
//	}
//	
//SUDO CODE2
// method(pointer){	
//	current=pointer;
//	while(end!=found){
//	  if (current==finalDestination){
//      add current to final list;
//      end=found;
//      return;
//	  }
//	  while(current.hasChildren && end!=found)){
//	    current=children.remove();
//	    method(current);
//	  }
//	  if(end==found){
//	    add current to final list;
//	  }
//	  else{
//	    return;//reach the end of a branch and did not find destination}
//	  }
//	add current to final list;

	//SUDO CODE3
	// method(pointer){	
//		current=pointer;
//      while(current.hasUnvisitedChildren && end!=found){	
//		  if (current==finalDestination){
//	      add current to final list;
//	      end=found;
//	      return;
//		  }
//		    current=children.remove();
//		    method(current);
//      }
//		add current to final list;	
//	  }


}
