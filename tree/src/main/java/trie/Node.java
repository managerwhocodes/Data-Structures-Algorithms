package trie;

import java.util.HashMap;
import java.util.Map;

public class Node{
	
	Map<Character,Node> children;
	boolean wordEnd;
	int count;
	String key;
	
	public Node() {
		children  = new HashMap<Character, Node>();
		wordEnd = false;
	}
	
	public Map<Character,Node> getChildren() {
		return children;
	}
	
	public String getKey() {
		return key;
	}
		
}