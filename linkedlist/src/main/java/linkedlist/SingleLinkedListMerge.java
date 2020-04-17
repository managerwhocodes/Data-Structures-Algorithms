package linkedlist;

public class SingleLinkedListMerge extends SingleLinkedList{
	
	protected Node mergeList(Node nodeOne, Node nodeTwo) {
				
		Node mergedHead = new Node();
		Node mergedTail = mergedHead;
		
		while (nodeOne != null && nodeTwo != null) {
			if (nodeOne.getData() <= nodeTwo.getData()) { 
				mergedTail.setNext(nodeOne);
				nodeOne = nodeOne.getNext();
			} else {
				mergedTail.setNext(nodeTwo);
				nodeTwo = nodeTwo.getNext();
			}
			mergedTail = mergedTail.getNext();
		}
		
		if(nodeOne == null) {
			mergedTail.setNext(nodeTwo);
		}
			
		if(nodeTwo == null) {
			mergedTail.setNext(nodeOne);
		}
		
		return mergedHead.getNext();		
	}

	protected Node mergeListRecursive(Node nodeOne, Node nodeTwo) {
		
		if(nodeOne == null) 
			return nodeTwo; 
        if(nodeTwo == null) 
        	return nodeOne; 
          
        if(nodeOne.getData() < nodeTwo.getData()){ 
        	nodeOne.setNext(mergeListRecursive(nodeOne.getNext(), nodeTwo)); 
            return nodeOne; 
        } 
        else { 
        	nodeTwo.setNext(mergeListRecursive(nodeOne, nodeTwo.getNext())); 
            return nodeTwo;  
        } 	
	}
	
	public static void main(String[] args) {
		
		SingleLinkedListMerge list = new SingleLinkedListMerge();
		
		SingleLinkedList listOne = new SingleLinkedList();
		listOne.createLinkedList(new Node(1));
		listOne.insertNodeAtEnd(new Node(5));
		listOne.insertNodeAtEnd(new Node(9));
		listOne.insertNodeAtEnd(new Node(15));
		listOne.insertNodeAtEnd(new Node(16));
		listOne.insertNodeAtEnd(new Node(22));
		listOne.insertNodeAtEnd(new Node(25));
		
		
		SingleLinkedList listTwo = new SingleLinkedList();
		listTwo.createLinkedList(new Node(2));
		listTwo.insertNodeAtEnd(new Node(3));
		listTwo.insertNodeAtEnd(new Node(6));
		listTwo.insertNodeAtEnd(new Node(10));
		listTwo.insertNodeAtEnd(new Node(18));
		listTwo.insertNodeAtEnd(new Node(20));
		listTwo.insertNodeAtEnd(new Node(23));
		listTwo.insertNodeAtEnd(new Node(26));
		listTwo.insertNodeAtEnd(new Node(30));
		
		System.out.print("List One : ");
		listOne.traverseLinkedList();
		
		System.out.println();
		System.out.print("List Two : ");
		listTwo.traverseLinkedList();
		
		SingleLinkedList mergedList = new SingleLinkedList();
				
		mergedList.createLinkedList(list.mergeList(listOne.head, listTwo.head));
		mergedList.setSize(listOne.getSize() + listTwo.getSize());
		System.out.println();
		System.out.print("After merging List One and List Two :");
		mergedList.traverseLinkedList();
				
		SingleLinkedList listThree = new SingleLinkedList();
		listThree.createLinkedList(new Node(2));
		listThree.insertNodeAtEnd(new Node(4));
		listThree.insertNodeAtEnd(new Node(8));
		listThree.insertNodeAtEnd(new Node(12));
		listThree.insertNodeAtEnd(new Node(19));
		listThree.insertNodeAtEnd(new Node(22));
		listThree.insertNodeAtEnd(new Node(25));
		
		SingleLinkedList listFour = new SingleLinkedList();
		listFour.createLinkedList(new Node(1));
		listFour.insertNodeAtEnd(new Node(7));
		listFour.insertNodeAtEnd(new Node(10));
		listFour.insertNodeAtEnd(new Node(15));
		listFour.insertNodeAtEnd(new Node(16));
		listFour.insertNodeAtEnd(new Node(20));
		listFour.insertNodeAtEnd(new Node(25));
		listFour.insertNodeAtEnd(new Node(27));
		listFour.insertNodeAtEnd(new Node(30));
				
		System.out.println();		
		System.out.print("List Three : ");
		listThree.traverseLinkedList();
		
		System.out.println();
		System.out.print("List Four : ");
		listFour.traverseLinkedList();
		
		SingleLinkedList mergedListRecursive = new SingleLinkedList();
		
		mergedListRecursive.createLinkedList(list.mergeListRecursive(listThree.head, listFour.head));
		mergedListRecursive.setSize(listThree.getSize() + listFour.getSize());
		System.out.println();
		System.out.print("After merging List Three and List Four :");
		mergedListRecursive.traverseLinkedList();
		
	}
}
