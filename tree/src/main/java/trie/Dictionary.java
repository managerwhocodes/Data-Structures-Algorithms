package trie;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Dictionary extends Trie{
	
    private void preOrderTraversal(Node root, StringBuilder sb) {

        if (root == null) 
        	return;

        if (root.end) {
            System.out.println(sb.toString());
        }
        
        Map<Character, Node> children = root.getChildren();
        for (Map.Entry<Character, Node> entity : children.entrySet()) {
            sb.append(entity.getKey());
            preOrderTraversal(entity.getValue(), sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

	public static void main(String[] args) {

		Dictionary dic = new Dictionary();
		
		List<String> dictionary = Arrays.asList(
				"code", "coder", "codec", "codecs"
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
