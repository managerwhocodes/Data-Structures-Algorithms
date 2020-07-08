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

	public static void main(String[] args) {
		
		ArrayRotation ar = new ArrayRotation();
		
		int []input = { 1, 2, 3, 4, 5 };
		int r = 2;

		System.out.println("Input Array : "+Arrays.toString(input));	
		ar.leftRotate(input, r);
		System.out.println("Left Rotating the Array by "+r+" positions");	
		System.out.println("Output Array "+Arrays.toString(input));	
	}
}
