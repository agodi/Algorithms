package com.agodi;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(sort(array)));
	}

	private static int[] sort(int[] array) {
		if (array.length == 1) {
			return array;
		} else {
			int[] a = sort(Arrays.copyOfRange(array, 0, array.length / 2));
			int[] b = sort(Arrays.copyOfRange(array, array.length / 2,
					array.length));
			int[] c = merge(a, b);
			return c;
		}
	}

	private static int[] merge(int[] a, int []b) {
		int[] c = new int[a.length + b.length];
		int j = 0;
		int k = 0;
		for (int i = 0; i < c.length; i++) {
			if (j >= a.length) {
				c[i] = b[k];
				k++;
			} else if (k >= b.length) {
				c[i] = a[j];
				j++;
			} else if (a[j] <= b[k]) {
				c[i] = a[j];
				j++;
			} else {
				c[i] = b[k];
				k++;
			}
		}
		return c;
	}

}
