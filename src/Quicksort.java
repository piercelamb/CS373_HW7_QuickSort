// TODO: Remove each 'todo' comment once I implement each part!

// TODO: class comment header

import java.util.Arrays;

public class Quicksort {
	// lengths of arrays to test (input size N)
	private static final int[] LENGTHS = {
		10, 20, 40, 80, 160, 320, 640, 1000, 2000, 4000, 8000, 16000, 32000, 64000,
		128000, 256000, 512000, 1000000, 2000000, 4000000, 8000000, 16000000
	};

	public static void main(String[] args) {
		for (int N : LENGTHS) {
			// String[] a = ArrayMethods.createAscendingStringArray(N);
			// String[] a = ArrayMethods.createDescendingStringArray(N);
			String[] a = ArrayMethods.createRandomStringArray(N);

			// perform a sort and time how long it takes
			long startTime1 = System.currentTimeMillis();
			quickSort(a);
			long endTime1 = System.currentTimeMillis();
			
			// make sure the array is sorted afterward
			if (!ArrayMethods.isSorted(a)) {
				throw new RuntimeException("not sorted afterward: " + Arrays.toString(a));
			}

			// print runtime stats
			System.out.printf("%10d elements  =>  %6d ms \n", N, endTime1 - startTime1);
		}
	}
	
	
	// TODO: comment header
	public static void quickSort(String[] a) {
		// TODO: implement this method
		
	}
}
