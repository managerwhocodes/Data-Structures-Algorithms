package trie;

public class Trie {
	
	protected final Node root;

	public Trie() {
		root = new Node();
	}
	
	public Node getRoot() {
		return root;
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
		
		Trie trieTwo = new Trie();

		
		
		trieTwo.insert("techa");
		trieTwo.insert("techi");
		trieTwo.insert("techie");

		System.out.println(trieTwo.search("tech"));			// true
		System.out.println(trieTwo.search("techi"));   		// true
		System.out.println(trieTwo.search("techie"));  		// true
		System.out.println(trieTwo.search("techiedelight"));   // false

		trieTwo.insert("techiedelight");

		System.out.println(trieTwo.search("tech"));			// true
		System.out.println(trieTwo.search("techi"));   		// true
		System.out.println(trieTwo.search("techie"));  		// true
		System.out.println(trieTwo.search("techiedelight"));   // true
		
	}
}
