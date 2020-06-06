package trie;

import java.util.Arrays;
import java.util.List;

public class TrieMaxWord extends Trie{
	
	protected void insert(Node head, String str)
	{
		Node currentNode = head;
		
		for (int i = 0; i < str.length(); i++)
		{

			if (!currentNode.getChildren().containsKey(str.charAt(i))) {
				currentNode.getChildren().put(str.charAt(i), new Node());
			}

			currentNode = currentNode.getChildren().get(str.charAt(i));
		}

		currentNode.key = str;
		currentNode.count += 1;
	}
	
	protected int maxCount(String searchWord) {
		Node currentNode = root;
		for (int i = 0; i < searchWord.length(); i++) {
			char ch = searchWord.charAt(i);
			Node node = currentNode.children.get(ch); 
			if (node == null) {
				return 0;
			}
			currentNode = node;
		}
		return currentNode.count;
	}
	
	public static void main(String[] args) {
		TrieMaxWord trie = new TrieMaxWord();
		
		List<String> dictionary = Arrays.asList(
				"code", "coder", "coding", "codable", "codec", "codecs",
				"coded", "codeless", "codec", "codecs", "codependence",
				"codex", "codify", "codependents", "codes", "code",
				"coder", "codesign", "codec", "codeveloper", "codrive",
				"codec", "codecs", "codiscovered"
			);

		System.out.println("Dictionary : ");
		for( String word : dictionary) {
			trie.insert(trie.getRoot(), word);
			System.out.println(word);
		}
		
		String searchWord = "codependence";
		System.out.println("\nWord "+searchWord+" exists in dictionary : "+trie.maxCount(searchWord)+" times");
		
	}
}
