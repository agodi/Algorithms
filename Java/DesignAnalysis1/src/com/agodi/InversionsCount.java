package com.agodi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class InversionsCount {
	
	public static void main(String[] args) throws IOException {
		int[] array = { 6,5,4,3,2,1,0 };
//		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Arturo\\Dropbox\\Capturas pantalla\\IntegerArray.txt"));
//		String number = null;
//		int[] array = new int[100000];
//		int i=0;
//		while((number=br.readLine()) != null) {
//			array[i] = Integer.valueOf(number);
//			i++;
//		}
//		br.close();
		System.out.println(mergeAndCount(array));
	}

	private static InversionsTuple mergeAndCount(int[] array) {
		if (array.length == 1) {
			return new InversionsTuple(array, 0);
		} else {
			InversionsTuple a = mergeAndCount(Arrays.copyOfRange(array, 0, array.length / 2));
			InversionsTuple b = mergeAndCount(Arrays.copyOfRange(array, array.length / 2,
					array.length));
			int[] c = new int[array.length];
			int inversionsCount = 0;
			int j = 0;
			int k = 0;
			for (int i = 0; i < array.length; i++) {
				if (j >= a.getSortedArray().length) {
					c[i] = b.getSortedArray()[k];
					k++;
				} else if (k >= b.getSortedArray().length) {
					c[i] = a.getSortedArray()[j];
					j++;
				} else if (a.getSortedArray()[j] <= b.getSortedArray()[k]) {
					c[i] = a.getSortedArray()[j];
					j++;
				} else {
					c[i] = b.getSortedArray()[k];
					k++;
					inversionsCount += a.getSortedArray().length - j;
				}
			}
			return new InversionsTuple(c, inversionsCount + a.getInversions() + b.getInversions());
		}
	}
	
	static class InversionsTuple {
		private int[] sortedArray;
		private long inversions;
		
		InversionsTuple(int[] array, long count) {
			this.sortedArray = array;
			this.inversions = count;
		}

		public int[] getSortedArray() {
			return sortedArray;
		}

		public void setSortedArray(int[] sortedArray) {
			this.sortedArray = sortedArray;
		}

		public long getInversions() {
			return inversions;
		}

		public void setInversions(int inversions) {
			this.inversions = inversions;
		}
		
		public String toString() {
			return "Inversions: " + inversions + " Sorted array: " + Arrays.toString(sortedArray);
		}
	}

}
