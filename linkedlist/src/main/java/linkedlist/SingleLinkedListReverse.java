package linkedlist;

public class SingleLinkedListReverse extends SingleLinkedList{

    protected void reverseLinkedList(){
        Node previousNode = null;
        Node currentNode = head;

        while(currentNode != null){
            Node nextNode = currentNode.getNext();

            currentNode.setNext(previousNode);

            previousNode = currentNode;
            currentNode = nextNode;
        }
        // this is important because the head will still be pointing to the first node in the original list
        head = previousNode;
    }

    public static void main(String[] args) {
        SingleLinkedListReverse list = new SingleLinkedListReverse();
        list.createLinkedList(new Node(1));
        list.insertNodeAtEnd(new Node(2));
        list.insertNodeAtEnd(new Node(3));
        list.insertNodeAtEnd(new Node(4));
        list.insertNodeAtEnd(new Node(5));
        list.insertNodeAtEnd(new Node(6));
        list.insertNodeAtEnd(new Node(7));

        list.traverseLinkedList();
        System.out.println();
        list.reverseLinkedList();
        list.traverseLinkedList();
    }
}
