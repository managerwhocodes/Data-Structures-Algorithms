package linkedlist;

import java.util.Set;
import java.util.HashSet;

public class SingleLinkedListWithoutDuplicates extends SingleLinkedList{

    private void removeDuplicates(){
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
        SingleLinkedListWithoutDuplicates list = new SingleLinkedListWithoutDuplicates();
        list.createLinkedList(new Node(1));
        list.insertNodeAtEnd(new Node(1));
        list.insertNodeAtEnd(new Node(2));
        list.insertNodeAtEnd(new Node(1));
        list.insertNodeAtEnd(new Node(3));
        list.insertNodeAtEnd(new Node(3));
        list.insertNodeAtEnd(new Node(4));
        list.insertNodeAtEnd(new Node(5));
        list.insertNodeAtEnd(new Node(6));
        list.insertNodeAtEnd(new Node(7));
        list.insertNodeAtEnd(new Node(5));

        list.traverseLinkedList();
        System.out.println();
        list.removeDuplicates();
        list.traverseLinkedList();
    }
}
