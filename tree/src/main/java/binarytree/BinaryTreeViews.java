package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeViews extends BinaryTree{
	
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
		
	}
}