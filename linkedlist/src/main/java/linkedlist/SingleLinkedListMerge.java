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
		
		SingleLinkedList mergedList = new SingleLinkedList();
				
		mergedList.createLinkedList(list.mergeList(listOne.head, listTwo.head));
		mergedList.setSize(listOne.getSize() + listTwo.getSize());
		mergedList.traverseLinkedList();
	}

}
