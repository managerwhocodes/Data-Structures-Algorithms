package sorting;

public class SelectionSort {
	
	protected void selectionSort(int[] a) {
		for (int j = 0; j<a.length; j++) {
			int minimumIndex = j;
			for (int i=j+1; i<a.length; i++) {
				if (a[i] < a[minimumIndex])
					minimumIndex = i;
			}
			if (minimumIndex != j) {
				int temp = a[j];
				a[j] = a[minimumIndex];
				a[minimumIndex] = temp;
			}
		}
	}
	
	protected void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void main(String []args) {
		int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
		SelectionSort ss = new SelectionSort();
		
		System.out.print("Before Sorting : ");
		ss.printArray(array);
		
		ss.selectionSort(array);
		
		System.out.print("\nAfter sorting : ");
		ss.printArray(array);
	}
}