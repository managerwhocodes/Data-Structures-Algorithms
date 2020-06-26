package dp;

import java.util.Arrays;

public class MinimumJumps {

	// Top-Down Approach
	protected int findMinJumpsTopDown(int[] arr, int i, int n, int lookup[]) {

		if (i == n - 1) {
			return 0;
		}

		if (i >= n || arr[i] == 0) {
			return Integer.MAX_VALUE;
		}

		if (lookup[i] != 0) {
			return lookup[i];
		}

		int min_jumps = Integer.MAX_VALUE;
		
		for (int j = i + 1; j <= i + arr[i]; j++) {
			int cost = findMinJumpsTopDown(arr, j, n, lookup);
			if (cost != Integer.MAX_VALUE) {
				min_jumps = Math.min(min_jumps, cost + 1);
			}
		}
		return (lookup[i] = min_jumps);
	}
	
	// Bottom-Up Approach
	protected int findMinJumpsBottomUp(int[] arr) {

		int n = arr.length;
		
		if (arr[0] == 0) {
			return Integer.MAX_VALUE;
		}

		int[] lookup = new int[n];
		Arrays.fill(lookup, Integer.MAX_VALUE);

		lookup[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; (i + j < n) && j <= Math.min(n - 1, arr[i]); j++) {
				lookup[i + j] = (lookup[i + j] != Integer.MAX_VALUE) ?
								Math.min(lookup[i + j], lookup[i] + 1): (lookup[i] + 1);
			}
		}
		return lookup[n - 1];
	}

	public static void main(String[] args) {
		
		MinimumJumps jumps = new MinimumJumps();
		
		int[] arr = { 1, 3, 6, 1, 0, 9 };
		int[] lookup = new int[arr.length];

		System.out.println("Minimum jumps required to reach the destination using top-down approach : " +
				jumps.findMinJumpsTopDown(arr, 0, arr.length, lookup));
		
		System.out.println("Minimum jumps required to reach the destination using bottom-up approach : " +
				jumps.findMinJumpsBottomUp(arr));

	}
}