package heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KElements {
	
	protected int findKthSmallest(List<Integer> A, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(A);

		while (--k > 0) {
			pq.poll();
		}

		return pq.peek();
	}

	public static void main(String[] args) {
		
		KElements kElements = new KElements();
		
		List<Integer> A = Arrays.asList(7, 4, 6, 3, 9, 1);
		int k = 3;

		System.out.println("K'th smallest element in the array is " +
				kElements.findKthSmallest(A, k));

	}

}
