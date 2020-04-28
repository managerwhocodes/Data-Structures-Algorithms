package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeIdentical extends BinaryTree{
	
	protected boolean isIdentical(Node rootOne, Node rootTwo)
	{
		if (rootOne == null && rootOne == null) {
			return true;
		}
		
		if(rootOne == null || rootTwo ==null) {
			return false;
		}
		
		Queue<Node> queueOne = new LinkedList<Node>();
		Queue<Node> queueTwo = new LinkedList<Node>();
		
		queueOne.add(rootOne);
		queueTwo.add(rootTwo);
		
		while (!queueOne.isEmpty() && !queueTwo.isEmpty()){
			Node nodeOne = queueOne.poll();
			Node nodeTwo = queueTwo.poll();
			
			if(nodeOne.getValue() != nodeTwo.getValue())
				return false;
			
			if(nodeOne.getLeftNode() !=null && nodeTwo.getLeftNode() != null){
				queueOne.add(nodeOne.getLeftNode());
				queueTwo.add(nodeTwo.getLeftNode());
			} else if(nodeOne.getLeftNode() !=null || nodeTwo.getLeftNode() != null)
				return false;
			
			if(nodeOne.getRightNode() !=null && nodeTwo.getRightNode() != null){
				queueOne.add(nodeOne.getRightNode());
				queueTwo.add(nodeTwo.getRightNode());
			} else if(nodeOne.getRightNode() !=null || nodeTwo.getRightNode() != null)
				return false;			
	    }
		return true;
	}
	
	protected boolean isIdenticalRecursive(Node nodeOne, Node nodeTwo)
	{
		if (nodeOne == null && nodeOne == null) {
			return true;
		}

		return (nodeOne != null && nodeOne != null) && 
				(nodeOne.getValue() == nodeTwo.getValue()) &&
				isIdentical(nodeOne.getLeftNode(), nodeTwo.getLeftNode()) &&
				isIdentical(nodeOne.getRightNode(), nodeTwo.getRightNode());
	}
	
	public static void main(String args[]){
		
		boolean isIdentical = false;
		BinaryTree treeOne = new BinaryTree();
		BinaryTree treeTwo = new BinaryTree();
		BinaryTree treeThree = new BinaryTree();
		BinaryTree treeFour = new BinaryTree();
		BinaryTreeIdentical binaryTreeIdentical = new BinaryTreeIdentical();
		
		for(int i=0;i<10;i++) {
			treeOne.insert(new Node(i));
		}
		
		for(int i=0;i<10;i++) {
			treeTwo.insert(new Node(i));
		}
		
		for(int i=0;i<9;i++) {
			treeThree.insert(new Node(i));
		}
		
		for(int i=0;i<8;i++) {
			treeFour.insert(new Node(i));
		}
		
		System.out.print("In-order traversal of tree one : ");
		treeOne.inOrderIterative(treeOne.getRoot());
		System.out.println("\n");
		
		System.out.print("In-order traversal of tree two : ");
		treeTwo.inOrderIterative(treeTwo.getRoot());
		System.out.println("\n");
		
		isIdentical = binaryTreeIdentical.isIdenticalRecursive(treeOne.getRoot(), treeTwo.getRoot());
		System.out.println("Is Tree one and Tree two identical using recursion : "+isIdentical);
		
		isIdentical = binaryTreeIdentical.isIdentical(treeOne.getRoot(), treeTwo.getRoot());
		System.out.println("Is Tree one and Tree two identical using iteration : "+isIdentical);
		
		System.out.println();
		System.out.print("In-order traversal of tree three : ");
		treeThree.inOrderIterative(treeThree.getRoot());
		System.out.println("\n");
		
		System.out.print("In-order traversal of tree four : ");
		treeFour.inOrderIterative(treeFour.getRoot());
		System.out.println("\n");

		isIdentical = binaryTreeIdentical.isIdenticalRecursive(treeThree.getRoot(), treeFour.getRoot());
		System.out.println("Is Tree three and Tree four identical using recursion : "+isIdentical);
		
		isIdentical = binaryTreeIdentical.isIdentical(treeThree.getRoot(), treeFour.getRoot());
		System.out.println("Is Tree three and Tree four identical using iteration : "+isIdentical);

	}
}