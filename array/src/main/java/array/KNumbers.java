package array;

import java.util.ArrayList;
import java.util.List;
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

	}
}
