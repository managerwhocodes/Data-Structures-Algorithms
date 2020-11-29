package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StringPermutation {

	protected List<String> getPermutation(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        List<String> resultList = new ArrayList<>();
              
        char result[] = new char[input.length];
        char charValue[] ;
        int count[] ;
        
        for (char ch : input) {
           countMap.computeIfPresent(ch, (k,v) -> v+1);
           countMap.putIfAbsent(ch, 1);
        }
        
        charValue = new char[countMap.size()];
        count = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
        	charValue[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        
        permutationUtil(charValue, count, result, 0, resultList);        
        return resultList;
    }

    private void permutationUtil(char ch[], int count[], char result[], int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < ch.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = ch[i];
            count[i]--;
            permutationUtil(ch, count, result, level + 1, resultList);
            count[i]++;
        }
    }
    
    protected List<String> getLexicographic(String str) {
    	String res = "";
    	List<String> result = new ArrayList<String>();
    	
    	getLexicographicUtil(str,res,result);
    	return result;
    }
    
    protected void getLexicographicUtil(String str, String res, List<String> result) {

    	if (res.length() == str.length()) {
    		result.add(res);
    		return;
    	}

    	for(int i = 0; i < str.length(); i++) {
    		while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1))
    			i++;

    		getLexicographicUtil(str, res + str.charAt(i), result);
    	}
    }
    
    private String getNextLexicographic(String str) {
    	String output = "";
       	
    	char []chars = str.toCharArray();
    	if(chars.length == 0 || chars.length == 1)
    		return output;
    	
    	int i = chars.length - 1;
    	int j = chars.length - 1;
    	
		while (chars[i - 1] >= chars[i])
		{
			if (--i == 0) {
				return output;
			}
		}
		
		while (j > i && chars[j] <= chars[i - 1]) {
			j--;
		}
    	
		swap(chars, i-1, j);
		reverse(chars, i);

		return new String(chars);
    }
    
    protected void interleavings(String curr, String X, String Y, Set<String> result) {

		if (X.length() == 0 && Y.length() == 0) {
			result.add(curr);
			return;
		}

		if (X.length() > 0) {
			interleavings(curr + X.charAt(0), X.substring(1), Y, result);
		}

		if (Y.length() > 0) {
			interleavings(curr + Y.charAt(0), X, Y.substring(1), result);
		}
	}
    
    protected void groupAnagrams(String[] words) {

		List<String> list = Arrays.stream(words)
				.map(s -> s.toCharArray())
				.map(chars -> { Arrays.sort(chars); return new String(chars); })
				.collect(Collectors.toList());

		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++)
		{
			map.putIfAbsent(list.get(i), new ArrayList<>());
			map.get(list.get(i)).add(i);
		}

		for (Entry<String, List<Integer>> entry: map.entrySet()) {
			System.out.println(entry.getValue().stream()
							.map(index -> words[index])
							.collect(Collectors.toList()));
		}
	}
    
	protected List<String> findCombinations(List<List<Character>> keypad, int[] input) {

		List<String> outputList = new ArrayList<>();
		

		for (Character ch: keypad.get(input[0])) {
			outputList.add(String.valueOf(ch));
		}
		
		for (int i = 1; i < input.length; i++) {
			List<String> prevList = new ArrayList<>(outputList);
			outputList.clear();
		
			for (Character ch: keypad.get(input[i])) {
				for (String s: prevList) {
					outputList.add(s + ch);
				}
			}
		}
		
		return outputList;
	}
    
    private void swap(char[] chars, int i, int j) {
		char ch = chars[i];
		chars[i] = chars[j];
		chars[j] = ch;
	}
    
    private void reverse(char[] chars, int start) {
		for (int i = start, j = chars.length - 1; i < j; i++, j--) {
			swap(chars, i, j);
		}
	}
    
    protected List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null)
          return permutations;

        permutations.add(str);

        for (int i = 0; i < str.length(); i++) {
        	if (Character.isLetter(str.charAt(i))) {

        		int n = permutations.size();
        		for (int j = 0; j < n; j++) {
        			char[] chs = permutations.get(j).toCharArray();

        			if (Character.isUpperCase(chs[i]))
        				chs[i] = Character.toLowerCase(chs[i]);
        			else
        				chs[i] = Character.toUpperCase(chs[i]);
        			permutations.add(String.valueOf(chs));
        		}
        	}
        }
        return permutations;
    }
    
    
    protected List<List<Integer>> findSubsets(int[] nums) {

    	Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
        	startIndex = 0;

        	if (i > 0 && nums[i] == nums[i - 1])
        		startIndex = endIndex + 1;
        	endIndex = subsets.size() - 1;
        	for (int j = startIndex; j <= endIndex; j++) {
        		List<Integer> set = new ArrayList<>(subsets.get(j));
        		set.add(nums[i]);
        		subsets.add(set);
        	}
        }
        return subsets;
    }
    
    protected List<String> generateGeneralizedAbbreviation(String word) {
		List<String> result = new ArrayList<String>();
		generateAbbreviationRecursive(word, new StringBuilder(), 0, 0, result);
		return result;
    }

    private void generateAbbreviationRecursive(String word, StringBuilder abWord, int start, int count, List<String> result) {
	
    	if (start == word.length()) {
    		if (count != 0)
    			abWord.append(count);
    		result.add(abWord.toString());
	    } else {

	    	generateAbbreviationRecursive(word, new StringBuilder(abWord), start + 1, count + 1, result);
	
	    	if (count != 0)
	    		abWord.append(count);
	    	generateAbbreviationRecursive(word, new StringBuilder(abWord).append(word.charAt(start)), start + 1, 0, result);
	    }
    }
    
    protected void printAllCombinations(List<List<String>> list, String res, int n) {

    	if (n == list.size()) {
    		System.out.println(res.substring(1));
    		return;
    	}
	
    	int m = list.get(n).size();
	
    	for (int i = 0; i < m; i++) {

    		String out = res + " " + list.get(n).get(i);
    		printAllCombinations(list, out, n + 1);
    	}
	}
	
    	protected boolean isAnagram(String str1, String str2) {
		
	    if (str1.length() != str2.length())
		return false;

	    int count = 0;

	    for(int i = 0; i < str1.length(); i++) {
		count = count + str1.charAt(i);
	    }
		
	    for(int i = 0; i < str2.length(); i++) {
		count = count - str2.charAt(i);
	    }
	    return (count == 0);
	}	
    
    public static void main(String args[]) {
    	
        StringPermutation sp = new StringPermutation();
        
        String input = "SBC"; 
        String lexInput = "dkhc";
        
		List<String> resultListOne = sp.getPermutation(input.toCharArray());	
		System.out.println("All the permutations of the input string without char repetition - "+input+" : "); 
		for(String s : resultListOne)
			System.out.println(s);
		
		System.out.println("All the permutations of the input string with char repetition- "+input+" : "); 
		List<String> resultListTwo = sp.getLexicographic(new String(input.toCharArray()));
		for(String s : resultListTwo)
			System.out.println(s);
		
		System.out.println("The next lexicographic string for - "+"a"+" : "+sp.getNextLexicographic("a"));
		System.out.println("The next lexicographic string for - "+lexInput+" : "+sp.getNextLexicographic(lexInput));
		
		
		String X = "ABC";
		String Y = "ACB";

		Set<String> result = new HashSet<>();
		sp.interleavings("", X, Y, result);
		System.out.println("All the interleavings of string "+X+" and "+Y+" : ");
		result.stream().forEach(System.out::println);
		
		List<List<Character>> keypad = Arrays.asList(
				Arrays.asList(),
				Arrays.asList(),
				Arrays.asList( 'A', 'B', 'C' ),
				Arrays.asList( 'D', 'E', 'F' ),
				Arrays.asList( 'G', 'H', 'I' ),
				Arrays.asList( 'J', 'K', 'L' ),
				Arrays.asList( 'M', 'N', 'O' ),
				Arrays.asList( 'P', 'Q', 'R', 'S'),
				Arrays.asList( 'T', 'U', 'V' ),
				Arrays.asList( 'W', 'X', 'Y', 'Z')
				);


		int[] inputArray = { 2, 3, 4 };

		List<String> output = sp.findCombinations(keypad, inputArray);
		System.out.println(output);
		
		String[] words = {
				"CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
				"PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
				"SUED", "LEAN", "SCAR", "DESIGN"
		};

		sp.groupAnagrams(words);
		
		System.out.println("String permutations are: " + sp.findLetterCaseStringPermutations("ab7c"));
		
	    System.out.println("Generalized abbreviation are: " + sp.generateGeneralizedAbbreviation("BAT"));
	    
	    List<List<String>> wordlist = Arrays.asList(
				Arrays.asList("John", "Emma"),
				Arrays.asList( "Plays", "Hates", "Watches" ),
				Arrays.asList( "Cricket", "Soccer", "Chess" )
			);

	    sp.printAllCombinations(wordlist, "", 0);
        
    }
}
