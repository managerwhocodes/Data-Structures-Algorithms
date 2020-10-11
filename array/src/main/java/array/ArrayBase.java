package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	protected int findPeakElement(int[] A, int left, int right) {

		int mid = (left + right) / 2;

		if ((mid == 0 || A[mid - 1] <= A[mid]) &&
				(mid == A.length - 1 || A[mid + 1] <= A[mid])) {
			return mid;
		}

		if (mid - 1 >= 0 && A[mid - 1] > A[mid]) {
			return findPeakElement(A, left, mid - 1);
		}

		return findPeakElement(A, mid + 1, right);
	}
	
	protected int smallestMissing(int[] A, int left, int right) {

		if (left > right) {
			return left;
		}

		int mid = left + (right - left) / 2;

		if (A[mid] == mid) {
			return smallestMissing(A, mid + 1, right);
		}
		else {
			return smallestMissing(A, left, mid - 1);
		}
	}
	
	protected int getCeil(int[] A, int x) {

		int left = 0, right = A.length - 1;

		int ceil = -1;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (A[mid] == x) {
				return A[mid];
			}
			else if (x < A[mid]) {
				ceil = A[mid];
				right = mid - 1;
			}

			else
				left = mid + 1;
		}

		return ceil;
	}
	
	protected int getFloor(int[] A, int x) {
		
		int left = 0, right = A.length - 1;

		int floor = -1;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (A[mid] == x) {
				return A[mid];
			}

			else if (x < A[mid]) {
				right = mid - 1;
			}

			else {
				floor = A[mid];
				left = mid + 1;
			}
		}

		return floor;
	}
	
	protected void equilibriumIndex(int A[]) {

		int left[] = new int[A.length];

		left[0] = 0;

		for (int i = 1; i < A.length; i++) {
			left[i] = left[i - 1] + A[i - 1];
		}

		int right = 0;

		List<Integer> indices = new ArrayList<>();

		for (int i = A.length - 1; i >= 0; i--)
		{

			if (left[i] == right) {
				indices.add(i);
			}

			right += A[i];
		}

		System.out.println("Equilibrium Index found at " + indices);
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
