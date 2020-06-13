package dc;

public class PeakElement {
	
	protected int findPeakElement(int[] A, int left, int right) {

		int mid = (left + right) / 2;

		if ((mid == 0 || A[mid - 1] <= A[mid]) &&
				(mid == A.length - 1 || A[mid + 1] <= A[mid])) {
			return mid;
		}

		if (mid - 1 >= 0 && A[mid - 1] > A[mid]) {
			return findPeakElement(A, left, mid - 1);
		}

		return findPeakElement(A, mid + 1, right);
	}

	public static void main(String[] args) {
		PeakElement pe = new PeakElement();
		
		int[] A = { 8, 9, 10, 12, 2, 6 };
		int index = pe.findPeakElement(A, 0, A.length - 1);
		
		System.out.println("The peak element is " + A[index]);

	}
}
