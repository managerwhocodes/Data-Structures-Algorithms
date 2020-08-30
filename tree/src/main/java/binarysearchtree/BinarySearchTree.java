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
		
		if(isEmpty()) {
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
	
	protected void insertRecursive(Node node) {
		
		root = insertRecursiveUtil(this.root, node);	
	}
	
	protected Node insertRecursiveUtil(Node currentNode, Node node) {
		
		if (currentNode == null) {
			return node;
		}
		
		if (node.getData() < currentNode.getData()) {
			
			currentNode.setLeftNode(insertRecursiveUtil(currentNode.getLeftNode(), node));
			
		} else if(node.getData() > currentNode.getData()) {
			
			currentNode.setRightNode(insertRecursiveUtil(currentNode.getRightNode(), node));
			
		} else {
			return currentNode;
		}

		return currentNode;
	}
	
	protected Node searchRecursive(int data) {
		
		if(isEmpty())
			return null;
		
		return(searchRecursiveUtil(root, data));
		
	}
	
	protected Node searchRecursiveUtil(Node currentNode, int data) {
		
		if(currentNode == null || currentNode.getData() == data) {
			return currentNode;
		}
		
		if(currentNode.getData() > data) {
			return searchRecursiveUtil(currentNode.getLeftNode(), data);
		} else {
			return searchRecursiveUtil(currentNode.getRightNode(), data);
		}
		
	}
	
	protected void delete(Node currentNode, int data) {
		
		if(isEmpty())
			return;
		
		Node parentNode = null;
		while(currentNode !=null && (currentNode.getData() != data)) {
			parentNode = currentNode;
			if(currentNode.getData() > data) {
				currentNode = currentNode.getLeftNode();
			} else {
				currentNode = currentNode.getRightNode();
			}
				
		}
		
		// Node not found
		if(currentNode == null)
			return;
		
		// check if it is the root node
		if(root.getData() == currentNode.getData()) {
			setRoot(null);
			return;
		}
		
		// Leaf Node
		if(currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
			
			if(currentNode.getData() < parentNode.getData()) {
				parentNode.setLeftNode(null);
				return;
			} else {
				parentNode.setRightNode(null);
				return;
			}
		} else if(currentNode.getRightNode() == null) {
		
			if(currentNode.getData() < parentNode.getData()){
                parentNode.setLeftNode(currentNode.getLeftNode());
                return;
            }
            else {
                parentNode.setRightNode(currentNode.getLeftNode());
                return;
            }
		} else if(currentNode.getLeftNode() == null) {
            
            if(currentNode.getData() < parentNode.getData()){
            	parentNode.setLeftNode(currentNode.getRightNode());
                return;
            }
            else{
            	parentNode.setRightNode(currentNode.getRightNode());
                return;
            }

        } else {
        	Node leastNode = findLeastNode(currentNode.getRightNode());
        	int temp = leastNode.getData();
        	
            delete(root, temp);
            
            currentNode.setData(temp);
            return;
        }
	}
	
	private Node findLeastNode(Node currentNode) {

		Node temp = currentNode;

		while (temp.getLeftNode() != null) {
			temp = temp.getLeftNode();
		}

		return temp;

	}
		
	protected boolean isEmpty() {
		return root == null;
	}
	
	protected int size(Node node) {
		if(node == null) 
			return 0;
		
		return 1 + size(node.getLeftNode()) + size(node.getRightNode());
	}
	
	protected int height(Node node) {
		if(node == null)
			return -1;
		
		return 1 + Math.max(height(node.getLeftNode()), height(node.getRightNode()));
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
		
		bst.insertRecursive(new Node(11));
		
		bst.printTree(bst.getRoot());
		
		Node temp = bst.searchRecursive(5);
		if (temp != null) {
			System.out.println("\nNode with data : " + temp.getData() + " found in BST");
		}
		else 
			System.out.println("\nNot found in BST");
		
	}

}
