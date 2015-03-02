package com.agodi;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(merge(array)));
	}

	private static int[] merge(int[] array) {
		if (array.length == 1) {
			return array;
		} else {
			int[] a = merge(Arrays.copyOfRange(array, 0, array.length / 2));
			int[] b = merge(Arrays.copyOfRange(array, array.length / 2,
					array.length));
			int[] c = new int[array.length];
			int j = 0;
			int k = 0;
			for (int i = 0; i < array.length; i++) {
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

}
