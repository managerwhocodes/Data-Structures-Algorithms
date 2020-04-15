package linkedlist;

public class SingleLinkedListPalindrome extends SingleLinkedListReverse{

    protected boolean isPalindrome(){
    	
		if (!existsLinkedList()) {
            return false;
        }

    	// Divide the list in two equal parts
    	Node second = divideList();
    	
    	// Reverse the second list 
    	second = reverseLinkedList(second);
    	
    	Node first = head;
    	
    	while(first !=null && second !=null) {
    		if(!compareNodes(first,second))
    			return false;
    		first = first.getNext();
    		second = second.getNext();
    	}    	
    	return true;
    }
    
    public static void main(String[] args){

        SingleLinkedListPalindrome list = new SingleLinkedListPalindrome();
        list.createLinkedList(new Node(1));
        list.insertNodeAtEnd(new Node(2));
        list.insertNodeAtEnd(new Node(3));
        list.insertNodeAtEnd(new Node(3));
        list.insertNodeAtEnd(new Node(2));
        list.insertNodeAtEnd(new Node(1));

        list.traverseLinkedList();
        System.out.println();
        System.out.println("Is this list palindrome ? " + list.isPalindrome());
    }
}
