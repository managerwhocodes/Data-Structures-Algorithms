package sorting;

public class InsertionSort {
	
	protected void insertionSort(int [] A) {
		 for(int  i = 1 ; i<A.length;i++) {  
			 int  tmp=A[i], j=i;
		     while ( j>0 && A[j-1]>tmp ) {	
		        A[j]=A[j-1];
		        j--;
		     }
		     A[j] = tmp;
		 }
	}
	
	protected void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}

	public static void main(String[] args) {
		
		InsertionSort sort = new InsertionSort();
		int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
		
		System.out.print("Before Sorting : ");
		sort.printArray(array);
		
		long start = System.nanoTime();
		sort.insertionSort(array);
		long end = System.nanoTime();
		System.out.print("\nTime to execute Insertion sort : " + (end-start) + " ms");
		
		System.out.print("\nAfter sorting : ");
		sort.printArray(array);

	}
}
