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
		quickSort(a, 0, a.length - 1);
		
	}
	
	private static void quickSort(String[] a, int min, int max) {
		if (min >= max) { // base case; no need to sort
		return;
		}
		// choose pivot; we'll use the first element (might be bad!)

	
		
		//find pivot, set 1st index to min element, last index to max element, middle to pivot
		
//		if (front.compareTo(end) < 0 && front.compareTo(middle) > 0 || front.compareTo(middle) < 0 && front.compareTo(end) > 0){
//			pivot = front;
//			a[(max+min)/2] = front;
//				if (middle.compareTo(end) < 0){
//					a[min] = middle;
//				}else{
//					a[min] = end;
//					a[max] = middle;
//				}
//				
//		}else if(middle.compareTo(front) < 0 && middle.compareTo(end) > 0 || middle.compareTo(end) < 0 && middle.compareTo(front) > 0){
//			pivot = middle;
//				if (front.compareTo(end) < 0){
//					
//				}else{
//					a[min] = end;
//					a[max] = front;
//				}
//		}else{
//			pivot = end;
//			a[(max+min)/2] = end;
//				if(front.compareTo(middle) < 0){
//					a[max] = middle;
//				}else{
//					a[min] = middle;
//					a[max] = front;
//				}
//		}
//		System.out.println(Arrays.toString(a));
//		System.out.println("front:  "+front);
//		System.out.println("middle: "+middle);
//		System.out.println("end:    "+end);
//		System.out.println("pivot:  "+pivot);
//		
////		if (isMedian(compare(front, end), compare(front, middle))) {
////			pivot = front;
//////			if (compare(middle, end) < 0){
//////				a[min] = middle;
//////			}else{
//////				a[min] = end;
//////				a[max] = middle;
//////			}
//////			middle = front;
////		}else if (isMedian(compare(middle, front), compare(middle, end))) {
////			pivot = middle;
//////			if (compare(front, end) < 0){
//////				
//////			}else{
//////				a[min] = end;
//////				a[max] = front;
//////			}
////			
////		}else if (isMedian(compare(end, front), compare(end, middle))) {
////			pivot = end;
//////			if (compare(middle, front) < 0){
//////				a[min] = middle;
//////				a[max] = front;
//////			}else{
//////				a[max] = middle;
//////			}
//////			middle = end;
////		}
	System.out.println(Arrays.toString(a));
	
		String pivot = medianOf3(a, 0, a.length-1);
		System.out.println(pivot);
		// partition the two sides of the array
		int center = partition(a, min, max - 1, pivot);
		System.out.println(a[center]);
		ArrayMethods.swap(a, center, max); // restore pivot to proper location
		// recursively sort the left and right partitions
		quickSort(a, min, center - 1);
		quickSort(a, center + 1, max);
		}
	private static String medianOf3(String[] a, int front, int end){ 
		int center = (front+end)/2;
		
		if (a[front].compareTo(a[center]) > 0){
			ArrayMethods.swap(a, front, center);
		}
		if( a[front].compareTo(a[end]) > 0) {
			ArrayMethods.swap(a, front, end);
		}
		if ( a[center].compareTo(a[end]) > 0){
			ArrayMethods.swap(a, center, end);
		}
		ArrayMethods.swap(a, center, end-1);
		return a[end-1];
	}
	
	private static int partition(String[] a, int i, int j, String pivot) {
		while (i <= j) {
		// move index markers i,j toward center
		// until we find a pair of out-of-order elements
		while (i <= j && a[i].compareTo(pivot) < 0) { i++; } //check to see if string natural ordering on comparator 0 is right
		while (i <= j && a[j].compareTo(pivot) > 0) { j--; }
		if (i <= j) {
		ArrayMethods.swap(a, i, j);
		i++;
		j--;
		}
		}
		return i;
		}
}
