package array;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ArrayBase {

	public boolean checkConsecutive(int[] A) {

		Set<Integer> set = Arrays.stream(A).boxed()
								.collect(Collectors.toCollection(TreeSet::new));
		if (set.size() != A.length)
			return false;

		int prev = Integer.MAX_VALUE;

		for (int curr: set) {
			if (prev != Integer.MAX_VALUE && (curr != prev + 1)) {
				return false;
			}
			prev = curr;
		}
		return true;
	}

	
	public static void main(String[] args) {
		
		ArrayBase arrayBase = new ArrayBase();
		
		int[] A = { -1, 5, 4, 2, 0, 3, 1 };

		if (arrayBase.checkConsecutive(A)) {
			System.out.print("Array contains consecutive integers");
		} else {
			System.out.print("Array do not contain consecutive integers");
		}
	}
}
