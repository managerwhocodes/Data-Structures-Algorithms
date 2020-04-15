package linkedlist;

public class SingleLinkedListCycle extends SingleLinkedList{

    protected boolean hasCycle(){
        if (!existsLinkedList()) {
            System.exit(1);
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SingleLinkedListCycle list1 = new SingleLinkedListCycle();
        Node node1 = new Node(1);
        list1.createLinkedList(node1);
        Node node2 = new Node(2);
        list1.insertNodeAtEnd(node2);
        node2.setNext(node2);
        Node node3 = new Node(3);
        list1.insertNodeAtEnd(node3);
        Node node4 = new Node(4);
        list1.insertNodeAtEnd(node4);
        node4.setNext(node2);

        System.out.println("Is there any cycle in the list : " + list1.hasCycle());
    }
}