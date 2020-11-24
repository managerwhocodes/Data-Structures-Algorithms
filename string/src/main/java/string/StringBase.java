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

	public static void main(String[] args) {

		StringBase sb = new StringBase();
		
		int n = 3;
		int sum = 6;

		String res = "";
		sb.findNdigitNums(res, n, sum);
	}

}
