package binarytree;

import java.util.ArrayList;
import java.util.Iterator;

public class ListNode {

	int data;
	ListNode next;
	
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
	
	public void display(ArrayList<ListNode> al){
		Iterator<ListNode> it = al.iterator();
		while(it.hasNext()){
		  ListNode head = (ListNode)it.next();
		  while(head!=null){
			  System.out.print("->" + head.data);
			  head = head.next;
		  }
		  System.out.println("");
		}
	}
}
