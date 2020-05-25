package string;

import java.util.HashMap;
import java.util.Map;

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
	
	
	protected boolean isAnagram(String strOne, String strTwo)
	{
		strOne = strOne.replaceAll(" ", "").toLowerCase();
		strTwo = strTwo.replaceAll(" ", "").toLowerCase();
		
		if(strOne.length() != strTwo.length())
			return false;
		
		Map<Character,Integer> freqStrOne = new HashMap<Character,Integer>();
		Map<Character,Integer> freqStrTwo = new HashMap<Character,Integer>();
		
		
		for (char c: strOne.toCharArray()) {
			freqStrOne.put(c, freqStrOne.getOrDefault(c, 0) + 1);
		}
		
		for (char c: strTwo.toCharArray()) {
			freqStrTwo.put(c, freqStrTwo.getOrDefault(c, 0) + 1);
		}
		
		return freqStrOne.equals(freqStrTwo);
	}

	public static void main(String[] args) {
		
		StringPalindrome sp = new StringPalindrome();
		String input = "ABCDDCBA";
		System.out.println("Is string - "+input+" palindrome : "+sp.isPalindrome(input));
		
		String strOne = "Tom Marvolo Riddle";
		String strTwo = "I Am Lord Voldemort";
		
		System.out.println("Are string - "+strOne+" and "+strTwo+" anagrams : "+sp.isAnagram(strOne,strTwo));
	}
}
