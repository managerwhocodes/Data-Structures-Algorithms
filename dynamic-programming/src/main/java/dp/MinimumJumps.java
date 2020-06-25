package dp;

public class MinimumJumps {

	// Top-Down Approach
	protected int findMinJumps(int[] arr, int i, int n, int lookup[]) {

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
			int cost = findMinJumps(arr, j, n, lookup);
			if (cost != Integer.MAX_VALUE) {
				min_jumps = Math.min(min_jumps, cost + 1);
			}
		}

		return (lookup[i] = min_jumps);
	}

	public static void main(String[] args) {
		
		MinimumJumps jumps = new MinimumJumps();
		
		int[] arr = { 1, 3, 6, 1, 0, 9 };
		int[] lookup = new int[arr.length];

		System.out.println("Minimum jumps required to reach the destination are " +
				jumps.findMinJumps(arr, 0, arr.length, lookup));

	}

}
