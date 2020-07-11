package dp;

import java.util.Arrays;

public class MinimumJumps {
	
	
	protected int findMinJumps(int[] arr, int start) {

		// Base condition : start = end
		if(start == arr.length-1)
			return 0;
		
		// Base condition : no jumps from start
		if(arr[start] == 0)
			return Integer.MAX_VALUE;
		
		// Base condition : reached the end
		if(arr.length - start <= arr[start]){
            return 1;
        }
		
		int minJumps = Integer.MAX_VALUE;
		
		for(int i=1; i<=arr[start];i++) {
			int cost = findMinJumps(arr, start+i);
			if(cost != Integer.MAX_VALUE)
				minJumps = Math.min(minJumps, cost+1);
		}
		
		return minJumps;
	}


	// Top-Down Approach
	protected int findMinJumpsTopDown(int[] arr, int start, int arrLength, int lookup[]) {
		
		// Base condition : start = end
		if (start == arrLength - 1) {
			return 0;
		}

		// Base condition : no jumps from start or reached the end
		if (start >= arrLength || arr[start] == 0) {
			return Integer.MAX_VALUE;
		}

		if (lookup[start] != 0) {
			return lookup[start];
		}

		int minJumps = Integer.MAX_VALUE;
		
		for (int j = start + 1; j <= start + arr[start]; j++) {
			int cost = findMinJumpsTopDown(arr, j, arrLength, lookup);
			if (cost != Integer.MAX_VALUE) {
				minJumps = Math.min(minJumps, cost + 1);
			}
		}
		return (lookup[start] = minJumps);
	}
	
	// Bottom-Up Approach
	protected int findMinJumpsBottomUp(int[] arr) {

		int arrLength = arr.length;
		
		// Base condition : no jumps from start
		if (arr[0] == 0) {
			return Integer.MAX_VALUE;
		}

		int[] lookup = new int[arrLength];
		
		Arrays.fill(lookup, Integer.MAX_VALUE);
		lookup[0] = 0;

		for (int i = 0; i < arrLength; i++) {
			for (int j = 1; (i + j < arrLength) && j <= Math.min(arrLength - 1, arr[i]); j++) {
				lookup[i + j] = (lookup[i + j] != Integer.MAX_VALUE) ?
								Math.min(lookup[i + j], lookup[i] + 1): (lookup[i] + 1);
			}
		}
		return lookup[arrLength - 1];
	}

	public static void main(String[] args) {
		
		MinimumJumps jumps = new MinimumJumps();
		
		int[] arr = { 1, 3, 6, 1, 0, 9 };
		int[] lookup = new int[arr.length];
		
		
		if(jumps.findMinJumps(arr, 0) == Integer.MAX_VALUE)
			System.out.println("Jump not possible till the end");
		else
			System.out.println("Minimum jumps required to reach the destination using recursion : " +
				jumps.findMinJumps(arr,0));

		if(jumps.findMinJumpsTopDown(arr, 0, arr.length, lookup) == Integer.MAX_VALUE)
			System.out.println("Jump not possible till the end");
		else
			System.out.println("Minimum jumps required to reach the destination using top-down approach : " +
				jumps.findMinJumpsTopDown(arr, 0, arr.length, lookup));
		
		if(jumps.findMinJumpsBottomUp(arr) == Integer.MAX_VALUE)
			System.out.println("Jump not possible till the end");
		else
			System.out.println("Minimum jumps required to reach the destination using bottom-up approach : " +
				jumps.findMinJumpsBottomUp(arr));

	}
}
