package graph;

import java.util.ArrayList;
import java.util.Stack;

class Graph{
	
	private ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	private ArrayList<Edge> edgeList = new ArrayList<Edge>();
	
	public ArrayList<GraphNode> getNodeList() {
		return nodeList;
	}
	
	public ArrayList<Edge> getEdgeList() {
		return edgeList;
	}
	
	public Graph(ArrayList<Edge> edgeList, ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		this.edgeList = edgeList;
		for (Edge edge: edgeList) {
			GraphNode source = nodeList.get(edge.getFirst().getIndex());
			GraphNode destination = nodeList.get(edge.getSecond().getIndex());
			source.getNeighbours().add(destination);
		}
	}
}

public class GraphUtil {
		
	private void dfs(GraphNode node) {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(node);
		
		while(!stack.isEmpty()) {
			GraphNode currentNode = stack.pop();
			currentNode.setVisited(true);
			
			for(GraphNode neighbour : currentNode.getNeighbours()) {
				if(!neighbour.isVisited()) {
					stack.push(neighbour);
					neighbour.setVisited(true);
				}
			}
		}
	}
	
	private boolean isStronglyConnected(Graph graph) {
		
		// dfs on original graph
		dfs(graph.getNodeList().get(0));
		
		// check if all nodes are visited
		for(GraphNode current : graph.getNodeList()) {
			if(!current.isVisited()) {
				return false;
			}
		}
		
		// set all nodes to unvisited
		for(GraphNode current : graph.getNodeList()) {
			current.setVisited(true);
		}
		
		ArrayList<GraphNode> newNodeList = graph.getNodeList();
		ArrayList<Edge> edgeListReverse = new ArrayList<Edge>();

		// reverse all the edges
		for (Edge e : graph.getEdgeList()) {
			edgeListReverse.add(new Edge(e.getSecond(), e.getFirst()));
		}

		// Create a graph from reversed edges
		Graph graphTwo = new Graph(edgeListReverse, newNodeList);
		
		// dfs on reversed graph
		dfs(graphTwo.getNodeList().get(0));
		
		// check if all nodes are visited
		for(GraphNode current : graph.getNodeList()) {
			if(!current.isVisited()) {
				return false;
			}
		}
		
		// return true if all above conditions are passed
		return true;	
	}

	public static void main(String[] args) {
		
		GraphUtil gu = new GraphUtil();
		
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
				
		for(int i=0;i<5;i++) {
			nodeList.add(new GraphNode("V"+i,i));
		}
			
		edgeList.add(new Edge(nodeList.get(0), nodeList.get(4)));
		edgeList.add(new Edge(nodeList.get(1), nodeList.get(0)));
		edgeList.add(new Edge(nodeList.get(1), nodeList.get(2)));
		edgeList.add(new Edge(nodeList.get(2), nodeList.get(1)));
		edgeList.add(new Edge(nodeList.get(2), nodeList.get(4)));
		edgeList.add(new Edge(nodeList.get(3), nodeList.get(1)));
		edgeList.add(new Edge(nodeList.get(3), nodeList.get(2)));
		edgeList.add(new Edge(nodeList.get(4), nodeList.get(3)));
		
		Graph graphOne = new Graph(edgeList, nodeList);	
		
		if (gu.isStronglyConnected(graphOne))
			System.out.println("Graph is Strongly Connected");
		else
			System.out.println("Graph is not Strongly Connected");
	
	}
}
