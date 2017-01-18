package arrays.strings;

import helper.AssortedMethods;

public class RotateMatrix
{
	public static void main(String[] args)
	{
		int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
		rotate(matrix);
	}

	public static void rotate(int[][] matrix)
	{
		int n = matrix.length;
		for (int i = 0; i < Math.ceil(((double) n) / 2.0); i++)
		{
			for (int j = 0; j < n / 2; j++)
			{
				int temp = matrix[i][j];

				matrix[i][j] = matrix[n - 1 - j][i];

				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

				matrix[j][n - 1 - i] = temp;
			}
		}
	}
}