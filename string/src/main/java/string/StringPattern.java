package string;

public class StringPattern {

	protected void find(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();

		int i = 0;
		while (i <= n - m) {
			for (int j = 0; j < m; j++) {
				if (text.charAt(i + j) != pattern.charAt(j))
					break;

				if (j == m - 1)
					System.out.println("Pattern occurs with shift " + i);
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		
		StringPattern sp = new StringPattern();
		
		String text = "ABCABAABCABAC";
		String pattern = "CAB";

		sp.find(text, pattern);
	}
}
