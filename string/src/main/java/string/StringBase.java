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
	
	protected void printInitials(String name) { 

	    if (name.length() == 0) 
		return; 

	    String words[] = name.split(" "); 
	    for(String word : words) { 
		System.out.print(Character.toUpperCase(word.charAt(0)) + " "); 
	    } 
	}
	
	protected boolean checkIfConcat(String str1, String str2) {

	    int lengthStr1 = str1.length();
	    int lengthStr2 = str2.length();

	    if (lengthStr1 % lengthStr2 != 0) {
		return false;
	    }

	    for(int i = 0; i < lengthStr1; i++) {
		if (str1.charAt(i) != 
		    str2.charAt(i % lengthStr2)) {
		    return false;
		}
	    }
	    return true;
	}
	
	protected String mirrorChars(String str, int n) { 

	    String reverseAlphabet = "zyxwvutsrqponmlkjihgfedcba"; 
	    int strLength = str.length(); 
	    String answer = ""; 

	    for (int i = 0; i < n; i++) 
		answer = answer + str.charAt(i); 

	    for (int i = n; i < strLength; i++) 
		answer = answer + reverseAlphabet.charAt(str.charAt(i) - 'a'); 

	    return answer; 
	}
	
	protected ArrayList<String> generateStringUsingSpace(String str) {
 
	    ArrayList<String> strList = new ArrayList<String>();

	    if (str.length() == 1) {
		strList.add(str);
		return strList;
	    }

	    ArrayList<String> strListTemp = generateStringUsingSpace(str.substring(1, str.length()));

	    for (int i = 0; i < strListTemp.size(); i++) {
		strList.add(str.charAt(0) + strListTemp.get(i));
		strList.add(str.charAt(0) + " " + strListTemp.get(i));
	    }

	    return strList;
	}

	protected boolean isLeftOrRightShiftEqual(String str) {   

	    boolean check = true;  

	    for(int i = 0; i < str.length(); i++) {  
	       if (str.charAt(i) != str.charAt((i + 2) % str.length())) {  
		   check = false;  
		   break;  
	       }  
	    }     
	    return check;
	}
	
	protected String removeCharRecursive(String str, char ch) { 
      
	    // Base Case 
	    if (str.length() == 0) { 
		return ""; 
	    } 

	    if (str.charAt(0) == ch) { 
		return removeCharRecursive(str.substring(1), ch); 
	    } 

	    return str.charAt(0) + removeCharRecursive(str.substring(1), ch); 
	}
	
	protected String replaceChars(String str, char ch1, char ch2) { 
          
	    String resultStr = ""; 

	    for (int i = 0; i < str.length(); i++) { 
		if (str.charAt(i) == ch1)  
		    resultStr += ch2;  
		else
		    resultStr += str.charAt(i);    
	    } 
	    return resultStr;       
	} 
	
	protected boolean isAllCharactersSame(String str) {

	    Set<Character> charSet = new HashSet<Character>(); 

	    for(int i = 0; i < str.length(); i++)
		charSet.add(str.charAt(i));

	    if (charSet.size() == 1)
		return true;
	    else
		return false;
	}
	
	protected char findExtraCharcter(char []strA, char[] strB) { 

	    int result = 0, i; 

	    for (i = 0; i < strA.length(); i++) { 
		result ^= strA.charAt(i); 
	    } 

	    for (i = 0; i < strB.length(); i++) { 
		result ^= strB.charAt(i); 
	    } 

	    return ((char)(result)); 
	}
	
	protected char firstRepeatingChar(String str) { 

	    HashSet<Character> charMap = new HashSet<>(); 
	    char[] arr = str.toCharArray(); 

	    for(int i=0; i<=arr.length-1; i++) { 

		char chr = arr[i]; 

		if (charMap.contains(chr)) 
		    return chr; 
		else
		    charMap.add(chr); 
	    } 
	    return '\0'; 
	} 
	
	protected void countFrequencyOfWords(String str) {

	    Map<String,Integer> map = new TreeMap<>();

	    String arr[]=str.split(" ");

	    for(int i=0;i<arr.length;i++) {

		if(map.containsKey(arr[i]))
		    map.put(arr[i], map.get(arr[i])+1);
		else
		    map.put(arr[i],1);  
	    }

	    for(Map.Entry<String,Integer> entry : map.entrySet()) {
		System.out.println(entry.getKey() + " - " + entry.getValue());
	    }
	}
	
	protected String reverseWordExceptFirstAndLast(String str)  {  

	    int i = 1;  
	    int j = str.length() - 2;  

	    char[] strchar = str.toCharArray(); 

	    while (i < j) {  
		char temp = strchar[i];  
		strchar[i] = strchar[j];  
		strchar[j] = temp;  
		i++;  
		j--;  
	    }  

	    str = new String(strchar); 
	    return str;  
	}
	
	protected String removeFirstandLastOccurence(String str, char ch) { 

	    for (int i = 0; i < str.length(); i++) { 

		if (str.charAt(i) == ch) { 
		    str = str.substring(0, i) +  
			str.substring(i + 1); 
		    break; 
		} 
	    } 

	    for (int i = s.length() - 1; i > -1; i--) { 

		if (s.charAt(i) == ch) { 
		    str = str.substring(0, i) +  
			str.substring(i + 1); 
		    break; 
		} 
	    } 
	    return str; 
	}
	
	protected char maxRepeating(String str) { 

	    int count = 0; 
	    int currentCount = 1; 
	    char res = str.charAt(0); 

	    for (int i = 0; i < str.length(); i++) { 

		if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) 
		    currentCount++; 
		else { 
		    if (currentCount > count) { 
			count = currentCount; 
			res = str.charAt(i); 
		    } 
		    currentCount = 1; 
		} 
	    } 
	    return res; 
	} 
	
	protected int findLastIndex(String str, Character char) { 
	    int index = -1; 
	    for (int i = 0; i < str.length(); i++) 
		if (str.charAt(i) == char) 
		    index = i; 
	    return index; 
	} 
	
	protected boolean isWordPresent(String sentence, String word) { 

	    String []s = sentence.split(" "); 

	    for ( String temp :s) { 
		if (temp.compareTo(word) == 0) 
		    return true; 
	    } 
	    return false; 
	}
	
	protected void convertCase(StringBuffer str) { 

	    for (int i=0; i<str.length(); i++) { 
		Character c = str.charAt(i); 
		if (Character.isLowerCase(c)) 
		    str.replace(i, i+1, Character.toUpperCase(c)+""); 
		else
		    str.replace(i, i+1, Character.toLowerCase(c)+""); 
	    } 
	}
	
	protected long countNumberOfStrings(String str) {
     
	    int n = str.length() - 1;
	    long count = (long)(Math.pow(2, n));
	    return count;
	}
	
	
	
	protected boolean makeAndCheckString(List<String> words, String str) { 
	    int n = words.size(); 
	    boolean first = false, second = false; 

	    for (int i = 0; i < n; i++) { 
		if (words.get(i) == str) 
		    return true; 

		if (str.charAt(0) == words.get(i).charAt(1))  
		    first = true;          
		if (str.charAt(1) == words.get(i).charAt(0))  
		    second = true; 
		if (first && second) 
		    return true;  
	    }     
	    return false;  
	} 
	
	protected char maxRepeating(String str) { 
	    int n = str.length(); 
	    int count = 0; 
	    char res = str.charAt(0); 
	    int currentCount = 1; 

	    for (int i = 0; i < n; i++) { 

		if (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) 
		    currentCount++; 
		else { 
		    if (currentCount > count) { 
			count = currentCount; 
			res = str.charAt(i); 
		    } 
		    currentCount = 1; 
		} 
	    } 
	    return res; 
	}
	
	
	protected String concatWithUncommonChars(String s1, String s2) { 

	    String res = ""; 
	    int i; 
	    HashMap<Character, Integer> m = new HashMap<Character, Integer>(); 

	    for (i = 0; i < s2.length(); i++) {
		m.put(s2.charAt(i), 1); 
	    }

	    for (i = 0; i < s1.length(); i++) {
		if (!m.containsKey(s1.charAt(i))) 
		    res += s1.charAt(i); 
		else
		    m.put(s1.charAt(i), 2); 
	    }

	    for (i = 0; i < s2.length(); i++) {
		if (m.get(s2.charAt(i)) == 1) 
		    res += s2.charAt(i); 
	    }
	    return res; 
	}
	
	protected void addSpaceInSentence(String sentence) { 
	    char[] str=sentence.toCharArray(); 
	    String result = "";

	    for (int i=0; i < str.length; i++) { 

		if (str[i]>='A' && str[i]<='Z') { 
		    str[i] = (char)(str[i]+32); 
		    if (i != 0) 
			result = result + " "; 
		    result = result + str[i]; 
		} 
		else
		    result = result + str[i]; 
	    } 
	    retuen result;
	}
	
	protected int vowelPairs(String str, int n) { 
	    int count = 0; 
	    for (int i = 0; i < n - 1; i++) { 
		if (isVowel(s.charAt(i)) && isVowel(s.charAt(i + 1))) 
		    count++; 
	    } 
	    return count; 
	} 
	
	protected boolean areMetaStrings(String str1, String str2) { 
    
	    int len1 = str1.length(); 
	    int len2 = str2.length(); 

	    if (len1 != len2) 
		return false; 

	    int prev = -1, curr = -1; 
	    int count = 0; 

	    for (int i=0; i<len1; i++) { 

		if (str1.charAt(i) != str2.charAt(i)) { 

		    count++; 

		    if (count > 2) 
			return false; 

		    prev = curr; 
		    curr = i; 
		} 
	    } 
	    return (count == 2 && 
		    str1.charAt(prev) == str2.charAt(curr) && 
		    str1.charAt(curr) == str2.charAt(prev)); 
	} 

	public static void main(String[] args) {

		StringBase sb = new StringBase();
		
		int n = 3;
		int sum = 6;

		String res = "";
		sb.findNdigitNums(res, n, sum);
	}

}
