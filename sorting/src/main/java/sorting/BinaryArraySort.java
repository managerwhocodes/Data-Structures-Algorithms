package sorting;

import java.util.Arrays;

public class BinaryArraySort {
	
	protected void sort(int[] A)
	{

		int k = 0;

		for (int i: A) {

			if (i == 0) {
				A[k++] = 0;
			}
		}


		for (int i = k; i < A.length; i++) {
			A[k++] = 1;
		}
	}

	public static void main (String[] args) {
		
		BinaryArraySort bs = new BinaryArraySort();
		
		int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };
		
		System.out.println("Input Array : "+Arrays.toString(A));
		bs.sort(A);
		System.out.println("Sorted Array : "+Arrays.toString(A));
	}
}
