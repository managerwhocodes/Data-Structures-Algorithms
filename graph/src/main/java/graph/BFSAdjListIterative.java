package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAdjListIterative {

	private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public BFSAdjListIterative(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
		
	private void bfs(GraphNode node) {
		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
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
	
	private boolean isCycle(GraphNode node) {
		
		LinkedList<GraphNode>queue = new LinkedList<GraphNode>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.poll();
			presentNode.setVisited(true);
						
			for(GraphNode neighbor: presentNode.getNeighbours()) { 
				if(!neighbor.isVisited()) {
					neighbor.setVisited(true);
					queue.add(neighbor);
					neighbor.setParent(presentNode);
				} else if(presentNode.getParent()!= null && presentNode.getParent().getName() != neighbor.getName()) {
					return true;
				}
			}
		}
		return false;
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
				
		BFSAdjListIterative graph = new BFSAdjListIterative(nodeList);
				
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
		System.out.println("Printing BFS from source : "+nodeList.get(0).getName());
		graph.bfs(nodeList.get(0));
		
		
		
		ArrayList<GraphNode> nodeListTwo = new ArrayList<GraphNode>();
		
		for(int i=0;i<10; i++) {
			nodeListTwo.add(new GraphNode("V"+i));
		}
		
		BFSAdjListIterative graphTwo = new BFSAdjListIterative(nodeListTwo);
		
		graphTwo.addUndirectedEdge(0,1);
		graphTwo.addUndirectedEdge(0,3);
		graphTwo.addUndirectedEdge(1,2);
		graphTwo.addUndirectedEdge(1,4);
		graphTwo.addUndirectedEdge(2,5);
		graphTwo.addUndirectedEdge(2,9);
		graphTwo.addUndirectedEdge(3,6);
		graphTwo.addUndirectedEdge(4,7);
		graphTwo.addUndirectedEdge(5,8);
		//graphTwo.addUndirectedEdge(6,7);
		//graphTwo.addUndirectedEdge(7,8);
		graphTwo.addUndirectedEdge(8,9);

		System.out.println("\nIs there any cycle in the graph : "+graphTwo.isCycle(nodeListTwo.get(0)));

	}	
}
