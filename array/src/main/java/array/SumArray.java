package array;

import java.util.ArrayList;

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

	public static void main(String[] args) {

		SumArray sa = new SumArray();
		int input[] = {8, 7, 2, 5, 3, 1};
		int sum = 10;
		
		for(ArrayList list : sa.findPairWithSum(input, sum))
			System.out.println(list.toString());
			
	}

}
