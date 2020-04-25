package linkedlist;

public class SingleLinkedListIntersection extends SingleLinkedList{
	
	protected static int listSize;
		
	protected Node mergeList(Node nodeOne, Node nodeTwo) {
				
		Node head = null;
		Node tail = head;
		
		while (nodeOne != null && nodeTwo != null) {
			if (nodeOne.getData() == nodeTwo.getData()) { 
				
				if(head == null) {
					tail = head = new Node(nodeOne.getData());
					listSize++;
				} else {
					tail.setNext(new Node(nodeOne.getData()));
					tail = tail.getNext();
					listSize++;
				}
				
				nodeOne = nodeOne.getNext();
				nodeTwo = nodeTwo.getNext();
			} 
			
			else if(nodeOne.getData() < nodeTwo.getData())
				nodeOne = nodeOne.getNext();
			else 
				nodeTwo = nodeTwo.getNext();
		}
		return head;		
	}
	
	public static void main(String[] args) {
		
		SingleLinkedListIntersection list = new SingleLinkedListIntersection();
		
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
		listTwo.insertNodeAtEnd(new Node(9));
		listTwo.insertNodeAtEnd(new Node(18));
		listTwo.insertNodeAtEnd(new Node(20));
		listTwo.insertNodeAtEnd(new Node(22));
		listTwo.insertNodeAtEnd(new Node(26));
		listTwo.insertNodeAtEnd(new Node(30));
		
		System.out.print("List One : ");
		listOne.traverseLinkedList();
		
		System.out.println();
		System.out.print("List Two : ");
		listTwo.traverseLinkedList();
		
		SingleLinkedList intersectionList = new SingleLinkedList();
				
		intersectionList.createLinkedList(list.mergeList(listOne.head, listTwo.head));
		intersectionList.setSize(listSize);
		System.out.println("\n");
		System.out.print("After merging the intersection of List One and List Two : ");
		intersectionList.traverseLinkedList();
					
	}
}
