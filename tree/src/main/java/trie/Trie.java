package trie;

public class Trie {
	
	private final Node root;

	public Trie() {
		root = new Node();
	}
	
	public void insert(String word) {
		Node currentNode = root;
		for(int i=0; i < word.length(); i++) {
			char ch = word.charAt(i);
			Node node = currentNode.children.get(ch);
			if(node == null) {
				node = new Node();
				currentNode.children.put(ch, node);
			}
			currentNode = node;
		}
		currentNode.end = true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abcde");
		
	}
}
