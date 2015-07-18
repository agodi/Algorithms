package com.agodi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to set an element's row and column
 * to zero if the element's value is zero
 * @author Arturo
 *
 */
public class ZeroMatrix {

	/**
	 * First it iterates over all the elements in the matrix to find
	 * which one has value zero.
	 * Then it sets element's column and row to zeros based on the
	 * elements index
	 * @param M by N matrix
	 */
	public static void setZeros(int[][] matrix){
		List<int[]> list = new ArrayList<int[]>();
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) {
					int[] index = {i,j};
					list.add(index);
				}
			}
		}

		for (int[] index : list) {
			for (int i = 0; i < m; i++) {
				matrix[i][index[1]] = 0;
			}

			for (int i = 0; i < n; i++) {
				matrix[index[0]][i] = 0;
			}
		}
	}

	public static void main(String[] args){
		int[][] matrix = {{0, 2, 3, 4, 5},
						  {6, 7, 8, 9, 10},
						  {11,12,0,14,15},
						  {16,17,18,19,20},
						  {21,22,23,24,0}};
		/*
		int[][] matrix = {{1}};
		int[][] matrix = {{1,2},{0,4}};
		int[][] matrix = {{1,2,3},{4,5,6},{7,0,9}};
		*/
		setZeros(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

}
