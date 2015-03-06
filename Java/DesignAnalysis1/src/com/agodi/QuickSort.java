package com.agodi;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sort(array, 0, array.length);
		System.out.println(Arrays.toString(array));
	}

	public static void sort(int[] array, int i, int j) {
        if(i==j) return;
		int pivotIndex = partition(array, i, j);
		sort(array, i, pivotIndex);
		sort(array, pivotIndex + 1, j);
	}

	private static int partition(int[] array, int i, int j) {
		System.out.println(Arrays.toString(array));
		int index = i;//new Random().nextInt(j-i) + i;
		int pivot = array[index];
        System.out.println(pivot);
		array[index] = array[i];
		index = i;
		array[i] = pivot;
        System.out.println(Arrays.toString(array));
        i++;
        j--;
		while(i < j) {
			while(i < array.length && array[i] < pivot) {
                System.out.println(array[i]);
                i++;}
			while(j >=0 && array[j] > pivot) {
                System.out.println(array[j]);
                j--;}
            if(i<j) {
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
			System.out.println(Arrays.toString(array));
		}
        i--;
		array[index] = array[i];
		array[i] = pivot;
		System.out.println(Arrays.toString(array));
		return i;
	}

}
