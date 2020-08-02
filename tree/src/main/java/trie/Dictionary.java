package trie;

import java.util.Arrays;
import java.util.HashSet;
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
    
    protected boolean wordBreak(String str, String answer) {
    	
    	if (str.length() == 0) {
    		System.out.println(answer);
    		return true;
    	} else {
    		int index = 0;
    		String word = "";
    		while (index < str.length()) {
    			word += str.charAt(index);			
    			if (search(word)) {
    				if (wordBreak(str.substring(index + 1), answer + word + " ")) {
    					System.out.println(answer + word + " "); 
    					return true;
    				} else {
    					index++;
    				}
    			} else {
    				index++;
    			}
    		}
    		return false;
    	}
    } 
    
    protected boolean wordBreakDP(String s, HashSet<String> memory, String answer) {
    	
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else if (memory.contains(s)) {
			return false;
		} else {
			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);
				if (search(word)) {
					if (wordBreakDP(s.substring(index + 1), memory,
							answer + word + " ")) {
						return true;
					} else {
						index++;
					}
				} else {					
					index++;
				}
			}
			memory.add(s);
			return false;
		}
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
		HashSet<String> memory  = new HashSet<String>();
		
		List<String> dictionary2 = Arrays.asList("this", "th", "is", "famous",
				"word", "break", "b", "r", "e", "a", 
				"k",
				"br", "bre", "brea", "ak", 
				"problem");
		
		for( String word : dictionary2) {
			dic2.insert(word);
		}
		String str = "wordbreakproblem";
		dic2.wordBreak(str,"");
		System.out.println("Using Dynamic Programming : ");
		dic2.wordBreakDP(str,memory,"");
	}
}
