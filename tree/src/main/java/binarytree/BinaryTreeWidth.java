package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeWidth extends BinaryTree{
	
	protected int maximumWidth(Node node) {
		if(node == null)
			return 0;
		
		int max = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			int width = queue.size();
			
			if(max < width)
				max = width;
			
			while(width-- > 0) {
				Node currentNode = queue.poll();
				
				if(currentNode.getLeftNode() != null)
					queue.add(currentNode.getLeftNode());
				
				if(currentNode.getRightNode() != null)
					queue.add(currentNode.getRightNode());			
			}	
		}	
		return max;	
	}
		
	public static void main(String args[]){
		BinaryTreeWidth tree = new BinaryTreeWidth();
		
		for(int i=0;i<10;i++) {
			tree.insert(new Node(i));
		}
		
		int maxWidth = tree.maximumWidth(tree.getRoot());
		System.out.println("Maximum width of tree : "+maxWidth);
		
	}
}