package linkedlist;

public class Queue{

    private Node head;
    private Node tail;

    private void enqueue(int data){ // insert at the end of Linked List
        Node node = new Node(data);
        if(isEmpty()){
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    private int dequeue(){ // delete from the start of the Linked List
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        Node tempNode = head;
        head = head.getNext();

        // If there was only one item in the Queue
        if(head == null){
            tail = null;
        }
        return tempNode.getData();
    }

    private int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return head.getData();
    }

    private boolean isEmpty(){
        return head == null && tail == null;
    }

    public static void main(String args[]){
        Queue queue = new Queue();
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.dequeue();
    }
}
