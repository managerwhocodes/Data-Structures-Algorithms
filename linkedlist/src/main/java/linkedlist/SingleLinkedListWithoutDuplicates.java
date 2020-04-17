package linkedlist;

import java.util.Set;
import java.util.HashSet;

public class SingleLinkedListWithoutDuplicates extends SingleLinkedList{

    private void removeDuplicatesFromSortedList(){
        if(!existsLinkedList()){
            return;
        }

        Node currentNode = head;

        while(currentNode.getNext() != null){
            if(currentNode.getData() == currentNode.getNext().getData()){
            	currentNode.setNext(currentNode.getNext().getNext());
                setSize(getSize()-1);
            } else {
            	currentNode = currentNode.getNext();
            } 
        }
    }
    
    private void removeDuplicatesFromUnSortedList(){
        if(!existsLinkedList()){
            return;
        }

        Set<Integer> set = new HashSet<Integer>();
        Node currentNode = head;
        Node previousNode = null;

        while(currentNode != null){
            if(set.contains(currentNode.getData())){
                previousNode.setNext(currentNode.getNext());
                setSize(getSize()-1);
            } else {
                set.add(currentNode.getData());
                previousNode = currentNode;
            }
            currentNode = currentNode.getNext();
        }
    }

    public static void main(String args[]){
        SingleLinkedListWithoutDuplicates sortedList = new SingleLinkedListWithoutDuplicates();
        sortedList.createLinkedList(new Node(1));
        sortedList.insertNodeAtEnd(new Node(1));
        sortedList.insertNodeAtEnd(new Node(2));
        sortedList.insertNodeAtEnd(new Node(2));
        sortedList.insertNodeAtEnd(new Node(3));
        sortedList.insertNodeAtEnd(new Node(3));
        sortedList.insertNodeAtEnd(new Node(3));
        sortedList.insertNodeAtEnd(new Node(4));
        sortedList.insertNodeAtEnd(new Node(5));
        sortedList.insertNodeAtEnd(new Node(5));
        sortedList.insertNodeAtEnd(new Node(6));

        System.out.print("Original sorted list : ");
        sortedList.traverseLinkedList();
        System.out.println();
        sortedList.removeDuplicatesFromSortedList();
        System.out.print("List after removing duplicates : ");
        sortedList.traverseLinkedList();
        System.out.println();
        
        SingleLinkedListWithoutDuplicates unSortedList = new SingleLinkedListWithoutDuplicates();
        unSortedList.createLinkedList(new Node(9));
        unSortedList.insertNodeAtEnd(new Node(6));
        unSortedList.insertNodeAtEnd(new Node(8));
        unSortedList.insertNodeAtEnd(new Node(1));
        unSortedList.insertNodeAtEnd(new Node(2));
        unSortedList.insertNodeAtEnd(new Node(3));
        unSortedList.insertNodeAtEnd(new Node(9));
        unSortedList.insertNodeAtEnd(new Node(5));
        unSortedList.insertNodeAtEnd(new Node(6));
        unSortedList.insertNodeAtEnd(new Node(8));
        unSortedList.insertNodeAtEnd(new Node(8));
        
        System.out.print("Original unsorted list : ");
        unSortedList.traverseLinkedList();
        System.out.println();
        unSortedList.removeDuplicatesFromUnSortedList();
        System.out.print("List after removing duplicates : ");
        unSortedList.traverseLinkedList();  
    }
}
