package trie;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	protected boolean searchWildCard(String word) {
		return searchWildCardUtil(root.getChildren(), word, 0);
	}
	
	private boolean searchWildCardUtil(Map<Character, Node> children , String word, int index) {
		
		if(index == word.length()) {
			if(children.size() == 0)
				return true;
			else
				return false;
		}
		
		char ch = word.charAt(index);
		
		if(children.containsKey(ch)) {
			
			if(index == word.length()-1 && children.get(ch).wordEnd)
				return true;
			
			return searchWildCardUtil(children.get(ch).getChildren(), word, index+1);
			
		} else if(ch == '.') {
			boolean result = false;
			for(Map.Entry<Character, Node> child : children.entrySet()) {
				if( index == word.length()-1 && child.getValue().wordEnd)
					return true;
				
				if(searchWildCardUtil(child.getValue().getChildren(), word, index+1))
					result = true;
			}
			return result;
		} else {
			return false;
		}       
    }
	
	protected String findLCP(List<String> dict) {

		StringBuilder lcp = new StringBuilder();
		Node curr = root;

		while (curr != null && !curr.wordEnd && (curr.getChildren().size() == 1)) {
			for (Entry<Character, Node> entry: curr.getChildren().entrySet()) {

				lcp.append(entry.getKey());
				curr = entry.getValue();
			}
		}
		return lcp.toString();
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
		
		System.out.println(trie.searchWildCard("a."));
		System.out.println(trie.searchWildCard(".a"));
		
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

		List<String> dict = Arrays.asList(
				"code", "coder", "coding", "codable", "codec", "codecs", "coded",
				"codeless", "codependence", "codependency", "codependent",
				"codependents", "codes", "codesign", "codesigned", "codeveloped",
				"codeveloper", "codex", "codify", "codiscovered", "codrive"
		);
		
		Trie trieThree = new Trie();
		
		for(String word : dict) {
			trieThree.insert(word);
		}

		System.out.println("Longest Common Prefix is " + trieThree.findLCP(dict));
		
	}
}
