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
	
	protected boolean isMatching(char[] chars, char[] pattern, int n, int m,
			 boolean[][] lookup) {

		if (m < 0 && n < 0) {
			return true;
		}

		else if (m < 0) {
			return false;
		}
		
		else if (n < 0) {
			for (int i = 0; i <= m; i++) {
				if (pattern[i] != '*') {
					return false;
				}
			}	
			return true;
		}

		if (!lookup[n][m]){
			if (pattern[m] == '*'){
				lookup[n][m] = isMatching(chars, pattern, n - 1, m, lookup) || isMatching(chars, pattern, n, m - 1, lookup);
			}
			else {

				if (pattern[m] != '?' && pattern[m] != chars[n]) {
					lookup[n][m] = false;
				}

				else {
					lookup[n][m] = isMatching(chars, pattern, n - 1, m - 1, lookup);
				}
			}
		}
		return lookup[n][m];
	}
	
	protected int countOfPatternAsSubsequence(String inputString, String pattern, int inputStrLength, int patternLength) {

		if (inputStrLength == 1 && patternLength == 1)
			return (inputString.charAt(0) == pattern.charAt(0)) ? 1: 0;

		if (inputStrLength == 0) {
			return 0;
		}

		if (patternLength == 0) {
			return 1;
		}

		if (patternLength > inputStrLength) {
			return 0;
		}

		return ((inputString.charAt(inputStrLength-1) == pattern.charAt(patternLength-1)) ?
				countOfPatternAsSubsequence(inputString, pattern, inputStrLength - 1, patternLength - 1) : 0)
				+ countOfPatternAsSubsequence(inputString, pattern, inputStrLength - 1, patternLength);
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
		
		System.out.println();
		
		char[] inputString = "xyxzzxy".toCharArray();
		char[] patternString = "x***x?".toCharArray();

		boolean[][] lookup = new boolean[inputString.length + 1][patternString.length + 1];

		if (sp.isMatching(inputString, patternString, inputString.length - 1, patternString.length - 1, lookup)) {
			System.out.println("Match");
		} else {
			System.out.println("No Match");
		}
		
		System.out.println(sp.countOfPatternAsSubsequence(text, pattern, text.length(), pattern.length()));
		
	}
}
