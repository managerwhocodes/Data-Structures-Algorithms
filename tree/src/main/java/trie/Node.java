package trie;

import java.util.HashMap;
import java.util.Map;

public class Node{
	
	Map<Character,Node> children;
	boolean end;
	
	public Node() {
		children  = new HashMap<Character, Node>();
		end = false;
	}
		
}