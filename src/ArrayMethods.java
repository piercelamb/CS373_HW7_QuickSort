// CSE 373 Homework 7: Sort Detective
// YOU DO NOT NEED TO MODIFY THIS INSTRUCTOR-PROVIDED FILE.
// Your code should work properly with an unmodified version of this file.

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * This class contains utility methods for creating arrays of integers
 * and strings to be sorted.
 * You may call these methods in your Quicksort code if you like.
 */
public final class ArrayMethods {
	private static final Random RAND = new Random(42);   // random number generator
	
	/**
	 * Creates an array of the given length, fills it with ordered
	 * non-negative integers, and returns it.
	 * Throws an IllegalArgumentException if length < 0.
	 */
	public static int[] createAscendingIntegerArray(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("length too small: " + length);
		}
		
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		return a;
	}

	/**
	 * Creates an array of the given length, fills it with reverse-ordered
	 * non-negative integers, and returns it.
	 * Throws an IllegalArgumentException if length < 0.
	 */
	public static int[] createDescendingIntegerArray(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("length too small: " + length);
		}
		
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = a.length - 1 - i;
		}
		return a;
	}
	
	/**
	 * Creates an array of the given length, fills it with random
	 * integers, and returns it.
	 * Throws an IllegalArgumentException if length < 0.
	 */
	public static int[] createRandomIntegerArray(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("length too small: " + length);
		}
		
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = RAND.nextInt(1000000) - 250000;
		}
		return a;
	}

	/**
	 * Creates an array of the given length, fills it with ordered
	 * strings, and returns it.
	 * Throws an IllegalArgumentException if length < 0.
	 */
	public static String[] createAscendingStringArray(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("length too small: " + length);
		}
		
		// pre-generate all k-letter strings
		final String[] ALL_STRINGS = generateAllKLetterStrings(4);
		
		String[] a = new String[length];
		int each = Math.max(1, (int) Math.ceil(a.length / ALL_STRINGS.length));
		for (int i = 0; i < a.length; i++) {
			// int index = RAND.nextInt(ALL_STRINGS.length);
			int index = Math.min(ALL_STRINGS.length - 1, i / each);
			a[i] = ALL_STRINGS[index];
		}
		
		return a;
	}
	
	/**
	 * Creates an array of the given length, fills it with reverse-ordered
	 * strings, and returns it.
	 * Throws an IllegalArgumentException if length < 0.
	 */
	public static String[] createDescendingStringArray(int length) {
		String[] a = createAscendingStringArray(length);
		Collections.reverse(Arrays.asList(a));
		return a;
	}
	
	/**
	 * Creates an array of the given length, fills it with random
	 * strings, and returns it.
	 * Throws an IllegalArgumentException if length < 0.
	 */
	public static String[] createRandomStringArray(int length) {
		String[] a = createAscendingStringArray(length);
		Collections.shuffle(Arrays.asList(a));
		return a;
	}

	/**
	 * Returns true if the given array is in sorted ascending order.
	 */
	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns true if the given array is in sorted ascending order.
	 */
	public static boolean isSorted(String[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i].compareTo(a[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Swaps the values at the two given indexes in the given array.
	 * Throws an IndexOutOfBoundsException if i or j is outside of the array.
	 */
	public static final void swap(int[] a, int i, int j) {
		if (i != j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	/**
	 * Swaps the values at the two given indexes in the given array.
	 * Throws an IndexOutOfBoundsException if i or j is outside of the array.
	 */
	public static final void swap(String[] a, int i, int j) {
		if (i != j) {
			String temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
	
	/**
	 * Generates and returns an array containing all Strings of exactly k
	 * letters, in ABC order.
	 * For example: if k=2, returns {aa, ab, ac, ..., ba, bb, ..., zx, zy, zz}.
	 */
	private static String[] generateAllKLetterStrings(int k) {
		if (k < 0) {
			throw new IllegalArgumentException("negative k: " + k);
		} else if (k == 0) {
			// base case: there is only one zero-letter string, ""
			return new String[] {""};
		} else {
			// recursive case: generate strings of length k-1, then
			// concatenate all letters a-z onto each of them to make
			// all strings of length k
			final char[] LETTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			final int LETTERCOUNT = LETTERS.length;
			
			String[] prefixes = generateAllKLetterStrings(k - 1);
			String[] result = new String[prefixes.length * LETTERCOUNT];
			int i = 0;
			for (String prefix : prefixes) {
				for (char letter : LETTERS) {
					result[i++] = prefix + letter;
				}
			}
			return result;
		}
	}
}
