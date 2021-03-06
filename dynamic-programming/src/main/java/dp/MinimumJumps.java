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
	
	
	protected int findMinFee(int[] fee) {
	    int dp[] = new int[fee.length + 1]; 
	    dp[0] = 0; 
	    dp[1] = fee[0]; 
	    dp[2] = dp[3] = fee[0];

	    for (int i = 3; i < fee.length; i++)
	      dp[i + 1] = Math.min(fee[i] + dp[i], Math.min(fee[i - 1] + dp[i - 1], fee[i - 2] + dp[i - 2]));

	    return dp[fee.length];
	  }


	public static void main(String[] args) {
		
		MinimumJumps jumps = new MinimumJumps();
		
		int[] inputArrOne = { 1, 3, 6, 1, 0, 9 };
		int[] lookup = new int[inputArrOne.length];
		
		System.out.println("Input Array : "+Arrays.toString(inputArrOne));
		
		if(jumps.findMinJumps(inputArrOne, 0) == Integer.MAX_VALUE)
			System.out.println("Jump not possible till the end");
		else
			System.out.println("Minimum jumps required to reach the end using recursion : " +
				jumps.findMinJumps(inputArrOne,0));

		if(jumps.findMinJumpsTopDown(inputArrOne, 0, inputArrOne.length, lookup) == Integer.MAX_VALUE)
			System.out.println("Jump not possible till the end");
		else
			System.out.println("Minimum jumps required to reach the end using top-down approach : " +
				jumps.findMinJumpsTopDown(inputArrOne, 0, inputArrOne.length, lookup));
		
		if(jumps.findMinJumpsBottomUp(inputArrOne) == Integer.MAX_VALUE || jumps.findMinJumpsBottomUp(inputArrOne) == Integer.MIN_VALUE)
			System.out.println("Jump not possible till the end");
		else
			System.out.println("Minimum jumps required to reach the end using bottom-up approach : " +
				jumps.findMinJumpsBottomUp(inputArrOne));
		
		int[] inputArrTwo = { 4,2,2,1,0,8,1 };
		lookup = new int[inputArrTwo.length];
		
		System.out.println("\nInput Array : "+Arrays.toString(inputArrTwo));
		
		if(jumps.findMinJumps(inputArrTwo, 0) == Integer.MAX_VALUE)
			System.out.println("Jump not possible till the end");
		else
			System.out.println("Minimum jumps required to reach the destination using recursion : " +
				jumps.findMinJumps(inputArrTwo,0));

		if(jumps.findMinJumpsTopDown(inputArrTwo, 0, inputArrTwo.length, lookup) == Integer.MAX_VALUE)
			System.out.println("Jump not possible till the end");
		else
			System.out.println("Minimum jumps required to reach the destination using top-down approach : " +
				jumps.findMinJumpsTopDown(inputArrTwo, 0, inputArrTwo.length, lookup));
		
		if(jumps.findMinJumpsBottomUp(inputArrTwo) == Integer.MAX_VALUE || jumps.findMinJumpsBottomUp(inputArrTwo) == Integer.MIN_VALUE)
			System.out.println("Jump not possible till the end");
		else
			System.out.println("Minimum jumps required to reach the destination using bottom-up approach : " +
				jumps.findMinJumpsBottomUp(inputArrTwo));
		
		
		int[] fee = { 1, 2, 5, 2, 1, 2 };
	    System.out.println(jumps.findMinFee(fee));
	    fee = new int[] { 2, 3, 4, 5 };
	    System.out.println(jumps.findMinFee(fee));

	}
}
