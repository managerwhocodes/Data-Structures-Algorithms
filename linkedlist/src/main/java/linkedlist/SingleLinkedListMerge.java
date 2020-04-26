package linkedlist;

public class SingleLinkedListMerge extends SingleLinkedList{
	
	// merge the two sorted lists so that resulting list is also sorted
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

	// merge the two sorted lists so that resulting list is also sorted
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
	
	// merge the two sorted lists from the end so that resulting list is also sorted
	protected Node mergeListFromEnd(Node nodeOne, Node nodeTwo) {
				
		Node result = null;
		
		while (nodeOne != null && nodeTwo != null) {
			if (nodeOne.getData() <= nodeTwo.getData()) { 
				Node node = nodeOne;
				nodeOne = nodeOne.getNext();				
				node.setNext(result);
				result = node;
			} else {
				Node node = nodeTwo;
				nodeTwo = nodeTwo.getNext();
				node.setNext(result);
				result = node;
			}
		}
		
		while (nodeOne != null) {
			Node node = nodeOne;
			nodeOne = nodeOne.getNext();				
			node.setNext(result);
			result = node;
		}
			
		while (nodeTwo != null) {
			Node node = nodeTwo;
			nodeTwo = nodeTwo.getNext();
			node.setNext(result);
			result = node;
		}
		
		return result;		
	}
	
	// merge alternate nodes of two given lists
	protected Node mergeAlternateNodes(Node nodeOne, Node nodeTwo) {
		
		Node mergedHead = new Node();
		Node mergedTail = mergedHead;
		
		while(nodeOne !=null && nodeTwo!=null) {
			
			mergedTail.setNext(nodeOne);
			mergedTail = nodeOne;
			nodeOne = nodeOne.getNext();
			
			mergedTail.setNext(nodeTwo);
			mergedTail = nodeTwo;
			nodeTwo = nodeTwo.getNext();			
		}
		
		if(nodeOne ==  null){
			mergedTail.setNext(nodeTwo);		
		}
		
		if(nodeTwo == null) {
			mergedTail.setNext(nodeOne);
		}
		
		return mergedHead.getNext();
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
				
		System.out.println("\n");		
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
		
		SingleLinkedList listFive = new SingleLinkedList();
		listFive.createLinkedList(new Node(2));
		listFive.insertNodeAtEnd(new Node(4));
		listFive.insertNodeAtEnd(new Node(8));
		listFive.insertNodeAtEnd(new Node(12));
		listFive.insertNodeAtEnd(new Node(19));
		listFive.insertNodeAtEnd(new Node(22));
		listFive.insertNodeAtEnd(new Node(25));
		
		SingleLinkedList listSix = new SingleLinkedList();
		listSix.createLinkedList(new Node(1));
		listSix.insertNodeAtEnd(new Node(7));
		listSix.insertNodeAtEnd(new Node(10));
		listSix.insertNodeAtEnd(new Node(15));
		listSix.insertNodeAtEnd(new Node(16));
		listSix.insertNodeAtEnd(new Node(20));
		listSix.insertNodeAtEnd(new Node(24));
		listSix.insertNodeAtEnd(new Node(27));
		listSix.insertNodeAtEnd(new Node(30));
				
		System.out.println("\n");		
		System.out.print("List Five : ");
		listFive.traverseLinkedList();
		
		System.out.println();
		System.out.print("List Six : ");
		listSix.traverseLinkedList();
		
		SingleLinkedList mergedListFromEnd = new SingleLinkedList();
		
		mergedListFromEnd.createLinkedList(list.mergeListFromEnd(listFive.head, listSix.head));
		mergedListFromEnd.setSize(listThree.getSize() + listFour.getSize());
		System.out.println();
		System.out.print("After merging List Five and List Six from End : ");
		mergedListFromEnd.traverseLinkedList();
		
		SingleLinkedList listSeven = new SingleLinkedList();
		listSeven.createLinkedList(new Node(2));
		listSeven.insertNodeAtEnd(new Node(4));
		listSeven.insertNodeAtEnd(new Node(8));
		listSeven.insertNodeAtEnd(new Node(12));
		listSeven.insertNodeAtEnd(new Node(19));
		listSeven.insertNodeAtEnd(new Node(22));
		listSeven.insertNodeAtEnd(new Node(25));
		
		SingleLinkedList listEight = new SingleLinkedList();
		listEight.createLinkedList(new Node(1));
		listEight.insertNodeAtEnd(new Node(7));
		listEight.insertNodeAtEnd(new Node(10));
		listEight.insertNodeAtEnd(new Node(15));
		listEight.insertNodeAtEnd(new Node(16));
		listEight.insertNodeAtEnd(new Node(20));
		listEight.insertNodeAtEnd(new Node(24));
		listEight.insertNodeAtEnd(new Node(27));
		listEight.insertNodeAtEnd(new Node(30));
				
		System.out.println("\n");		
		System.out.print("List Seven : ");
		listSeven.traverseLinkedList();
		
		System.out.println();
		System.out.print("List Eight : ");
		listEight.traverseLinkedList();
		
		SingleLinkedList mergedAlternateNodesList = new SingleLinkedList();
		
		mergedAlternateNodesList.createLinkedList(list.mergeAlternateNodes(listSeven.head, listEight.head));
		mergedAlternateNodesList.setSize(listSeven.getSize() + listEight.getSize());
		System.out.println();
		System.out.print("After merging alternate nodes of List Six and List Seven : ");
		mergedAlternateNodesList.traverseLinkedList();
		
	}
}
