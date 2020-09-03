package binarytree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree{
	
	ArrayList<ListNode> al = new ArrayList<ListNode>();
	
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
	
	protected List<Node> getLeafNodes()	{
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
		if(node == null) 
			return 0;
		
		return 1 + size(node.getLeftNode()) + size(node.getRightNode());
	}
	
	
	protected int height(Node node)	{ 
        if (node == null) 
            return 0; 
  
        return 1 + Math.max(height(node.getLeftNode()), height(node.getRightNode())); 
    } 
	
	protected boolean checkBalanced(Node root) {
		int result = checkBalancedUtil(root);
		if(result > 0)
			return true;
		else
			return false;
	}
	
	protected int checkBalancedUtil(Node root) {		
		if(root == null)
			return 0;
		
		int leftHeight = checkBalancedUtil(root.getLeftNode());
		if(leftHeight == -1)
			return leftHeight;
		
		int rightHeight = checkBalancedUtil(root.getRightNode());
		if(rightHeight == -1)
			return rightHeight;
		
		if(Math.abs(leftHeight - rightHeight)>1)
			return -1;
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	protected boolean isBalanced() {
		AtomicBoolean isBalanced =  new AtomicBoolean(true);
		isBalancedUtil(root, isBalanced);

		return isBalanced.get();
	}

	protected int isBalancedUtil(Node node, AtomicBoolean isBalanced)	{ 
        if (node == null || !isBalanced.get()) 
            return 0; 
  
        int leftHeight = isBalancedUtil(node.getLeftNode(), isBalanced);
        int rightHeight = isBalancedUtil(node.getRightNode(), isBalanced);
        
        if(Math.abs(leftHeight - rightHeight) > 1)
        	isBalanced.set(false);
        
        return Math.max(leftHeight, rightHeight) + 1;
    } 
	
	protected boolean isComplete(Node node, int index, int size) {
		if(node == null)
			return true;
		
		if((node.getLeftNode() != null && 2*index + 1 >= size) || !isComplete(node.getLeftNode(), 2*index + 1, size)){
			return false;
		}
		
		if((node.getRightNode() != null && 2*index + 2 >= size) || !isComplete(node.getRightNode(), 2*index + 2, size)){
			return false;
		}
		return true;
	}
	
	protected void levelOrderTraversal() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node currentNode = queue.poll();
			System.out.print(currentNode.getValue()+ " ");
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
	
	protected void preOrderIterative(Node node)	{
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
	
	protected void postOrderIterative(Node node) {
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

	protected void inOrderIterative(Node node) {	
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
	
	protected boolean printAncestors(Node root, int nodeValue) {
		
		if(root == null)
			return false;
		
		if(root.getValue() == nodeValue)
			return true;
		
		boolean left = printAncestors(root.getLeftNode(), nodeValue);
		
		boolean right = false;
		if(!left)
			right = printAncestors(root.getRightNode(), nodeValue);
		
		if(left || right)
			System.out.print(root.getValue() + " ");
		
		return left || right;
		
	}
	
	protected void listAtDepth(Node root){
 		Queue<Node> q = new LinkedList<Node>();
 		int levelNodes =0;
 		if(root==null) return;
 		q.add(root);
 		while(!q.isEmpty()){
			levelNodes = q.size();
			ListNode head = null;
			ListNode curr = null;
			while(levelNodes>0){
				Node n = q.remove();
				ListNode ln = new ListNode(n.getValue());
				if(head==null){
					head = ln;
					curr = ln;
				} else {
					curr.next = ln;
					curr = curr.next;
				}
				if(n.getLeftNode()!=null) q.add(n.getLeftNode());
				if(n.getRightNode()!=null) q.add(n.getRightNode());
				levelNodes--;
			}
			al.add(head);
		}
		al.get(0).display(al);
	}
	
	protected void printRootToleafPaths(Node node, Queue<Integer> path) {

		if (node == null) {
			return;
		}

		path.add(node.getValue());

		if (isLeaf(node)) {
			System.out.println(path);
		}

		printRootToleafPaths(node.getLeftNode(), path);
		printRootToleafPaths(node.getRightNode(), path);

		path.remove();
	}

	protected void printRootToleafPaths(Node node) {

		Queue<Integer> path = new LinkedList<Integer>();
		printRootToleafPaths(node, path);
	}
	
	protected boolean isLeaf(Node node) {
		return (node.getLeftNode() == null && node.getRightNode() == null);
	}
	
	
	protected int isHeightBalanced(Node root, boolean isBalanced) {

		if (root == null || isBalanced) {
			return 0;
		}

		int left_height = isHeightBalanced(root.getLeftNode(), isBalanced);
		int right_height = isHeightBalanced(root.getRightNode(), isBalanced);

		if (Math.abs(left_height - right_height) > 1) {
			isBalanced = false;
		}

		return Math.max(left_height, right_height) + 1;
	}


	protected boolean isHeightBalanced(Node root) {

		boolean isBalanced =  true;
		isHeightBalanced(root, isBalanced);

		return isBalanced;
	}
	
	protected int findLevel(Node root, Node node, int index, int level) {
		if(root == null || level != 0 )
			return level;
		
		if(root.getValue() == node.getValue())
			level = index;
		
		level = findLevel(root.getLeftNode(), node, index+1, level);
		level = findLevel(root.getRightNode(), node, index+1, level);
					
		return level;
	}
	
	// Print all cousins of a given node
	// Cousins are node at same level with different parents
	protected void printAllCousins(Node node) {
		
		int level = findLevel(root, node, 1, 0);
		printCousins(root, node, level);
	}
	
	protected void printCousins(Node root, Node node, int level) {
		
		if(root==null)
			return;
		
		if(level == 1) {
			System.out.println(root.getValue()+" ");
			return;
		}
		
		if(!(root.getLeftNode() != null && root.getValue() == node.getValue() 
				|| root.getRightNode() != null && root.getValue() == node.getValue())) {
			printCousins(root.getLeftNode(), node, level-1);
			printCousins(root.getRightNode(), node, level-1);
		}
	}
	
	protected boolean isSibling(Node root, Node x, Node y) {
		if(root == null)
			return false;
		
		return ((root.getLeftNode() == x && root.getRightNode() == y)
				|| (root.getLeftNode() == y && root.getRightNode() == x)
				||	isSibling(root.getLeftNode(), x, y)
				||	isSibling(root.getRightNode(), x, y));
	}
	
	protected boolean isCousin(Node x, Node y) {
		int levelx = findLevel(root, x, 1, 0);
		int levely = findLevel(root, y, 1, 0);
		
		return ((levelx == levely) && !isSibling(root, x, y));
	}
	
	
	protected int getDiameter(Node root, AtomicInteger diameter) {

		if (root == null) {
			return 0;
		}

		int leftHeight = getDiameter(root.getLeftNode(), diameter);
		int rightHeight = getDiameter(root.getRightNode(), diameter);

		int maxDiameter = leftHeight + rightHeight + 1;

		diameter.set(Math.max(diameter.get(), maxDiameter));

		// important - return height of subtree rooted at current node
		return Math.max(leftHeight, rightHeight) + 1;
	}

	protected int getDiameter(Node root){
		AtomicInteger diameter = new AtomicInteger(0);
		getDiameter(root, diameter);

		return diameter.get();
	}
	
		
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		
		for(int i=0;i<10;i++) {
			tree.insert(new Node(i));
		}
		
		int size = tree.size(tree.getRoot());
		int height = tree.height(tree.getRoot());
		
		System.out.println("Size of tree : "+size);
		
		System.out.println("Height of tree : "+height);
		
		System.out.println("Is binary tree complete : "+tree.isComplete(tree.getRoot(), 0, size));
		
		System.out.println("\nLeaf Nodes : "+tree.getLeafNodes()+"\n");
		
		System.out.print("Level-order traversal of tree : ");
		tree.levelOrderTraversal();
		System.out.println("\n");
		
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
		
		int nodeValue = 9;
		System.out.print("Ancestors of node with value " +nodeValue+ " : " );
		tree.printAncestors(tree.getRoot(), 9);
		
		System.out.println();
		tree.listAtDepth(tree.getRoot());
		
		System.out.println();
		tree.printRootToleafPaths(tree.getRoot());
		
		System.out.println(tree.isHeightBalanced(tree.getRoot()));
		
		BinaryTree treeOne = new BinaryTree();
		treeOne.setRoot(new Node(1));
		treeOne.getRoot().setRightNode(new Node(2));
		treeOne.getRoot().getRightNode().setLeftNode(new Node(3));
		treeOne.getRoot().getRightNode().setRightNode(new Node(4));
		treeOne.getRoot().getRightNode().getLeftNode().setLeftNode(new Node(5));
		treeOne.getRoot().getRightNode().getLeftNode().setRightNode(new Node(6));
		treeOne.getRoot().getRightNode().getRightNode().setLeftNode(new Node(7));
		treeOne.getRoot().getRightNode().getRightNode().setRightNode(new Node(8));
		
		System.out.println(treeOne.getDiameter(treeOne.getRoot()));
		
		
		BinaryTree treeTwo = new BinaryTree();
		treeTwo.setRoot(new Node(1));
		treeTwo.getRoot().setLeftNode(new Node(2));
		treeTwo.getRoot().setRightNode(new Node(3));
		treeTwo.getRoot().getLeftNode().setLeftNode(new Node(4));
		treeTwo.getRoot().getLeftNode().setRightNode(new Node(5));
		treeTwo.getRoot().getLeftNode().getRightNode().setRightNode(new Node(6));
		//treeTwo.getRoot().getRightNode().setLeftNode(new Node(6));
		//treeTwo.getRoot().getRightNode().setRightNode(new Node(7));

		
		System.out.println(treeTwo.getDiameter(treeTwo.getRoot()));
	}
}