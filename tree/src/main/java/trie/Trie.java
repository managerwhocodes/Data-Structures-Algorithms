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
		currentNode.wordEnd = true;
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
		return currentNode.wordEnd;
	}
	
	protected boolean isPrefix(String word) {
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
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abcde");		
		trie.insert("abcfgh");		
		trie.insert("adcfgh");
		trie.insert("abc");	
		
		System.out.println("word abcde exists in trie : "+trie.search("abcde"));
		System.out.println("word abc exists in trie : "+trie.search("abc"));
		System.out.println("word abcd exists in trie : "+trie.search("abcd"));
		System.out.println("word abcd is a prefix in trie : "+trie.isPrefix("abcd"));
		
		Trie trieTwo = new Trie();
		
		trieTwo.insert("techa");
		trieTwo.insert("techi");
		trieTwo.insert("techie");

		System.out.println(trieTwo.search("tech"));			// false
		System.out.println(trieTwo.search("techi"));   		// true
		System.out.println(trieTwo.search("techie"));  		// true
		System.out.println(trieTwo.search("techiedelight"));   // false

		trieTwo.insert("techiedelight");

		System.out.println(trieTwo.search("tech"));			// false
		System.out.println(trieTwo.search("techi"));   		// true
		System.out.println(trieTwo.search("techie"));  		// true
		System.out.println(trieTwo.search("techiedelight"));   // true
		
	}
}
