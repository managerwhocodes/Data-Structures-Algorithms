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
	
	protected int findMinDifference(int[] A, int x, int y) {
		
		int n = A.length;
		int xIndex = n, yIndex = n;
		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {

			if (A[i] == x) {
				xIndex = i;

				if (yIndex != n) {
					minDiff = Integer.min(minDiff,
										   Math.abs(xIndex - yIndex));
				}
			}

			if (A[i] == y) {
				yIndex = i;

				if (xIndex != n) {
					minDiff = Integer.min(minDiff,
										   Math.abs(xIndex - yIndex));
				}
			}
		}
		return minDiff;
	}

	protected void findMaximumProduct(int[] A)
	{

		int max1 = A[0], max2 = Integer.MIN_VALUE;
		int min1 = A[0], min2 = Integer.MAX_VALUE;

		for (int i = 1; i < A.length; i++) {

			if (A[i] > max1) {
				max2 = max1;
				max1 = A[i];
			} else if (A[i] > max2) {
				max2 = A[i];
			}

			if (A[i] < min1) {
				min2 = min1;
				min1 = A[i];
			} else if (A[i] < min2) {
				min2 = A[i];
			}
		}

		if (max1 * max2 > min1 * min2) {
			System.out.print("Pair is (" + max1 + ", " + max2 + ")");
		}
		else {
			System.out.print("Pair is (" + min1 + ", " + min2 + ")");
		}
	}
	
	protected boolean canPairsWithEvenSum(int[] arr, int n) {

	    if (n % 2 == 1)
	        return false;
	 
	    int oddCount = 0, evenCount = 0;
	 
	    for(int i = 0; i < n; i++) {
	         
	        // Count even element
	        if (arr[i] % 2 == 0)
	        	evenCount++;
	        else
	        	oddCount++;
	    }
	 
	    if (evenCount % 2 == 0 && 
	    		oddCount % 2 == 0) {
	        return true;
	    }
	    return false;
	}
	
	protected int closestVal(int arr[], int N, int K)	{

		int res = arr[0];

		for(int i = 1; i < N; i++)  {
			if (Math.abs(K - res) > Math.abs(K - arr[i])) {
				res = arr[i];
			}
		}
		return res;
	}
	
	protected boolean isPrime(int n) {
	    if (n <= 1)
	        return false;
	 
	    for(int i = 2; i * i <= n; i++) 
	    {
	        if (n % i == 0)
	            return false;
	    }
	    return true;
	}
	
	protected void countSmallerPrimes(int ar[], int N) {
	    
		for(int i = 0; i < N; i++) {

	        int count = 0;
	        for(int j = i + 1; j < N; j++) 
	        {
	            if (ar[j] <= ar[i] && isPrime(ar[j])) {
	                count++;
	            }
	        }
	        System.out.print(count + " ");
	    }
	}
	
	// Function that finds the sum of all the element of subarrays of odd length
	protected int oddLengthSumofSubArray(int []arr) {
	     
	    int sum = 0;
	    int l = arr.length;
	 
	    for(int i = 0; i < l; i++)  {     
	        sum += (((i + 1) * (l - i) + 1) / 2) * arr[i];
	    }
	 
	    return sum;
	}
	
	protected boolean containsUniqueElement(int arr[]) {

        int x = arr[0];
        int flag = 1;
 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != x) {
                flag = 0;
                break;
            }
        }
 
        if (flag == 1)
            return true;
        else
            return false;
    }
	
	public static void main(String[] args) {
		
		ArrayBase arrayBase = new ArrayBase();
		
		int[] arr = { -1, 5, 4, 2, 0, 3, 1 };

		if (arrayBase.checkConsecutive(arr)) {
			System.out.println("Array contains consecutive integers");
		} else {
			System.out.println("Array do not contain consecutive integers");
		}
		System.out.println(arrayBase.oddLengthSumofSubArray(arr));
	}
}
