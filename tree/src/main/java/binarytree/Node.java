package binarytree;

public class Node{
	private int value;
	private int height;
	private Node leftNode;
	private Node rightNode;
	
	Node(){
		this.leftNode = null;
		this.rightNode = null;
	}
	
	Node(int value){
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	@Override
	public String toString() {
		return value + "";	
	}
}
