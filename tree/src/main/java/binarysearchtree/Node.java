package binarysearchtree;

public class Node{
	private int data;
	private Node leftNode;
	private Node rightNode;
	
	Node(){
		this.leftNode = null;
		this.rightNode = null;
	}
	
	Node(int data){
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
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
		return data + "";	
	}
}
