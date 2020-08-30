package binarytree;

import java.util.ArrayList;

public class ListNode {

	int data;
	ListNode next;
	
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
	
	public void display(ArrayList<ListNode> al){
		
		for(ListNode head : al) {
			while(head!=null){
				  System.out.print("->" + head.data);
				  head = head.next;
			}
			System.out.println("");
		}
	}
}
