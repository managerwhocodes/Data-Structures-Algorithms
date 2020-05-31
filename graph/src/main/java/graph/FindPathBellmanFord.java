package graph;

import java.util.ArrayList;

public class FindPathBellmanFord {

	private ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	

	public FindPathBellmanFord(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
		for(WeightedNode node: nodeList){
			node.setDistance(Integer.MAX_VALUE/10);
		}
	}
	
	private void pathFind(WeightedNode sourceNode) {
		sourceNode.setDistance(0);
		
		for (int i = 1; i < nodeList.size(); i++) {
			for (WeightedNode presentNode : nodeList) {
				for (WeightedNode neighbor : presentNode.getNeighbours()) {
					if (neighbor.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor))) {
						neighbor.setDistance((presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)));
						neighbor.setParent(presentNode);
					}
				}
			}
		}
		
		System.out.println("Checking for Negative Cycle... ");
		for(WeightedNode presentNode: nodeList) {
			for(WeightedNode neighbor: presentNode.getNeighbours()) {
				if(neighbor.getDistance() > (presentNode.getDistance()+presentNode.getWeightMap().get(neighbor))) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex Name: " + neighbor.getName());
					System.out.println("Old Distance: " + neighbor.getDistance());
					int newDistance = presentNode.getDistance()+presentNode.getWeightMap().get(neighbor);
					System.out.println("New distance: " + newDistance);
					return;
				}
			}
		}
		System.out.println("Negative cycle not found !\n");
		
		for (WeightedNode nodeToCheck : nodeList) {
			if (nodeToCheck.getDistance() != Integer.MAX_VALUE / 10) {
				System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.getDistance() + ", Path: ");
				pathPrint(nodeToCheck);
			} else {
				System.out.print("No path for node " + nodeToCheck);
			}
			System.out.println();
		}
	}
	

	private void pathPrint(WeightedNode node) {
		if(node.getParent()!=null) {
			pathPrint(node.getParent());
			System.out.print("->"+node);
		}
		else 
			System.out.print(node);
	}
	

	private void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i-1);
		WeightedNode second = nodeList.get(j-1);
		first.getNeighbours().add(second);
		first.getWeightMap().put(second,d);
	}

	public static void main(String[] args) {
		
		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode(""+(char)(65+i)));
		}
		
		FindPathBellmanFord graph = new FindPathBellmanFord(nodeList);
		
		graph.addWeightedEdge(1,3,6); //Add A-> C , weight 6
		graph.addWeightedEdge(2,1,3); //Add B-> A , weight 3
		graph.addWeightedEdge(1,4,6); //Add A-> D , weight 6
		//graph.addWeightedEdge(1,4,-6); //Add A-> D , weight -6
		graph.addWeightedEdge(4,3,1); //Add D-> C , weight 1
		graph.addWeightedEdge(3,4,2); //Add C-> D , weight 2
		graph.addWeightedEdge(4,2,1); //Add D-> B , weight 1
		graph.addWeightedEdge(5,4,2); //Add E-> D , weight 2
		graph.addWeightedEdge(5,2,4); //Add E-> B , weight 4
		
		graph.pathFind(nodeList.get(4));

	}
}
