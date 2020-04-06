package linkedlist;

public class SingleLinkedList{

    private Node head;
    private Node tail;
    private int size;

    public Node getHead(){
        return head;
    }

    public void setHead(Node head){
        this.head = head;
    }

    public Node getTail(){
        return tail;
    }

    public void setTail(Node tail){
        this.tail  = tail;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    private Node createLinkedList(Node node){
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    private void insertNodeAtStart(Node node){
        if(!existsLinkedList()){
            return;
        }
        node.setNext(head);
        head = node;
        setSize(getSize()+1);
    }

    private void insertNodeAtEnd(Node node){
        if(!existsLinkedList()){
            return;
        }
        tail.setNext(node);
        tail = node;
        setSize(getSize()+1);
    }

    private void insertNodeAtLocation(Node node, int location){
        if(!existsLinkedList()){
            return;
        } else if(location ==0) { // insert at head
            insertNodeAtStart(node);
        } else if(location >= size) { // insert at tail
            insertNodeAtEnd(node);
        } else { // insert at specified location
            Node tempNode = head;
            for(int index=0; index < location-1; index++){
                tempNode = tempNode.getNext();
            }
            Node nextNode = tempNode.getNext();
            tempNode.setNext(node);
            node.setNext(nextNode);
            setSize(getSize()+1);
        }
    }

    private void deleteNodeFromStart(){
        if(!existsLinkedList()){
            return;
        }
        head = head.getNext();
		setSize(getSize()-1);
		if(getSize() == 0) { // if there was only one node
			tail = null;
		}
    }

    private void deleteNodeFromEnd(){
        if(!existsLinkedList()){
            return;
        }
        Node tempNode = head;
        for(int index=0; index < size-1; index++) { // traverse to second last node
            tempNode = tempNode.getNext();
        }
        // Handle use case where there is only one node
        if(tempNode == head){
            head = tail = null;
            setSize(getSize()-1);
            return;
        }
        tempNode.setNext(null);
        tail = tempNode;
        setSize(getSize()-1);
    }

    private void deleteNodeAtLocation(int location){
        if(!existsLinkedList()){
            return;
        } else if(location == 0){ // delete from head
            deleteNodeFromStart();
        } else if(location >= size){ // delete from tail
            deleteNodeFromEnd();
        } else {
            Node tempNode = head;
            for(int index=0; index < location-1 ;index++){
                tempNode = tempNode.getNext();
            }
            Node deleteNode = tempNode.getNext();
            tempNode.setNext(tempNode.getNext().getNext());
            deleteNode.setNext(null);
            setSize(getSize()-1);
        }
    }

    private boolean findNode(int data){
        if(existsLinkedList()){
            Node tempNode = head;
            for(int index=0; index < size; index++){
                if(tempNode.getData() == data)
                    return true;
                tempNode = tempNode.getNext();
            }
        }
        return false;
    }

    private void traverseLinkedList() {
		if (!existsLinkedList()) {
            return;
        }
		Node tempNode = head;
		for (int index = 0; index < size; index++) {
			System.out.print(tempNode.getData());
			if (index != getSize() - 1) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.getNext();
		}
	}

    private boolean existsLinkedList() {
		return head != null;
	}

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        list.createLinkedList(new Node(5));
        
        list.insertNodeAtEnd(new Node(6));
        list.insertNodeAtEnd(new Node(10));
        list.insertNodeAtEnd(new Node(14));
        list.insertNodeAtEnd(new Node(20));
        list.traverseLinkedList();
        System.out.println();

        list.insertNodeAtStart(new Node(4));
        list.traverseLinkedList();
        System.out.println();
        
        list.insertNodeAtLocation(new Node(11),4);
        list.traverseLinkedList();
        System.out.println();
        
        if(list.findNode(14)) {
        	System.out.println("Found node with data : 14");
        } else {
        	System.out.println("Node not found with data : 14");
        }
        
        if(list.findNode(35)) {
        	System.out.println("Found node with data : 35");
        } else {
        	System.out.println("Node not found with data :35");
        }
        
        list.deleteNodeFromEnd();
        list.traverseLinkedList();
        System.out.println();
        
        list.deleteNodeFromStart();
        list.traverseLinkedList();
        System.out.println();
        
        list.deleteNodeAtLocation(2);
        list.traverseLinkedList();
        System.out.println();
           
    }
}