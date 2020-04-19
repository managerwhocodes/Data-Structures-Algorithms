package linkedlist;

public class SingleLinkedListReverseK extends SingleLinkedList{

    protected void reverse(int k){   	
    	head = reverseUtil(head, k); 
    }
    
    protected Node reverseUtil(Node node, int k){
    	
    	if(node == null) {
    		return null;
    	}
       
    	Node currentNode = node;
        Node previousNode = null;

        for(int i =0; i < k && currentNode !=null; i++) {
        	Node nextNode = currentNode.getNext();	
        	currentNode.setNext(previousNode);
        	previousNode = currentNode;
        	currentNode = nextNode;
        }

        node.setNext(reverseUtil(currentNode, k));
          
        return previousNode;
    }

    public static void main(String[] args) {
    	
    	int group = 3;
    	
        SingleLinkedListReverseK list = new SingleLinkedListReverseK();
        list.createLinkedList(new Node(1));
        list.insertNodeAtEnd(new Node(2));
        list.insertNodeAtEnd(new Node(3));
        list.insertNodeAtEnd(new Node(4));
        list.insertNodeAtEnd(new Node(5));
        list.insertNodeAtEnd(new Node(6));
        list.insertNodeAtEnd(new Node(7));

        System.out.print("Original List : ");
        list.traverseLinkedList();
        System.out.println();
        
        list.reverse(group);
        System.out.print("Reversed List : ");
        list.traverseLinkedList();
    }
}
