package sorting;

public class BubbleSort {

	protected void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) 
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}
	
	protected void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int arr[] = {10, 5, 30, 15, 50, 6};
		
		System.out.print("Array to be sorted :");
		bs.printArray(arr);

		bs.bubbleSort(arr);

		System.out.print("Sorted Array : ");
		bs.printArray(arr);

	}

}
