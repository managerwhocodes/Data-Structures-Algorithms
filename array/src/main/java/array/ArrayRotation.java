package array;

import java.util.Arrays;

public class ArrayRotation {
	
	protected void leftRotate(int[] arr, int r) {
		
		if(r > arr.length || r < 0)
			return;
		
		// Reverse the first 'r' elements
		reverse(arr, 0, r - 1);

		// Reverse the remaining 'n-r' elements
		reverse(arr, r, arr.length - 1);

		// Reverse the whole array
		reverse(arr, 0, arr.length - 1);
	}
	
	protected void rightRotate(int[] arr, int r) {
		
		if(r > arr.length || r < 0)
			return;
		
		// Reverse the last 'k' elements
		reverse(arr, arr.length - r, arr.length - 1);

		// Reverse the first 'n-k' elements
		reverse(arr, 0, arr.length - r - 1);

		// Reverse the whole array
		reverse(arr, 0, arr.length - 1);
	}
	
	protected void splitArrayAddFirstToLast(int arr[], int k, int n) 
	{ 
		reverse(arr, 0, n - 1); 
		reverse(arr, 0, n - k - 1); 
		reverse(arr, n - k, n - 1); 
	} 
	
	protected void swap(int[] arr, int i, int j) {
		int data = arr[i];
		arr[i] = arr[j];
		arr[j] = data;
	}

	protected void reverse(int[] arr, int low, int high) {
		for (int i = low, j = high; i < j; i++, j--) {
			swap(arr, i, j);
		}
	}
	
	protected int findSmallestMissingElement(int array[], int start, int end) { 
        if (start > end) 
            return end + 1; 
  
        if (start != array[start]) 
            return start; 
  
        int mid = (start + end) / 2; 
  
        if (array[mid] == mid) 
            return findSmallestMissingElement(array, mid+1, end); 
  
        return findSmallestMissingElement(array, start, mid); 
    } 
	
	protected int countRotationToSort(int[] arr, int low, int high) {  
		if (low > high) {  
		    return 0;  
		}  
  
        	int mid = low + (high - low) / 2;  
  
		if (mid < high && arr[mid] > arr[mid + 1]) {  
		    return mid + 1;  
		}  
  
		if (mid > low && arr[mid] < arr[mid - 1]) {  
		    return mid;  
		}  
   
		if (arr[mid] > arr[low]) {  
		    return countRotation(arr, mid + 1, high);  
		}  
  
		if (arr[mid] < arr[high]) {  
		    return countRotation(arr, low, mid - 1);  
		}  else {  
            		int rightIndex = countRotation(arr, mid + 1, high);  
           		int leftIndex = countRotation(arr, low, mid - 1);  
  
		    if (rightIndex == 0) {  
			return leftIndex;  
		    }  
            	return rightIndex;  
        	}  
    	}

	public static void main(String[] args) {
		
		ArrayRotation ar = new ArrayRotation();
		
		int []input = { 1, 2, 3, 4, 5 };
		int rLeft = 2;
		int rRight = 2;

		System.out.println("Input Array : "+Arrays.toString(input));	
		ar.leftRotate(input, rLeft);
		System.out.println("Left Rotating the Array by "+rLeft+" positions");	
		System.out.println("Output Array "+Arrays.toString(input));	
				
		ar.rightRotate(input, rRight);
		System.out.println("Right Rotating the Array by "+rRight+" positions");	
		System.out.println("Output Array "+Arrays.toString(input));	
	}
}
