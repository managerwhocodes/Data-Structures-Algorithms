package trie;

import java.util.*;
import java.util.Map.Entry;

class TrieNode {

	Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();
	Set<String> word = new HashSet<String>();
	boolean isLeaf = false;
}

class TriePattern {

	protected TrieNode insert(TrieNode head, String word) {
		
		if (head == null) {
			head = new TrieNode();
		}

		TrieNode currentNode = head;
		
		for (char c: word.toCharArray())
		{

			if (Character.isUpperCase(c)) {

				currentNode.map.putIfAbsent(c, new TrieNode());
				currentNode = currentNode.map.get(c);
			}
		}

		currentNode.isLeaf = true;
		currentNode.word.add(word);

		return head;
	}

	protected void printAllWords(TrieNode root) {
		
		if (root == null) {
			return;
		}

		if (root.isLeaf) {
			System.out.println(root.word);
		}

		for (Entry<Character, TrieNode> pair: root.map.entrySet())
		{
			TrieNode child = pair.getValue();
			printAllWords(child);
		}
	}

	protected void findAllWords(List<String> dictionary, String pattern) {

		TrieNode head = null;

		for (String s: dictionary) {
			head = insert(head, s);
		}

		TrieNode curr = head;
		
		for (char c: pattern.toCharArray()) {
			curr = curr.map.get(c);
			if (curr == null) {
				return;
			}
		}

		printAllWords(curr);
	}

	public static void main(String[] args) {	
		
		TriePattern triePattern = new TriePattern();
		
		List<String> dictionary = null;
		dictionary = Arrays.asList("Hi", "HiTech", "HiTechCity", "Techie",
				"TechieDelight", "Hello", "HelloWorld", "HiTechLab");

		String patternString = "H";
		triePattern.findAllWords(dictionary, patternString);
	}
}