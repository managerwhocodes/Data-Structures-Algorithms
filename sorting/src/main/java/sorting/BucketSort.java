package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BucketSort {
	int arr[];
	
	public BucketSort(int arr[]) {
		this.arr = arr;
	}
	

	public void printArray() {
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
			tmp++;
			if(tmp == 20) {
				System.out.println();
				tmp = 0;
			}
		}	
	}
	
	public void printBucket(ArrayList<Integer>[] buckets) {
		for(int i=0; i<buckets.length; i++) {
			System.out.println("\nBucket #" + i + " :");
			for (int j=0; j<buckets[i].size(); j++) {
				System.out.print(buckets[i].get(j)+" ");
			}
		}	
	}
	
	public void bucketSort() {
		
		int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		
		
		for(int value: arr) {
			if(value < minValue) {
				minValue = value;
			}else if (value > maxValue) {
				maxValue = value;
			}
		}
		
		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];

		for(int i =0;i<buckets.length;i++) {
			buckets[i] = new ArrayList<Integer>();	 
		}
		
		
		for(int value: arr) {
			int bucketNumber = (int) Math.ceil ((value *  numberOfBuckets) / maxValue);
			buckets[bucketNumber-1].add(value);
		}
				
		
		System.out.println("Buckets before Sorting : ");
		printBucket(buckets);
		

		for(ArrayList<Integer> bucket: buckets) {
			Collections.sort(bucket);
		}
		
		
		System.out.println("\nBuckets after Sorting : ");
		printBucket(buckets);	
		
		int index=0;
		for(ArrayList<Integer> bucket: buckets) {
			for(int value: bucket) {
				arr[index] = value;
				index++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int arr[] = new int[100];
		
		Random random = new Random();
		for(int i=0;i<100;i++) {
			arr[i] = random.nextInt(100)+100;
		}
		
		BucketSort bs = new BucketSort(arr);
		System.out.println("Array before Sorting: ");
		bs.printArray();
		bs.bucketSort();
		
		
		System.out.println("\n\nArray after Sorting: ");
		bs.printArray();
		
	}
}
