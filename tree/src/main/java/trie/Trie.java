package trie;

public class Trie {
	
	private final Node root;

	public Trie() {
		root = new Node();
	}
	
	protected void insert(String word) {
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
	
	protected boolean search(String word) {
		Node currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			Node node = currentNode.children.get(ch); 
			// word does not exists in trie;
			if (node == null) {
				return false;
			}
			currentNode = node;
		}
		// if currentNode.end == true then word exists in trie
		// else it is a prefix of another word
		return currentNode.end;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abcde");
		
		System.out.println("word abcde exists in trie : "+trie.search("abcde"));
		System.out.println("word abc exists in trie : "+trie.search("abc"));
		
	}
}
