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
    
    public static void main(String args[]) {
        StringPermutation sp = new StringPermutation();
        String input = "AABC"; 
        
		List<String> resultList = sp.getPermutation(input.toCharArray());	
		System.out.println("All the permutations of the input string - "+input+" : "); 
		for(String s : resultList)
			System.out.println(s);
        
    }
}
