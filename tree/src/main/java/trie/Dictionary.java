package trie;

import java.util.Arrays;
import java.util.List;

public class Dictionary extends Trie{
	
	
    private void preOrderTraversal(Node root, StringBuilder sb) {

        if (root == null) 
        	return;

        if (root.wordEnd) {
            System.out.println(sb.toString());
        }
        
        for (char ch = 'a'; ch <= 'z'; ch++){
			if (root.getChildren()!=null && root.getChildren().containsKey(ch));
			{
	            sb.append(ch);
	            preOrderTraversal(root.getChildren().get(ch), sb);
	            sb.deleteCharAt(sb.length() - 1);
			}
		}
    }
    
    private boolean wordBreak(String str) {
    	boolean isBreak = true;
    	Node currentNode = root;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			Node node = currentNode.children.get(ch); 

			if (node == null) {
				isBreak = false;
				return isBreak;
			} 
						
			currentNode = node;
			
			if(currentNode.wordEnd == true) {
				System.out.println(str.substring(0, i+1)+" ");
				str = str.substring(i+1, str.length());
				currentNode = root;
				i=-1;
			}
			
		}
		// if currentNode.end == true then word exists in trie
		// else it is a prefix of another word
		return isBreak;
    }

	public static void main(String[] args) {

		Dictionary dic = new Dictionary();
		
		List<String> dictionary = Arrays.asList(
				"code", "coder", "codec", "codecs", "coda", "codea",
				"actually","accuse","achieve","achievement","acid","acknowledge",
				"acquire","across","act","action","active","activist","activity",
				"actor","actress","actual"
			);

		//System.out.println("Dictionary : ");
		for( String word : dictionary) {
			dic.insert(word);
			//System.out.println(word);
		}
		System.out.println("Lexicographic Order : ");
		StringBuilder sb = new StringBuilder();
		dic.preOrderTraversal(dic.getRoot(), sb);

		Dictionary dic2 = new Dictionary();
		
		List<String> dictionary2 = Arrays.asList("this", "th", "is", "famous",
				"word", "break", "b", "r", "e", "a", "k",
				"br", "bre", "brea", "ak", "problem");
		
		for( String word : dictionary2) {
			dic2.insert(word);
		}
		String str = "wordbreakproblem";
		dic2.wordBreak(str);
	}
}
