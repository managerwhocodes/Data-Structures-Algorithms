package linkedlist;

import java.util.PriorityQueue;

public class SingleLinkedListMergeK extends SingleLinkedList{
	
	protected Node mergeList(SingleLinkedList[] lists) {
				
		Node mergedHead = null;
		Node mergedTail = mergedHead;
		PriorityQueue<Node> queue = new PriorityQueue<Node>((a,b) -> ((Node)a).getData() - ((Node)b).getData());
		
		for(int i=0;i<lists.length;i++) {
			if (lists[i].existsLinkedList())
				queue.add(lists[i].head);
		}
		
		while(!queue.isEmpty()) {
			Node min = queue.poll();
			
			if(mergedHead == null) {
				mergedHead = min;
				mergedTail = min;
			} else {
				mergedTail.setNext(min);
				mergedTail = min;
			}
			
			if(min.getNext() !=null)
				queue.add(min.getNext());
		}
		return mergedHead;		
	}
	
	public static void main(String[] args) {
		
		SingleLinkedListMergeK list = new SingleLinkedListMergeK();
		
		SingleLinkedList listOne = new SingleLinkedList();
		SingleLinkedList listTwo = new SingleLinkedList();
		SingleLinkedList listThree = new SingleLinkedList();
		SingleLinkedList listFour = new SingleLinkedList();
		
		listOne.createLinkedList(new Node(1));
		listOne.insertNodeAtEnd(new Node(5));
		listOne.insertNodeAtEnd(new Node(9));
		listOne.insertNodeAtEnd(new Node(15));
		listOne.insertNodeAtEnd(new Node(16));
		listOne.insertNodeAtEnd(new Node(22));
		listOne.insertNodeAtEnd(new Node(25));
		
		listTwo.createLinkedList(new Node(2));
		listTwo.insertNodeAtEnd(new Node(3));
		listTwo.insertNodeAtEnd(new Node(6));
		listTwo.insertNodeAtEnd(new Node(9));
		listTwo.insertNodeAtEnd(new Node(10));
		listTwo.insertNodeAtEnd(new Node(18));
		listTwo.insertNodeAtEnd(new Node(20));
		listTwo.insertNodeAtEnd(new Node(23));
		listTwo.insertNodeAtEnd(new Node(26));
		listTwo.insertNodeAtEnd(new Node(30));
						
		listThree.createLinkedList(new Node(2));
		listThree.insertNodeAtEnd(new Node(4));
		listThree.insertNodeAtEnd(new Node(8));
		listThree.insertNodeAtEnd(new Node(12));
		listThree.insertNodeAtEnd(new Node(19));
		listThree.insertNodeAtEnd(new Node(22));
		listThree.insertNodeAtEnd(new Node(25));
				
		listFour.createLinkedList(new Node(1));
		listFour.insertNodeAtEnd(new Node(7));
		listFour.insertNodeAtEnd(new Node(10));
		listFour.insertNodeAtEnd(new Node(15));
		listFour.insertNodeAtEnd(new Node(16));
		listFour.insertNodeAtEnd(new Node(20));
		listFour.insertNodeAtEnd(new Node(25));
		listFour.insertNodeAtEnd(new Node(27));
		listFour.insertNodeAtEnd(new Node(30));
		
		System.out.print("List One : ");
		listOne.traverseLinkedList();
		
		System.out.println();
		System.out.print("List Two : ");
		listTwo.traverseLinkedList();
				
		System.out.println();		
		System.out.print("List Three : ");
		listThree.traverseLinkedList();
		
		System.out.println();
		System.out.print("List Four : ");
		listFour.traverseLinkedList();
		
		SingleLinkedList mergedList = new SingleLinkedList();
		SingleLinkedList[] lists = new SingleLinkedList[4];
		lists[0] = listOne;
		lists[1] = listTwo;
		lists[2] = listThree;
		lists[3] = listFour;
		
		mergedList.createLinkedList(list.mergeList(lists));
		mergedList.setSize(lists[0].size + lists[1].size + lists[2].size + lists[3].size);
		System.out.println();
		System.out.print("After merging the Lists : ");
		mergedList.traverseLinkedList();
		
	}
}
