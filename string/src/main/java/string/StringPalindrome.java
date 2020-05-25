package string;

public class StringPalindrome {

	
	protected boolean isPalindrome(String str)
	{
		return isPalindromeUtil(str,0,str.length()-1);
	}
	
	
	protected boolean isPalindromeUtil(String str, int low, int high)
	{
		return (low >= high) 
				|| (str.charAt(low) == str.charAt(high) 
				&& isPalindromeUtil(str, low + 1, high - 1));
	}

	public static void main(String[] args) {
		
		StringPalindrome sp = new StringPalindrome();
		String input = "ABCDDCBA";
		System.out.println("Is string - "+input+" palindrome : "+sp.isPalindrome(input));

	}

}
