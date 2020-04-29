package binarytree;

import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree{
	
	private Node root;
	
	BinaryTree(){
		this.root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	protected void insert(Node node) {
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
	
	protected List<Node> getLeafNodes(){
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
	
	protected int size(Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + size(node.getLeftNode()) + size(node.getRightNode());
	}
	
	protected void levelOrderTraversal() {
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
	
	protected void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeftNode());
		preOrder(node.getRightNode());
	}
		
	protected void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.getLeftNode());
		postOrder(node.getRightNode());
		System.out.print(node.getValue() + " ");
	}

	protected void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeftNode());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRightNode());
	}
	
	protected void preOrderIterative(Node node)
	{
		if (node == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.push(node);

		while (!stack.empty())
		{
			Node currentNode = stack.pop();

			System.out.print(currentNode.getValue() + " ");

			if (currentNode.getRightNode() != null) {
				stack.push(currentNode.getRightNode());
			}

			if (currentNode.getLeftNode() != null) {
				stack.push(currentNode.getLeftNode());
			}
		}
	}
	
	protected void postOrderIterative(Node node)
	{
		if (node == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		Stack<Integer> result = new Stack<Integer>();

		while (!stack.empty())
		{
			Node currentNode = stack.pop();
			result.push(currentNode.getValue());

			if (currentNode.getLeftNode() != null) {
				stack.push(currentNode.getLeftNode());
			}

			if (currentNode.getRightNode() != null) {
				stack.push(currentNode.getRightNode());
			}
		}

		while (!result.empty()) {
			System.out.print(result.pop() + " ");
		}
	}

	protected void inOrderIterative(Node node)
	{	
		if (node == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		Node currentNode = node;

		while (!stack.empty() || currentNode != null)
		{
			if (currentNode != null)
			{
				stack.push(currentNode);
				currentNode = currentNode.getLeftNode();
			}
			else
			{
				currentNode = stack.pop();
				System.out.print(currentNode.getValue() + " ");
				currentNode = currentNode.getRightNode();
			}
		}
	}
		
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		
		for(int i=0;i<10;i++) {
			tree.insert(new Node(i));
		}
		
		System.out.println("Size of tree : "+tree.size(tree.getRoot()));
		
		System.out.println("Level-order traversal of tree : ");
		tree.levelOrderTraversal();
		
		System.out.println("Leaf Nodes : "+tree.getLeafNodes()+"\n");
		
		System.out.print("Pre-order traversal of tree recursive : ");
		tree.preOrder(tree.root);
		System.out.println("\n");
		
		System.out.print("Pre-order traversal of tree iterative : ");
		tree.preOrderIterative(tree.root);
		System.out.println("\n");
		
		System.out.print("Post-order traversal of tree recursive : ");
		tree.postOrder(tree.root);
		System.out.println("\n");
		
		System.out.print("Post-order traversal of tree iterative : ");
		tree.postOrderIterative(tree.root);
		System.out.println("\n");
			
		System.out.print("In-order traversal of tree recursive : ");
		tree.inOrder(tree.root);
		System.out.println("\n");
		
		System.out.print("In-order traversal of tree iterative : ");
		tree.inOrderIterative(tree.root);
		System.out.println("\n");
	}
}