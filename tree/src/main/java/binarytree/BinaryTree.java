package binarytree;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree{
	
	private Node root;
	
	BinaryTree(){
		this.root = null;
	}
	
	private void insert(Node node) {
		if(root == null) {
			root = node;
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			if(currentNode.getLeftNode() == null) {
				currentNode.setLeftNode(node);
				break;
			} else if(currentNode.getRightNode() == null) {
				currentNode.setRightNode(node);
				break;
			} else {
				queue.add(currentNode.getLeftNode());
				queue.add(currentNode.getRightNode());
			}
		}	
	}
	
	private List<Node> getLeafNodes(){
		List<Node> list = new ArrayList<Node>();
 		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node currentNode = queue.poll();
			if(currentNode.getLeftNode() == null && currentNode.getRightNode() == null)
				list.add(currentNode);
			if(currentNode.getLeftNode() !=null)
				queue.add(currentNode.getLeftNode());
			if(currentNode.getRightNode() !=null)
				queue.add(currentNode.getRightNode());	
				
		}
		return list;
	}
	
	private void levelOrderTraversal() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node currentNode = queue.poll();
			System.out.println(currentNode.getValue()+ " ");
			if(currentNode.getLeftNode() != null) 
				queue.add(currentNode.getLeftNode());
			if(currentNode.getRightNode() !=null)
				queue.add(currentNode.getRightNode());		
		}
	}
	
	
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		
		for(int i=0;i<10;i++) {
			tree.insert(new Node(i));
		}
		
		tree.levelOrderTraversal();
		
		System.out.println("Leaf Nodes : "+tree.getLeafNodes());
	}
}