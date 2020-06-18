package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringPalindrome {

	
	protected boolean isPalindrome(String str) {
		
		return isPalindromeUtil(str,0,str.length()-1);
	}
	
	
	protected boolean isPalindromeUtil(String str, int low, int high) {
		
		return (low >= high) 
				|| (str.charAt(low) == str.charAt(high) 
				&& isPalindromeUtil(str, low + 1, high - 1));
	}
	
	protected boolean canMakePalindrome(String str) {
		
		List<Character> list = new ArrayList<Character>(); 
		
		for (int i = 0; i < str.length(); i++) { 
            if (list.contains(str.charAt(i))) 
                list.remove((Character) str.charAt(i)); 
            else
                list.add(str.charAt(i)); 
        } 
		
		if (str.length() % 2 == 0 && list.isEmpty() 
				|| (str.length() % 2 == 1 && list.size() == 1)) 
            return true; 
        else
            return false; 
		
	}
	
	protected int getMaxLenNonPalindromeSubstring(String str) 
    { 
        int n = str.length(); 
        char ch = str.charAt(0); 
        
        int i=1;
        for (i = 1; i < n; i++) 
            if(str.charAt(i) != ch) 
                break; 

        if (i == n) 
            return 0; 
  
        if (isPalindrome(str)) 
            return n-1; 
  
        return n; 
    } 
	
	protected boolean isAnagram(String strOne, String strTwo) {
		
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
	
	protected boolean isIsomorphic(String strOne, String strTwo) {

		if (strOne.length() != strTwo.length()) {
			return false;
		}

		Map<Character, Character> map = new HashMap<>();
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < strOne.length(); i++)
		{
			char x = strOne.charAt(i);
			char y = strTwo.charAt(i);

			if (map.containsKey(x)) {
				if (map.get(x) != y)
					return false;
			} else {
				if (set.contains(y))
					return false;
				map.put(x, y);
				set.add(y);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		StringPalindrome sp = new StringPalindrome();
		String input = "ABCDDCBA";
		System.out.println("Is string - "+input
							+" palindrome : "+sp.isPalindrome(input));
		
		String strOne = "Tom Marvolo Riddle";
		String strTwo = "I Am Lord Voldemort";
		
		System.out.println("\nAre string - "+strOne
							+" and "+strTwo
							+" anagrams : "+sp.isAnagram(strOne,strTwo));
		
		String strFour = "geeksogeeks";
		
		System.out.println("\nCan the characters of the string - "+strFour
							+" be rearranged to make a plaindrome : "+sp.canMakePalindrome(strFour));
		
		String strFive = "ACAB";
		String strSix = "XCXY";
		System.out.println("\nAre string - "+strFive
							+" and "+strSix
							+" isomorphic : "+sp.isIsomorphic(strFive,strSix));
		
		String strSeven = "XCXY";
        System.out.println("\nMaximum length of the largest substring which is not palindrome : "
                + sp.getMaxLenNonPalindromeSubstring(strSeven)); 
	}
}
