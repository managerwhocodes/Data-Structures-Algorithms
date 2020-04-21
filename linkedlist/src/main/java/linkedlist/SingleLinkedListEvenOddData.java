package linkedlist;

public class SingleLinkedListEvenOddData extends SingleLinkedList{

    private void rearrangeEvenOdd(){
        Node oddNode = new Node();
        Node evenNode = new Node();
        
        Node oddTail = oddNode;
        Node evenTail = evenNode;

        Node currentNode = head;
        while(currentNode != null){
            if((currentNode.getData() & 1) == 0){ // node with odd data
            	oddTail.setNext(currentNode);
            	oddTail = oddTail.getNext();
            } else { // node with even data
            	evenTail.setNext(currentNode);
            	evenTail = currentNode;
            }
            currentNode = currentNode.getNext();
        }
        evenTail.setNext(oddNode.getNext());
        oddTail.setNext(null);
        head = evenNode.getNext();
    }


    public static void main(String args[]){
        SingleLinkedListEvenOddData list = new SingleLinkedListEvenOddData();
        list.createLinkedList(new Node(1));
        list.insertNodeAtEnd(new Node(2));
        list.insertNodeAtEnd(new Node(3));
        list.insertNodeAtEnd(new Node(4));
        list.insertNodeAtEnd(new Node(5));
        list.insertNodeAtEnd(new Node(6));

        list.traverseLinkedList();
        System.out.println();
        list.rearrangeEvenOdd();
        list.traverseLinkedList();
    }
}

