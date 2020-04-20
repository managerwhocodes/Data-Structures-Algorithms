package linkedlist;

public class SingleLinkedListSplit extends SingleLinkedList{
   
    protected Node[] splitList() {
    	
    	Node frontNode = null, rearNode = null;
    	
    	if(!existsLinkedList())
    		return new Node[] {frontNode, rearNode};
    	    	
    	Node node = null;
    	Node slow = head;
    	Node fast = head;
    	int index = 1;
    	
    	// run two pointers slow and fast to reach the middle of list
    	while(fast != null && fast.getNext() != null) {
    		node = slow;
    		slow = slow.getNext();
    		fast = fast.getNext().getNext();
    		index ++;
    	}
    	   	
    	// this is used to divide the list in two parts once the middle node is found
    	if(slow != null) {
    		node.setNext(null);
    		index --;
    	}
    	
    	frontNode = head;
        rearNode = 	slow;
    	size = index;    	
    	return new Node[] {frontNode, rearNode};
    }
    
    protected void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.getData());
			if(node.getNext() != null)
				System.out.print(" -> ");
			node = node.getNext();
		}
	}
    
    public static void main(String[] args) {

        SingleLinkedListSplit list = new SingleLinkedListSplit();
        list.createLinkedList(new Node(5));
        list.insertNodeAtEnd(new Node(6));
        list.insertNodeAtEnd(new Node(10));
        list.insertNodeAtEnd(new Node(14));      
        list.insertNodeAtEnd(new Node(15));
        list.insertNodeAtEnd(new Node(16));
        list.insertNodeAtEnd(new Node(18));
        list.insertNodeAtEnd(new Node(20));
        list.insertNodeAtEnd(new Node(22));
        list.insertNodeAtEnd(new Node(24));
        list.insertNodeAtEnd(new Node(26));
        list.insertNodeAtEnd(new Node(28));
        list.insertNodeAtEnd(new Node(30));
        //list.insertNodeAtEnd(new Node(32));
               
        System.out.print("Original list : ");
        list.traverseLinkedList();
        Node[] node = list.splitList(); 
        
        System.out.println();
        System.out.print("First half of list : ");
        list.printLinkedList(node[0]);
        
        System.out.println();
        System.out.print("Second half of list : ");
        list.printLinkedList(node[1]);
   
    }
}