package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* 
	Problem : The graph coloring (also called as vertex coloring) is a way of coloring the vertices of a graph 
				such that no two adjacent vertices share the same color. 
 	Approach : Greedy algorithm for graph coloring and try to minimize the number of colors used.
 	Brook's Theorem - It states that a connected graph can be colored with only x colors 
						where x is maximum degree of any vertex in the graph except for complete graphs 
						and graphs containing odd length cycle, which requires x + 1 colors.
*/

public class ColorGraph {

	private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	
	private String[] color = {
			"", "BLUE", "GREEN", "RED", "YELLOW", "ORANGE", "PINK",
			"BLACK", "BROWN", "WHITE", "PURPLE", "VOILET"
	};

	public ColorGraph(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	protected void colorGraph()
	{
		// stores color assigned to each vertex
		Map<String, Integer> result = new HashMap<String, Integer>();

		// assign color to vertex one by one
		for (int u = 0; u < nodeList.size(); u++) {
			
			// set to store color of adjacent vertices of u
			Set<Integer> assigned = new TreeSet<Integer>();
			GraphNode currentNode = nodeList.get(u);

			// check colors of adjacent vertices of u and store in set
			for (GraphNode neighbor : currentNode.getNeighbours()) {
				
				if (result.containsKey(neighbor.getName())) {
					assigned.add(result.get(neighbor.getName()));
				}
			}

			// check for first free color
			int color = 1;
			for (Integer c: assigned) {
				if (color != c) {
					break;
				}
				color++;
			}

			// assigns vertex u the first available color
			result.put(currentNode.getName(), color);
		}

		for (int v = 0; v < nodeList.size(); v++) {
			System.out.println("Color assigned to vertex " + v + " is "
					+ color[result.get(nodeList.get(v).getName())]);
		}
	}
	
	private void addUndirectedEdge(int source, int destination){
		GraphNode sourceNode = nodeList.get(source);
		GraphNode destinationNode = nodeList.get(destination);
		sourceNode.getNeighbours().add(destinationNode);
		destinationNode.getNeighbours().add(sourceNode);
	}
	
	public static void main(String[] args) {
		
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
		
		for(int i=0;i<10; i++) {
			nodeList.add(new GraphNode("V"+i));
		}
				
		ColorGraph graph = new ColorGraph(nodeList);
				
		graph.addUndirectedEdge(0,1);
		graph.addUndirectedEdge(0,3);
		graph.addUndirectedEdge(1,2);
		graph.addUndirectedEdge(1,4);
		graph.addUndirectedEdge(2,5);
		graph.addUndirectedEdge(2,9);
		graph.addUndirectedEdge(3,6);
		graph.addUndirectedEdge(4,7);
		graph.addUndirectedEdge(5,8);
		graph.addUndirectedEdge(6,7);
		graph.addUndirectedEdge(7,8);
		graph.addUndirectedEdge(8,9);
		
		graph.colorGraph();

	}
}
