package binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


class Pair<U,V>{
	
	public final U first;
	public final V second; 
	
	Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}
}

public class BinaryTreeViews extends BinaryTree{
	
	protected void topView(Node node) {
		
		Map<Integer,Pair<Integer,Integer>> map = new TreeMap<Integer, Pair<Integer, Integer>>();
		
		topView(node,0,0,map);
		
		for(Pair<Integer,Integer> p : map.values()) {
			System.out.print(p.first+" ");
		}
	}
	
	protected void topView(Node node, int dist, int level, Map<Integer,Pair<Integer,Integer>> map) {
		
		if(node == null)
			return;
		
		if(!map.containsKey(dist)  || level < map.get(dist).second) {
			map.put(dist, new Pair(node.getValue(),level));
		}
		
		topView(node.getLeftNode(), dist-1, level+1, map);
		topView(node.getRightNode(), dist+1, level+1, map);
	}
	
	protected void bottomView(Node node) {
		
		Map<Integer,Pair<Integer,Integer>> map = new TreeMap<Integer, Pair<Integer, Integer>>();
		
		bottomView(node,0,0,map);
		
		for(Pair<Integer,Integer> p : map.values()) {
			System.out.print(p.first+" ");
		}
	}
	
	protected void bottomView(Node node, int dist, int level, Map<Integer,Pair<Integer,Integer>> map) {
		
		if(node == null)
			return;
		
		if(!map.containsKey(dist)  || level >= map.get(dist).second) {
			map.put(dist, new Pair(node.getValue(),level));
		}
		
		bottomView(node.getLeftNode(), dist-1, level+1, map);
		bottomView(node.getRightNode(), dist+1, level+1, map);
	}
		
	protected void leftView(Node node) {

		if(node == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
				
		while(!queue.isEmpty()){
			int queueSize = queue.size();
			int index = 0;
			
			while(index++ < queueSize) {
				Node currentNode = queue.poll();
				
				if(index==1) {
					System.out.print(currentNode.getValue()+" ");
				}
				
				if(currentNode.getLeftNode() != null)
					queue.add(currentNode.getLeftNode());
					
				if(currentNode.getRightNode() != null)
					queue.add(currentNode.getRightNode());							
			}
		}
	}
	
	protected void rightView(Node node) {

		if(node == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
				
		while(!queue.isEmpty()){
			int queueSize = queue.size();
			int index = 0;
			
			while(index++ < queueSize) {
				Node currentNode = queue.poll();
				
				if(index==queueSize) {
					System.out.print(currentNode.getValue()+" ");
				}
				
				if(currentNode.getLeftNode() != null)
					queue.add(currentNode.getLeftNode());
					
				if(currentNode.getRightNode() != null)
					queue.add(currentNode.getRightNode());							
			}
		}
	}
		
	public static void main(String args[]){
		BinaryTreeViews tree = new BinaryTreeViews();
		
		for(int i=0;i<16;i++) {
			tree.insert(new Node(i));
		}
			
		System.out.print("Left view of the tree : ");
		tree.leftView(tree.getRoot());
		System.out.println("\n");
		
		System.out.print("Right view of the tree : ");
		tree.rightView(tree.getRoot());
		System.out.println("\n");
		
		System.out.print("Top view of the tree : ");
		tree.topView(tree.getRoot());
		System.out.println("\n");
		
		System.out.print("Bottom view of the tree : ");
		tree.bottomView(tree.getRoot());
		System.out.println("\n");
		
	}
}