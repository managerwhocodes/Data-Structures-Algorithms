package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	protected void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex - 1), nodeList.get(secondIndex - 1), weight);
		WeightedNode first = edge.getFirst();
		WeightedNode second = edge.getSecond();
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
		first.getWeightMap().put(second, weight);
		second.getWeightMap().put(first, weight);
		edgeList.add(edge);
	}


	public static void main(String[] args) {
		
		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		
		//create 10 nodes: v1-v10
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode(""+(char)(65+i)));
		}
		
		MinimumSpanningTree graph = new MinimumSpanningTree(nodeList);
		
		graph.addWeightedUndirectedEdge(1,2,10);
		graph.addWeightedUndirectedEdge(1,3,20);
		graph.addWeightedUndirectedEdge(2,3,30);		
		graph.addWeightedUndirectedEdge(2,4,5);		
		graph.addWeightedUndirectedEdge(3,4,15);
		graph.addWeightedUndirectedEdge(3,5,6);		
		graph.addWeightedUndirectedEdge(4,5,8);
		
		System.out.println("Finding MST using Kruskal's Algo on the graph: ");
		graph.findMSTKruskal();

	}
}
