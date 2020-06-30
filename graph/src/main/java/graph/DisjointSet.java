package graph;

import java.util.ArrayList;

public class DisjointSet {
	
	private ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	
	protected void makeSet(ArrayList<WeightedNode> nodeList) {

		for(WeightedNode node: nodeList) {
			DisjointSet set = new DisjointSet();
			set.getNodes().add(node);
			node.setSet(set);
		}
	}
		
	protected DisjointSet union(WeightedNode node1, WeightedNode node2) {
		if(node1.getSet().equals(node2.getSet())) {
			return null;
		}	
		else {
			DisjointSet set1 = node1.getSet();
			DisjointSet set2 = node2.getSet();
			if(set1.getNodes().size()>set2.getNodes().size()) {
				ArrayList<WeightedNode> nodeSet2 = set2.getNodes();
				for(WeightedNode node: nodeSet2) {
					node.setSet(set1);
					set1.getNodes().add(node);
				}
				return set1;
			}
			else {
				ArrayList<WeightedNode> nodeSet1 = set1.getNodes();
				for(WeightedNode node: nodeSet1) {
					node.setSet(set2);
					set2.getNodes().add(node);
				}
				return set2;
			}
		}
	}
			
	protected DisjointSet findSet(WeightedNode node) {
		return node.getSet();
	}
	
	private ArrayList<WeightedNode> getNodes() {
		return nodeList;
	}		
	
	protected void printAllNodesOfThisSet() {
		System.out.println("Printing all nodes of the set: ");
		for(WeightedNode node: nodeList) {
			System.out.print(node + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		DisjointSet ds = new DisjointSet();
		
		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		
		for (int i = 0; i < 10; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		ds.makeSet(nodeList);

		for(int i= 0; i<nodeList.size()-1; i++) {
			
			WeightedNode firstNode = nodeList.get(i);
			WeightedNode secondNode = nodeList.get(i+1);
			
			System.out.println("Checking if node "+firstNode.getName()+
								" and "+secondNode.getName() +
								" belongs to different set, if yes, will Union them...");
			
			System.out.println("\nFirst Set name is: " + firstNode.getName());			
			firstNode.getSet().printAllNodesOfThisSet();
			
			System.out.println("\nSecond Set name is: " + secondNode.getName());
			secondNode.getSet().printAllNodesOfThisSet();
			
			if(!ds.findSet(firstNode).equals(ds.findSet(secondNode))) {
				System.out.println("\nMaking union "+firstNode+" and "+secondNode );
				DisjointSet unionedSet = ds.union(firstNode, secondNode);
				unionedSet.printAllNodesOfThisSet();
			}
		}
	}
}
