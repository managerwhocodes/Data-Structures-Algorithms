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
	}
}
