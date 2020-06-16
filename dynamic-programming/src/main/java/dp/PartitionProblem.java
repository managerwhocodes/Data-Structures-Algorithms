package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionProblem {

	
	private boolean subsetSum(int[] S, int n, int a, int b, int c, Map<String, Boolean> lookup) {

		if (a == 0 && b == 0 && c == 0) {
			return true;
		}
	
		if (n < 0) {
			return false;
		}
	
		String key = a + "|" + b + "|" + c + "|" + n;

		if (!lookup.containsKey(key)) {

			boolean A = false;
			if (a - S[n] >= 0) {
				A = subsetSum(S, n - 1, a - S[n], b, c, lookup);
			}
	

			boolean B = false;
			if (!A && (b - S[n] >= 0)) {
				B = subsetSum(S, n - 1, a, b - S[n], c, lookup);
			}
	
		
			boolean C = false;
			if ((!A && !B) && (c - S[n] >= 0)) {
				C = subsetSum(S, n - 1, a, b, c - S[n], lookup);
			}
	
			lookup.put(key, A || B || C);
		}
	

		return lookup.get(key);
	}
	
	protected boolean partition(int[] S) {
		
		if (S.length < 3) {
			return false;
		}

		Map<String, Boolean> lookup = new HashMap<String, Boolean>();

		int sum = Arrays.stream(S).sum();

		return (sum % 3) == 0 && subsetSum(S, S.length - 1, sum/3,
											sum/3, sum/3, lookup);
	}

	public static void main(String[] args) {
		
		PartitionProblem pp = new PartitionProblem();
		
		int[] S = { 7, 3, 2, 1, 5, 4, 8 };

		System.out.print("Can we partition the input array in 3 disjoint sets with the same sum : ");
		if (pp.partition(S)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
