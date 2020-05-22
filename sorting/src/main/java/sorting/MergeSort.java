package sorting;

public class MergeSort {

	protected void mergeSort(int[] arr, int left, int right) {
		if (right > left) {
			int m = (left + right) / 2;
			mergeSort(arr, left, m);
			mergeSort(arr, m + 1, right);
			merge(arr, left, m, right);
		}
	}

	protected void merge(int[] arr, int left, int middle, int right) {
		int [] leftTmpArray = new int[middle-left+2];
		int [] rightTmpArray = new int[right-middle+1];
		
		for(int i=0;i<=middle-left;i++)
			leftTmpArray[i]= arr[left+i];
		for(int i=0;i<right-middle;i++)
			rightTmpArray[i]= arr[middle+1+i];
		
		leftTmpArray[middle-left+1]= Integer.MAX_VALUE;
		rightTmpArray[right-middle] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int k = left; k <= right; k++) {
			if (leftTmpArray[i] < rightTmpArray[j]) {
				arr[k] = leftTmpArray[i];
				i++;
			} else {
				arr[k] = rightTmpArray[j];
				j++;
			}
		}
	}
	
	protected void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		
		MergeSort ms = new MergeSort();
		
		int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
		
		System.out.print("Before Sorting : ");
		ms.printArray(array);
		
		long start = System.nanoTime();
		ms.mergeSort(array, 0, array.length-1);
		long end = System.nanoTime();
		System.out.print("\nTime to execute merge sort : " + (end-start) + " ms");
		
		System.out.print("\nAfter Sorting : ");
		ms.printArray(array);
	}
}
