package linkedlist;

public class SingleLinkedListClone extends SingleLinkedList{

    protected Node clone(){
    	Node newHead = null;
    	Node newTail = null;
    	Node current = head;
    	
        if (!existsLinkedList()) {
            System.exit(1);
        }

        while(current != null) {
        	
        	if(newHead == null) {
        		newHead = new Node(current.getData());
        		newTail = newHead;
        	} else {
        		newTail.setNext(new Node(current.getData()));
        		newTail = newTail.getNext();
        	}
        	current = current.getNext();    	
        }  
        return newHead;
    }
    
    protected static void printLinkedList(Node node) {
		if (node == null) {
            return;
        }
		Node tempNode = node;
		while (tempNode !=null) {
			System.out.print(tempNode.getData());
			if (tempNode.getNext()!= null) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.getNext();
		}
	}

    public static void main(String[] args) {
    	SingleLinkedListClone list = new SingleLinkedListClone();
        list.createLinkedList(new Node(1));
        list.insertNodeAtEnd(new Node(2));
        list.insertNodeAtEnd(new Node(3));
        list.insertNodeAtEnd(new Node(4));

        printLinkedList(list.clone());      
    }
}