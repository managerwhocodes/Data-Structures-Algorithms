package binarytree;


public class BinaryTreeIdentical extends BinaryTree{
	
	protected boolean isIdentical(Node nodeOne, Node nodeTwo)
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
		
		BinaryTree treeOne = new BinaryTree();
		BinaryTree treeTwo = new BinaryTree();
		BinaryTreeIdentical binaryTreeIdentical = new BinaryTreeIdentical();
		
		for(int i=0;i<10;i++) {
			treeOne.insert(new Node(i));
		}
		
		for(int i=0;i<10;i++) {
			treeTwo.insert(new Node(i));
		}
		
		boolean isIdentical = binaryTreeIdentical.isIdentical(treeOne.getRoot(), treeTwo.getRoot());
		System.out.println("Is Tree one and Tree two identical : "+isIdentical);

	}
}