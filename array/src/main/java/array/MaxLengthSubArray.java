package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxLengthSubArray {

	protected void getMaxLengthSubArray(int[] A, int S) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		map.put(0, -1);

		int sum = 0;
		int len = 0;
		int ending_index = -1;

		for (int i = 0; i < A.length; i++) {

			sum += A[i];
			map.putIfAbsent(sum, i);

			if (map.containsKey(sum - S) && len < i - map.get(sum - S)) {
				len = i - map.get(sum - S);
				ending_index = i;
			}
		}
		
		System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
	}


	public static void main(String[] args) {
		
		MaxLengthSubArray maxLength = new MaxLengthSubArray();
		
		int[] input = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
		int sum = 8;

		System.out.println("Input Array : "+Arrays.toString(input));
		System.out.println("Sum : "+sum);	
		System.out.print("Index of the maximum length Sub-Array with the sum : ");
		maxLength.getMaxLengthSubArray(input, sum);
		
	}
}
