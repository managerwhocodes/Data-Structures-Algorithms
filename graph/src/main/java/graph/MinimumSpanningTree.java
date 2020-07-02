package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
	
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	ArrayList<UndirectedEdge> edgeList = new ArrayList<UndirectedEdge>();
	
	public MinimumSpanningTree(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	protected void findMSTKruskal() {

		DisjointSet ds  = new DisjointSet();
		
		ds.makeSet(nodeList);
		
		Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
			public int compare(UndirectedEdge o1, UndirectedEdge o2) {
				return o1.getWeight() - o2.getWeight();
			}
		};
		Collections.sort(edgeList, comparator);

		int cost = 0;
		for (UndirectedEdge edge : edgeList) {
			WeightedNode first = edge.getFirst();
			WeightedNode second = edge.getSecond();
			if (!ds.findSet(first).equals(ds.findSet(second))) {
				ds.union(first, second);
				cost += edge.getWeight();
				System.out.println("Taken " + edge);
			}
		}

		System.out.println("\nTotal cost of MST : " + cost);
	}
	

	protected void findMSTPrim(WeightedNode node) {
		
	  for (int counter = 0; counter < nodeList.size(); counter++) { 		      
	      nodeList.get(counter).setDistance(Integer.MAX_VALUE); 		
	  } 
	  node.setDistance(0);
	  
	  PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		
	  queue.addAll(nodeList);
	  while (!queue.isEmpty()) {
		  WeightedNode presentNode = queue.remove(); // Remove vertex which has min distance
				
		  for (WeightedNode neighbor : presentNode.getNeighbours()) {
			  if (queue.contains(neighbor)) {
				  if (neighbor.getDistance() > presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
						queue.remove(neighbor);
						queue.add(neighbor);
				  }
			  }
		  }
	  }
		
	  int cost = 0;

	  for (WeightedNode nodeToCheck : nodeList) {
		  System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.getDistance() + ", Parent: " + nodeToCheck.getParent());
		  cost = cost + nodeToCheck.getDistance();
	  }
		
	  System.out.println("\nTotal cost of MST: " + cost);
	}
	
	protected void addWeightedUndirectedEdgeForKruskal(int firstIndex, int secondIndex, int weight) {
		UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex - 1), nodeList.get(secondIndex - 1), weight);
		WeightedNode first = edge.getFirst();
		WeightedNode second = edge.getSecond();
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
		first.getWeightMap().put(second, weight);
		second.getWeightMap().put(first, weight);
		edgeList.add(edge);
	}
	
	public void addWeightedUndirectedEdgeForPrim(int firstIndex, int secondIndex, int weight) {
		WeightedNode first = nodeList.get(firstIndex-1);
		WeightedNode second = nodeList.get(secondIndex-1);
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
		first.getWeightMap().put(second,weight);
		second.getWeightMap().put(first, weight);
	}


	public static void main(String[] args) {
		
		ArrayList<WeightedNode> nodeListOne = new ArrayList<WeightedNode>();
		
		//Create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			nodeListOne.add(new WeightedNode(""+(char)(65+i)));
		}
		
		MinimumSpanningTree graphOne = new MinimumSpanningTree(nodeListOne);
		
		graphOne.addWeightedUndirectedEdgeForKruskal(1,2,10);
		graphOne.addWeightedUndirectedEdgeForKruskal(1,3,20);
		graphOne.addWeightedUndirectedEdgeForKruskal(2,3,30);		
		graphOne.addWeightedUndirectedEdgeForKruskal(2,4,5);		
		graphOne.addWeightedUndirectedEdgeForKruskal(3,4,15);
		graphOne.addWeightedUndirectedEdgeForKruskal(3,5,6);		
		graphOne.addWeightedUndirectedEdgeForKruskal(4,5,8);
		
		System.out.println("Finding MST using Kruskal's Algo on the graph : ");
		graphOne.findMSTKruskal();
		
		
		ArrayList<WeightedNode> nodeListTwo = new ArrayList<WeightedNode>();
		
		//Create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			nodeListTwo.add(new WeightedNode(""+(char)(65+i)));
		}
		
		MinimumSpanningTree graphTwo = new MinimumSpanningTree(nodeListTwo);
		
		graphTwo.addWeightedUndirectedEdgeForPrim(1,2,10); //Add undirected Edge between A-B with Weight 10
		graphTwo.addWeightedUndirectedEdgeForPrim(1,3,20); //Add undirected Edge between A-C with Weight 20
		graphTwo.addWeightedUndirectedEdgeForPrim(2,3,30); //Add undirected Edge between B-C with Weight 30
		graphTwo.addWeightedUndirectedEdgeForPrim(2,4,5);  //Add undirected Edge between B-D with Weight 5
		graphTwo.addWeightedUndirectedEdgeForPrim(3,4,15); //Add undirected Edge between C-D with Weight 15
		graphTwo.addWeightedUndirectedEdgeForPrim(3,5,6);  //Add undirected Edge between C-E with Weight 6
		graphTwo.addWeightedUndirectedEdgeForPrim(4,5,8);  //Add undirected Edge between D-E with Weight 8
		
		System.out.println("\nFinding MST using Prim's Algo on the graph from source node E : ");
		graphTwo.findMSTPrim(nodeListTwo.get(4));

	}
}
