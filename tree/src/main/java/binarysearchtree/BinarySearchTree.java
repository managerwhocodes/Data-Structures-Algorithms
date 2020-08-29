package binarysearchtree;


public class BinarySearchTree {
	
	private Node root;
	
	BinarySearchTree(){
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
		
		Node currentNode = root;
		
		while(currentNode != null) {
			Node leftChild = currentNode.getLeftNode();
			Node rightChild = currentNode.getRightNode();
			
			if(currentNode.getData() > node.getData()) {
				if(leftChild == null) {
					currentNode.setLeftNode(node);
					break;
				}
				currentNode = leftChild;
			} else {
				if(rightChild == null) {
					currentNode.setRightNode(node);
					break;
				}
				currentNode = rightChild;
			}	
		}
	}
	
	protected void printTree(Node current) {
		
		if (current == null) return;

		System.out.print(current.getData() + ",");
		printTree(current.getLeftNode());
		printTree(current.getRightNode());

	}

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(new Node(6));
		bst.insert(new Node(4));
		bst.insert(new Node(9));
		bst.insert(new Node(5));
		bst.insert(new Node(2));
		bst.insert(new Node(8));
		bst.insert(new Node(12));
		bst.insert(new Node(10));
		bst.insert(new Node(14));
		
		bst.printTree(bst.getRoot());
	}

}
