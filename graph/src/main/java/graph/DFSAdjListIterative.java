package graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFSAdjListIterative {
	
	private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public DFSAdjListIterative(ArrayList<GraphNode> nodeList) {		
		this.nodeList = nodeList;
	}

	private void dfs(GraphNode node) {

		Stack<GraphNode>stack = new Stack<GraphNode>();
		stack.push(node);

		while(!stack.isEmpty()) {

			GraphNode presentNode = stack.pop();
			presentNode.setVisited(true);

			System.out.print(presentNode.getName()+" ");

			for(GraphNode neighbor: presentNode.getNeighbours()) {
				if(!neighbor.isVisited()) {			
					stack.add(neighbor);
					neighbor.setVisited(true);
				}
			}
		}
	}
	
	private void addUndirectedEdge(int i, int j) {
		GraphNode source = nodeList.get(i);
		GraphNode destination = nodeList.get(j);
		source.getNeighbours().add(destination);
		destination.getNeighbours().add(source);
	}
	
	public static void main(String[] args) {
		
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
				
		for(int i=1;i<11; i++) {
			nodeList.add(new GraphNode("V"+i));
		}
		
		DFSAdjListIterative graph = new DFSAdjListIterative(nodeList);
		
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
		
		// Change this to start DFS from another source
		System.out.println("Printing DFS from source: "+nodeList.get(0).getName());
		graph.dfs(nodeList.get(0));
	}	
}
