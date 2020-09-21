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
	
	public static void main(String[] args) {
		
		KNumbers kNums = new KNumbers();
		
		List<Integer> result = kNums.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
	    System.out.println("Top K numbers: " + result);

	    result = kNums.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
	    System.out.println("Top K numbers: " + result);

	}
}
