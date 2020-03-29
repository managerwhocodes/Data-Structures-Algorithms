package graph;

import java.util.ArrayList;

public class DFSAdjListRecursive {
	
	private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	private DFSAdjListRecursive(ArrayList<GraphNode> nodeList) {		
		this.nodeList = nodeList;
	}
	
	private void dfs(GraphNode node) {

		node.setVisited(true);
		System.out.print(node.getName()+" ");
		for(GraphNode neighbor: node.getNeighbours()) {
			if(!neighbor.isVisited()) {
				dfs(neighbor);
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
				
		for(int i=0;i<10; i++) {
			nodeList.add(new GraphNode("V"+i));
		}
		
		DFSAdjListRecursive graph = new DFSAdjListRecursive(nodeList);
		
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
