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
	
	public void rightRotate(int[] arr, int r) {
		
		if(r > arr.length || r < 0)
			return;
		
		// Reverse the last 'k' elements
		reverse(arr, arr.length - r, arr.length - 1);

		// Reverse the first 'n-k' elements
		reverse(arr, 0, arr.length - r - 1);

		// Reverse the whole array
		reverse(arr, 0, arr.length - 1);
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
	
	public int findSmallestMissingElement(int array[], int start, int end) { 
        if (start > end) 
            return end + 1; 
  
        if (start != array[start]) 
            return start; 
  
        int mid = (start + end) / 2; 
  
        if (array[mid] == mid) 
            return findSmallestMissingElement(array, mid+1, end); 
  
        return findSmallestMissingElement(array, start, mid); 
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
