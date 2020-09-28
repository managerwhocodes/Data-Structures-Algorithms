package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KNumbers {

	protected List<Integer> findKLargestNumbers(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

		for (int i = 0; i < k; i++)
			minHeap.add(nums[i]);
		
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		
		return new ArrayList<>(minHeap);
	}
	
	protected int findKthSmallestNumber(int[] nums, int k) {
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

	    for (int i = 0; i < k; i++)
	      maxHeap.add(nums[i]);

	    for (int i = k; i < nums.length; i++) {
	    	if (nums[i] < maxHeap.peek()) {
	    		maxHeap.poll();
	    		maxHeap.add(nums[i]);
	    	}
	    }

	    return maxHeap.peek();
	 }
	
	protected int minimumCostToConnectRopes(int[] ropeLengths) {
	    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

	    for (int i = 0; i < ropeLengths.length; i++)
	      minHeap.add(ropeLengths[i]);

	    int result = 0, temp = 0;
	    while (minHeap.size() > 1) {
	    	temp = minHeap.poll() + minHeap.poll();
			result += temp;
			minHeap.add(temp);
	    }

	    return result;
	}
	
	protected List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

	    Map<Integer, Integer> numFrequencyMap = new HashMap<>();
	    for (int n : nums)
	    	numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);

	    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2) -> e1.getValue() - e2.getValue());
 
	    for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
	    	minHeap.add(entry);
	    	if (minHeap.size() > k) {
	    		minHeap.poll();
	    	}
	    }

	    List<Integer> topNumbers = new ArrayList<>(k);
	    while (!minHeap.isEmpty()) {
	    	topNumbers.add(minHeap.poll().getKey());
	    }
	    	
	    return topNumbers;
	}
	
	protected String sortCharacterByFrequency(String str) {

	    Map<Character, Integer> characterFrequencyMap = new HashMap<>();
    	for (char chr : str.toCharArray()) {
    		characterFrequencyMap.put(chr, characterFrequencyMap.getOrDefault(chr, 0) + 1);
    	}

	    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
	        (e1, e2) -> e2.getValue() - e1.getValue());

	    maxHeap.addAll(characterFrequencyMap.entrySet());

	    StringBuilder sortedString = new StringBuilder(str.length());
	    
	    while (!maxHeap.isEmpty()) {
	    	Map.Entry<Character, Integer> entry = maxHeap.poll();
	    	for (int i = 0; i < entry.getValue(); i++)
	    		sortedString.append(entry.getKey());
	    }
	    return sortedString.toString();
	}
	
	protected int findMaximumDistinctElements(int[] nums, int k) {
		int distinctElementsCount = 0;
	    if (nums.length <= k)
	    	return distinctElementsCount;

	    Map<Integer, Integer> numFrequencyMap = new HashMap<>();
	    	for (int i : nums)
	    		numFrequencyMap.put(i, numFrequencyMap.getOrDefault(i, 0) + 1);

	    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(
	        (e1, e2) -> e1.getValue() - e2.getValue());

	    for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
	    	if (entry.getValue() == 1)
	    		distinctElementsCount++;
	    	else
	    		minHeap.add(entry);
	    }

	    while (k > 0 && !minHeap.isEmpty()) {
	    	Map.Entry<Integer, Integer> entry = minHeap.poll();
	    	k -= entry.getValue() - 1;
	    	if (k >= 0)
	    		distinctElementsCount++;
	    }

	    if (k > 0)
	      distinctElementsCount -= k;

	    return distinctElementsCount;
	}
	
	protected int findSumOfElements(int[] nums, int k1, int k2) {
	    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

	    for (int i = 0; i < nums.length; i++)
	      minHeap.add(nums[i]);
	
	    for (int i = 0; i < k1; i++)
	      minHeap.poll();
	
	    int elementSum = 0;

	    for (int i = 0; i < k2 - k1 - 1; i++)
	      elementSum += minHeap.poll();
	
	    return elementSum;
	}
	
	public static void main(String[] args) {
		
		KNumbers kNums = new KNumbers();
		
		List<Integer> result = kNums.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
	    System.out.println("Top K numbers: " + result);

	    result = kNums.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
	    System.out.println("Top K numbers: " + result);
	    
	    int results = kNums.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
	    System.out.println("Kth smallest number is: " + results);

	    results = kNums.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
	    System.out.println("Minimum cost to connect ropes: " + result);
	    
	    results = kNums.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
	    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

	}
}
