package string;

public class StringPattern {
	
	
	private void basicCheck(String text, String pattern) {
		
		if (pattern == null || pattern.length() == 0) {
			System.out.println("Pattern occurs with shift 0");
			return;
		}

		if (text == null || pattern.length() > text.length()) {
			System.out.println("Pattern not found");
			return;
		}
	}

	// Basic patter matching
	// Time Complexity for this approach is O(mn) 
	// where n is length of string and m is length of pattern
	protected void basicPatternMatching(String text, String pattern) {
		
		basicCheck(text,pattern);
		
		int textLength = text.length();
		int patternLength = pattern.length();

		long startTime = System.nanoTime();
		for (int i=0; i <= textLength - patternLength; i++) {
			for (int j=0; j < patternLength; j++) {
				if (text.charAt(i + j) != pattern.charAt(j))
					break;

				if (j == patternLength - 1)
					System.out.println("Pattern occurs with shift " + i);
			}
		}
		long endTime = System.nanoTime();
		System.out.print("Total time taken in nanosecs : "+(endTime-startTime));		
	}
	
	protected void KMP(String text, String pattern) {

		basicCheck(text,pattern);

		char[] chars = pattern.toCharArray();
		int[] next = new int[pattern.length() + 1];
		
		long startTime = System.nanoTime();
		for (int i = 1; i < pattern.length(); i++) {
			int j = next[i + 1];

			while (j > 0 && chars[j] != chars[i])
				j = next[j];

			if (j > 0 || chars[j] == chars[i])
				next[i + 1] = j + 1;
		}

		for (int i = 0, j = 0; i < text.length(); i++) {
			if (j < pattern.length() && text.charAt(i) == pattern.charAt(j)) {
				if (++j == pattern.length()) {
					System.out.println("Pattern occurs with shift " +
									(i - j + 1));
				}
			}
			else if (j > 0) {
				j = next[j];
				i--;
			}
		}
		long endTime = System.nanoTime();
		System.out.print("Total time taken in nanosecs : "+(endTime-startTime));
	}
	
	public static void main(String[] args) {
		
		StringPattern sp = new StringPattern();
		
		String text = "ABCABAABCABAC";
		String pattern = "CAB";
		
		//String text = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		//String pattern = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB";

		
		System.out.print("Input text : "+text);
		System.out.print("\nInput pattern : "+pattern);
		
		System.out.println("\n\nResult using basic pattern finding method : ");		
		sp.basicPatternMatching(text, pattern);
		
		System.out.println("\n\nResult using Knuth-Morris-Pratt Algorithm : ");		
		sp.KMP(text, pattern);
		
		//sp.KMP(text, pattern);
	}
}
