package trie;

import java.util.*;
import java.util.Map.Entry;

class TrieNode {

	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	Set<String> word = new HashSet<String>();
	boolean isLeaf = false;
}

public class TriePattern {
	
	protected final TrieNode root;

	public TriePattern() {
		root = new TrieNode();
	}

	protected void insert(String word) {
		
		TrieNode currentNode = root;
		
		for (char c: word.toCharArray()){
			if (Character.isUpperCase(c)) {
				currentNode.children.putIfAbsent(c, new TrieNode());
				currentNode = currentNode.children.get(c);
			}
		}
		currentNode.isLeaf = true;
		currentNode.word.add(word);
	}

	protected void printAllWords(TrieNode root) {
		
		if (root == null) {
			return;
		}

		if (root.isLeaf) {
			System.out.println(root.word);
		}

		for (Entry<Character, TrieNode> pair: root.children.entrySet()) {
			TrieNode child = pair.getValue();
			printAllWords(child);
		}
	}

	protected void findAllWords(List<String> dictionary, String pattern) {

		TrieNode curr = root;

		for (char c: pattern.toCharArray()) {
			curr = curr.children.get(c);
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
				"TechieDelight", "Hello", "HelloWorld", "HiTechLab", "TechDelight");
				
		for (String s: dictionary) {
			triePattern.insert(s);
		}
		
		String patternString = "TD";
		triePattern.findAllWords(dictionary, patternString);
	}
}