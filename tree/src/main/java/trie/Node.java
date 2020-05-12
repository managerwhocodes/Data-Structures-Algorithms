package trie;

import java.util.HashMap;
import java.util.Map;

public class Node{
	
	Map<Character,Node> children;
	boolean end;
	int count;
	String key;
	
	public Node() {
		children  = new HashMap<Character, Node>();
		end = false;
	}
	
	public Map<Character,Node> getChildren() {
		return children;
	}
	
	public String getKey() {
		return key;
	}
		
}