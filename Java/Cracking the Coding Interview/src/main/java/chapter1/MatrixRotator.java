package chapter1;

import java.util.Arrays;

/**
 * Class to rotate a N by N matrix 90 degrees
 * @author Arturo
 *
 */
public class MatrixRotator {

	/**
	 * Rotates a matrix 90 degrees clockwise in-place
	 * @param N by N matrix
	 */
	public static void rotate(int[][] matrix){
		int n = matrix.length;
		if (n == 1) return;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int aux = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = aux;
			}
		}
	}

	public static void main(String[] args){
		int[][] matrix = {{1, 2, 3, 4, 5},
						  {6, 7, 8, 9, 10},
						  {11,12,13,14,15},
						  {16,17,18,19,20},
						  {21,22,23,24,25}};
//		int[][] matrix = {{1}};
//		int[][] matrix = {{1,2},{3,4}};
//		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

}
