package trie;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	
	protected int maxCount(Node currentNode, int maxCount, StringBuilder key) {
		if (currentNode == null) {
			return maxCount;
		}

		for (Map.Entry<Character, Node> entry: currentNode.children.entrySet())
		{
			if (maxCount < entry.getValue().count) {
				key.replace(0, key.length(), entry.getValue().key);
				maxCount = entry.getValue().count;
			}
			maxCount = maxCount(entry.getValue(), maxCount, key);
		}
		return maxCount;
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
		Node head = new Node();
		for( String word : dictionary)
			trie.insert(head, word);
		
		int count = 0;
		StringBuilder string = new StringBuilder("code");
		Node node = trie.getRoot();
		System.out.println("word code exists in trie : "+trie.maxCount(node, count, string));
		
	}
}
