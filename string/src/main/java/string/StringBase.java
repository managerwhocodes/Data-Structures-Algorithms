package string;

import java.util.Stack;

public class StringBase {

	protected void findNdigitNums(String res, int n, int sum) {

		if (n > 0 && sum >= 0) {
			char d = '0';
			if (res.equals("")) {	
				d = '1';
			}

			while (d <= '9') {
				findNdigitNums(res + d, n - 1, sum - (d - '0'));
				d++;
			}
		}

		else if (n == 0 && sum == 0) {
			System.out.print(res + " ");
		}
	}
	
	protected void findNdigitNumsWithEqualSum(String res, int n, int diff) {

		if (n > 0) {
			char ch = '0';

			if (res.equals("")) {
				ch = '1';
			}

			while (ch <= '9') {
				int absdiff;

				if ((n & 1) != 0) {
					absdiff = diff + (ch - '0');
				}
				else {
					absdiff = diff - (ch - '0');
				}

				findNdigitNums(res + ch, n - 1, absdiff);
				ch++;
			}
		}

		else if (n == 0 && Math.abs(diff) == 0) {
			System.out.println(res);
		}
	}
	
	protected String removeAdjDup(String str) {

		char[] chars = str.toCharArray();
		char prev = chars[0];

		int k = 0;
		int i = 1;

		while (i < chars.length) {

			if (prev != chars[i]) {
				chars[++k] = chars[i++];
				prev = chars[k];			
			}
			else {
				while (i < chars.length && prev == chars[i]) {
					i++;
				}
				prev = chars[--k];
			}
		}
		return new String(chars).substring(0, k + 1);
	}
	
	protected int findMaxLenOfBalancedParanthesis(String str) {

		Stack<Integer> stack = new Stack<>();

		stack.push(-1);
		int len = 0;

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(') {
				stack.push(i);
			} else {

				stack.pop();

				if (stack.empty()) {
					stack.push(i);
					continue;
				}

				int curr_len = i - stack.peek();

				if (len < curr_len) {
					len = curr_len;
				}
			}
		}
		return len;
	}
	
	
	protected boolean isConsonant(char ch) { 

		ch = Character.toUpperCase(ch); 
		return !(ch == 'A' || ch == 'E' ||  
			ch == 'I' || ch == 'O' ||  
			ch == 'U') && ch >= 65 && ch <= 90; 
    	} 
   
    	protected int countConsonants(String str) { 
		
		int count = 0; 
		for (int i = 0; i < str.length(); i++)  
		    if (isConsonant(str.charAt(i))) 
			++count; 
		return count; 
    	} 
	
	protected boolean isVowel(char ch) { 
		
		ch = Character.toUpperCase(ch); 
		return (ch=='A' || ch=='E' || ch=='I' || 
				   ch=='O' || ch=='U'); 
    	} 
       
    	protected int countVowels(String str) { 
		
        	int count = 0; 
        	for (int i = 0; i < str.length(); i++) 
        	     if (isVowel(str.charAt(i)))
                	++count; 
        	return count; 
    	} 
	
	protected void swap(char[] c, int i, int j) {
		char ch = c[i];
		c[i] = c[j];
		c[j] = ch;
	}


	protected int findMinimumNoWithKSwaps(char[] c, int n, int k, int minSoFar) {

		String s = new String(c);

		if (s.compareTo(String.valueOf(minSoFar)) < 0) {
			minSoFar = Integer.valueOf(s);
		}

		if (k < 1) {
			return minSoFar;
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (c[i] > c[j]) {
					swap(c, i, j);
					minSoFar = findMinimumNoWithKSwaps(c, n, k - 1, minSoFar);
					swap(c, i, j);
				}
			}
		}
		return minSoFar;
	}
	
	protected String removeVowels(String str) { 
		
		 Character vowels[] = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'}; 

		 List<Character> al = Arrays.asList(vowels); 

		 StringBuffer sb = new StringBuffer(str); 

		 for (int i = 0; i < sb.length(); i++) { 

		     if(al.contains(sb.charAt(i))){ 
			sb.replace(i, i+1, "") ; 
			i--; 
		     } 
		} 
		return sb.toString(); 
    	} 
	
	protected String reverseVowel(String str) { 
        	
		int j = 0; 

        	char[] ch = str.toCharArray(); 
        	String vowel = ""; 
		
		for (int i = 0; i < ch.length; i++) { 
		    if (isVowel(ch[i])) { 
			j++; 
			vowel += ch[i]; 
		    } 
		} 
  
		for (int i = 0; i < ch.length; i++) { 
		    if (isVowel(ch[i])) { 
			ch[i] = vowel.charAt(--j); 
		    } 
		} 
  
        	return String.valueOf(ch); 
    	} 
	
	protected int countNonEmptySubstrings(String str) { 
        	int n = str.length(); 
        	return n * (n + 1) / 2; 
    	} 
	
	
	protected int countWords(String str) { 
          
		if (str == null || str.isEmpty()) 
		    return 0; 

		String[] words = str.split("\\s+"); 
		
		return words.length; 
    	} 
	
	protected int countPairs(String s1, int n1, String s2, int n2) { 

	    int []freq1 = new int[26]; 
	    int []freq2 = new int[26]; 

	    Arrays.fill(freq1, 0); 
	    Arrays.fill(freq2, 0); 

	    int i, count = 0; 

	    for (i = 0; i < n1; i++) 
		freq1[s1.charAt(i) - 'a']++; 

	    for (i = 0; i < n2; i++) 
		freq2[s2.charAt(i) - 'a']++; 

	    for (i = 0; i < 26; i++) 
		count += (Math.min(freq1[i], freq2[i])); 

	    return count; 
	} 
	
	protected void convertCase(StringBuffer str) { 
        
		int ln = str.length(); 
             
		for (int i=0; i<ln; i++) { 
		    Character c = str.charAt(i); 
		    if (Character.isLowerCase(c)) 
			str.replace(i, i+1, Character.toUpperCase(c)+""); 
		    else
			str.replace(i, i+1, Character.toLowerCase(c)+""); 
		} 
     	} 
	
	
	protected boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++)
		    if (Character.isDigit(s.charAt(i)) == false)
			return false;

		return true;
    	}
	
	protected String swapFirstAndLastChar(String str) { 
  
	    if (str.length() < 2) 
		return str; 

	    char[] ch = str.toCharArray(); 
	    char temp = ch[0]; 
	    ch[0] = ch[ch.length - 1]; 
	    ch[ch.length - 1] = temp; 

	    return String.valueOf(ch); 
	} 
	
	protected char firstUpperCaseChar(String str) { 
	    for (int i = 0; i < str.length(); i++) 
		if (Character.isUpperCase(str.charAt(i))) 
		    return str.charAt(i); 
	    return 0; 
	}
	
	protected int countSubstringWithEqualEnds(String str) { 

	    int result = 0; 
	    int n = str.length(); 
	    int[] count =  new int[26]; 

	    for (int i = 0; i < n; i++) 
		count[str.charAt(i)-'a']++; 

	    for (int i = 0; i < 26; i++) 
		result += (count[i] * (count[i] + 1) / 2); 

	    return result; 
	} 
	
	protected void splitString(String str) { 

	    StringBuffer alpha = new StringBuffer(),  
			 num = new StringBuffer(), 
			 special = new StringBuffer(); 

	    for (int i=0; i<str.length(); i++) 
	    { 
		if (Character.isDigit(str.charAt(i))) 
		    num.append(str.charAt(i)); 
		else if(Character.isAlphabetic(str.charAt(i))) 
		    alpha.append(str.charAt(i)); 
		else
		    special.append(str.charAt(i)); 
	    } 

	    System.out.println(alpha); 
	    System.out.println(num); 
	    System.out.println(special); 
	}

	public static void main(String[] args) {

		StringBase sb = new StringBase();
		
		int n = 3;
		int sum = 6;

		String res = "";
		sb.findNdigitNums(res, n, sum);
	}

}
