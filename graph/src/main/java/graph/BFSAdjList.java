package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSAdjList {

	private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	private BFSAdjList(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
		
	private void bfs(GraphNode node) {
		
		LinkedList<GraphNode>queue = new LinkedList<GraphNode>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.poll();
			presentNode.setVisited(true);
			
			System.out.print(presentNode.getName()+" ");
			
			for(GraphNode neighbor: presentNode.getNeighbours()) { 
				if(!neighbor.isVisited()) {
					queue.add(neighbor);
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
				
		for(int i=0;i<10; i++) {
			nodeList.add(new GraphNode("V"+i));
		}
				
		BFSAdjList graph = new BFSAdjList(nodeList);
				
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
				
		// Change this to start BFS from another source
		System.out.println("Printing BFS from source: "+nodeList.get(0).getName());
		graph.bfs(nodeList.get(0));
	}	
}
