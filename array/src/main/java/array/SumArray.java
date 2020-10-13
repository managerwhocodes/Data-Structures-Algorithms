package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SumArray {

	// Brute force : TC O(n^2)
	protected ArrayList<ArrayList<Integer>> findPairWithSum(int arr[], int sum) {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		if(arr.length<=1)
			return list;
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==sum) {
					ArrayList<Integer> numList = new ArrayList<Integer>();
					numList.add(i);
					numList.add(j);
					list.add(numList);
				}
			}
		}
		
		return list;
	}
	
	// Using sorting : TC O(nlogn)
	protected ArrayList<ArrayList<Integer>> findPairWithSumUseSorting(int arr[], int sum) {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		if(arr.length<=1)
			return list;
		
		Arrays.sort(arr);
		
		 int low = 0;
		 int high = arr.length-1;
		 
		 while(low<high) {
			 
			 ArrayList<Integer> numList = new ArrayList<Integer>();
					 
			 if(arr[low]+arr[high] == sum) {
				numList.add(low);
				numList.add(high); 
				list.add(numList);
			 }
			 
			 if(arr[low]+arr[high] < sum)
				 low ++;
			 else
				 high --; 
		 }
		return list;
	}
	
	// Using HashMap : TC O(nlogn)
	protected ArrayList<ArrayList<Integer>> findPairWithSumUseHash(int arr[], int sum) {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		if(arr.length<=1)
			return list;
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(sum - arr[i])) {
				ArrayList<Integer> numList = new ArrayList<Integer>();
				numList.add(map.get(sum - arr[i]));
				numList.add(i);				
				list.add(numList);
			} else {
				map.put(arr[i], i);
			}
		}				
		return list;		
	}
	
	
	// Brute Force : TC O(n^2)
	protected boolean ifSubArrayWithZeroSum(int []arr) {
		
		if(arr.length<=0)
			return false;
		
		for(int i=0;i<arr.length;i++) {
			int sum = arr[i];
			for(int j=i+1;j<arr.length;j++) {
				sum = sum + arr[j];
				if(sum == 0)
					return true;
			}
		}
		return false;
	}
	
	// Using HashSet
	protected boolean ifSubArrayWithZeroSumUseHash(int[] arr)
	{

		Set<Integer> set = new HashSet<Integer>();

		set.add(0);

		int sum = 0;

		for (int value : arr) {
			sum += value;

			if (set.contains(sum)) {
				return true;
			}
			set.add(sum);
		}
		return false;
	}
	
	protected void maximumSum(Integer[] input) {

		Arrays.sort(input, Comparator.reverseOrder());

		int x = 0;
		for (int i = 0; i < input.length; i = i + 2) {
			x = x * 10 + input[i];
		}

		int y = 0;
		for (int i = 1; i < input.length; i = i + 2) {
			y = y * 10 + input[i];
		}

		System.out.println("The two numbers with maximum sum are "
									+ x + " and " + y);
	}



	public static void main(String[] args) {

		SumArray sa = new SumArray();
		int input[] = {8, 7, 2, 5, 3, 1};
		int sum = 10;
		
		System.out.println("Input array : "+Arrays.toString(input));
		System.out.println("Input sum value : "+sum);
		
		System.out.println("Index pair for which value equals given sum");
		for(ArrayList list : sa.findPairWithSum(input, sum))
			System.out.println(list.toString());
				
		for(ArrayList list : sa.findPairWithSumUseHash(input, sum))
			System.out.println(list.toString());
		
		for(ArrayList list : sa.findPairWithSumUseSorting(input, sum))
			System.out.println(list.toString());
		
		int inputTwo[] = {4, 2, -3, -1, 0, 4};
		System.out.println("Is there any sub array with zero sum : "+sa.ifSubArrayWithZeroSum(inputTwo));
		System.out.println("Is there any sub array with zero sum : "+sa.ifSubArrayWithZeroSumUseHash(inputTwo));
	}
}
