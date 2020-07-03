package graph;

import java.util.ArrayList;

public class FindPathFloydWarshall {
	
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	
	public FindPathFloydWarshall(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	protected void findPath() {
		
		int size = nodeList.size();
		int[][] V = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			WeightedNode first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				WeightedNode second = nodeList.get(j);
				if (i == j)
					V[i][j] = 0;
				else if (first.getWeightMap().containsKey(second)) {
					V[i][j] = first.getWeightMap().get(second);
				} else {
					V[i][j] = Integer.MAX_VALUE/10;
				}
			}
		}

		for (int k = 0; k < nodeList.size(); k++) {
			for (int i = 0; i < nodeList.size(); i++) {
				for (int j = 0; j < nodeList.size(); j++) {
					if (V[i][j] > V[i][k] + V[k][j]) {
						V[i][j] = V[i][k] + V[k][j];    
					}
				}
			}
		}
		
		for (int i = 0; i < size; i++) {
			System.out.print("Distance list for node "+nodeList.get(i)+": ");
			for (int j = 0; j < size; j++) {
				System.out.print(V[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	protected void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i - 1);
		WeightedNode second = nodeList.get(j - 1);
		first.getNeighbours().add(second);
		first.getWeightMap().put(second, d);
	}

	public static void main(String[] args) {
		
		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		
		//Create 4 Vertices: A,B,C,D
		for (int i = 0; i < 4; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		FindPathFloydWarshall graph = new FindPathFloydWarshall(nodeList);
		graph.addWeightedEdge(1, 4, 1);// Add A-> D , weight 1
		graph.addWeightedEdge(1, 2, 8);// Add A-> B , weight 8
		graph.addWeightedEdge(2, 3, 1);// Add B-> C , weight 1
		graph.addWeightedEdge(3, 1, 4);// Add C-> A , weight 4
		graph.addWeightedEdge(4, 2, 2);// Add D-> B , weight 2
		graph.addWeightedEdge(4, 3, 9);// Add D-> C , weight 9

		System.out.println("All pair shortest path : ");
		graph.findPath();

	}

}
