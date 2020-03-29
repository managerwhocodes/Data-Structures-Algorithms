package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public TopologicalSort(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	void topologicalSort() {
		Stack<GraphNode>stack = new Stack<GraphNode>();
		for (GraphNode node : nodeList) {
			if (!node.isVisited())
				topologicalVisit(node,stack);
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getName()+" ");
		}
	}
	
	void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for (GraphNode neighbor : node.getNeighbours()){
			if(!neighbor.isVisited()){
				topologicalVisit(neighbor,stack);
			}
		}
		node.setVisited(true);
		stack.push(node);
	} 
	
	public void addDirectedEdge(int i, int j) {
		GraphNode source = nodeList.get(i);
		GraphNode destination = nodeList.get(j);
		source.getNeighbours().add(destination);
	}	
	
	public static void main(String[] args) {
		
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
		
		for(int i=0;i<10; i++) {
			nodeList.add(new GraphNode("V"+i));
		}
		
		TopologicalSort graph = new TopologicalSort(nodeList);
		
        graph.addDirectedEdge(0,1);
		graph.addDirectedEdge(0,3);
		graph.addDirectedEdge(1,2);
		graph.addDirectedEdge(1,4);
		graph.addDirectedEdge(2,5);
		graph.addDirectedEdge(2,9);
		graph.addDirectedEdge(3,6);
		graph.addDirectedEdge(4,7);
		graph.addDirectedEdge(5,8);
		graph.addDirectedEdge(6,7);
		graph.addDirectedEdge(7,8);
		graph.addDirectedEdge(8,9);
		
		System.out.println("Printing Topological Sort from source: ");
		graph.topologicalSort();
	}
}