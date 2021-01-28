package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.Random; 

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
	
	protected void randomize(int arr[], int n) { 
	
		Random r = new Random(); 

		for (int i = n-1; i > 0; i--) { 

		    int j = r.nextInt(i+1); 

		    int temp = arr[i]; 
		    arr[i] = arr[j]; 
		    arr[j] = temp; 
		} 
	} 
	
	protected void arrangeEvenAndOdd(int arr[], int n){ 
       
        	int i = -1, j = 0; 
        	while (j != n) { 
            		if (arr[j] % 2 == 0) 
			{ 
				i++; 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
            	j++; 
        } 
       
        // Printing segregated array 
        for (int k = 0; k < n; k++) 
             System.out.print(arr[k] + " "); 
    } 
	
	protected int minStepsToRearrangeToPower(int arr[], int n) { 

        	Arrays.sort(arr); 
        	int ans = 0; 
  
        	for (int i = 0; i < n; i++) { 
            		ans += Math.abs(arr[i] - Math.pow(2, i)); 
        	} 
        	return ans; 
    	} 
	
	
	
	protected Set<Integer> findDuplicates(int[] input) {
        	Set<Integer> duplicates = new HashSet<Integer>();

        	for (int i = 0; i < input.length; i++) {
            		for (int j = 1; j < input.length; j++) {
                		if (input[i] == input[j] && i != j) {
           				duplicates.add(input[i]);
                    			break;
                		}
            		}
        	}

        	return duplicates;
    	}

	protected void updateArrayByNextElement(int arr[], int n) { 

	    for (int i = 0; i <= n - 2; i++) 
		arr[i] = arr[i + 1]; 

	    arr[n - 1] = -1;
	} 
	
	// Replace every array element by sum of previous and next
	protected void updateArrayBySumOfElements(int arr[], int n) {  

		if (n <= 1) {  
		    return;  
		}  
		int prev = arr[0];  
		arr[0] = arr[0] + arr[1];  
  

        	for (int i = 1; i < n - 1; i++) {  
            		int curr = arr[i];  
            		arr[i] = prev + arr[i + 1];  
            		prev = curr;  
        	}  
        	arr[n - 1] = prev + arr[n - 1];  
	}  
	
	protected int findLastOccurrence(int[] arr, int x) {

	    int left = 0;
	    int right = arr.length - 1;
	    int result = -1;

	    while (left <= right) {

		int mid = (left + right) / 2;

		if (x == arr[mid]) {
		    result = mid;
		    left = mid + 1;
		} else if (x < arr[mid]) {
		    right = mid - 1;
		} else {
		    left = mid + 1;
		}
	    }
	    return result;
	}

	protected int findFirstOccurrence(int[] arr, int x) {

	    int left = 0;
	    int right = arr.length - 1;
	    int result = -1;

	    while (left <= right) {

		int mid = (left + right) / 2;
		    
		if (x == arr[mid]) {
		    result = mid;
		    right = mid - 1;
		} else if (x < arr[mid]) {
		    right = mid - 1;
		} else {
		    left = mid + 1;
		}
	    }
	    return result;
	}
	
	// Function to find minimum index of repeating element
	protected int findMinIndex(int[] arr)
	{
		int minIndex = arr.length;
		Set<Integer> set = new HashSet<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (set.contains(arr[i])) {
				minIndex = i;
			}
			else {
				set.add(arr[i]);
			}
		}
		return minIndex;
	}
	
	// find duplicate element in limited range array
	protected int findDuplicate(int[] arr)
	{

		boolean visited[] = new boolean[arr.length + 1];

		for (int value : arr) {
			if (visited[value]) {
				return value;
			}
			visited[value] = true;
		}
		return -1;
	}
	
	protected void splitAndMoveStartToEnd(int arr[], int length, int rotation) { 
		
		int tmp[length * 2] = {0}; 

		for(int i = 0; i < length; i++) { 
			tmp[i] = arr[i]; 
			tmp[i + length] = arr[i]; 
		} 

		for(int i = rotation; i < rotation + length; i++) { 
			arr[i - rotation] = tmp[i]; 
		} 
	} 
	
	protected int countDecreasingSubarrays(int arr[]) { 

	    int count = 0;
	    int subArrayLength = 1; 

	    for (int i = 0; i < arr.length - 1; ++i) { 

		if (arr[i + 1] < arr[i]) {
		    subArrayLength++; 
		} else { 
		    count += (((subArrayLength - 1) * subArrayLength) / 2); 
		    subArrayLength = 1; 
		} 
	    } 

	    if (subArrayLength > 1) 
		count += (((subArrayLength - 1) * subArrayLength) / 2); 

	    return count; 
	}
	
	protected void shuffle(int arr[]) { 
    
	    Random r = new Random(); 

	    for (int i = arr.length; i > 0; i--) { 

		int j = r.nextInt(i+1); 
		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 
	    } 
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
