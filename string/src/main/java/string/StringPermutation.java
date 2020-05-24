package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    
    public static void main(String args[]) {
        StringPermutation sp = new StringPermutation();
        String input = "SBC"; 
        
		List<String> resultListOne = sp.getPermutation(input.toCharArray());	
		System.out.println("All the permutations of the input string without char repetition - "+input+" : "); 
		for(String s : resultListOne)
			System.out.println(s);
		
		System.out.println("All the permutations of the input string with char repetition- "+input+" : "); 
		List<String> resultListTwo = sp.getLexicographic(new String(input.toCharArray()));
		for(String s : resultListTwo)
			System.out.println(s);
        
    }
}
