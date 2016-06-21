import helper.AssortedMethods;

public class RotateMatrix {

//	public static void rotate(int[][] matrix, int n) {
//		for (int layer = 0; layer < n / 2; ++layer) {
//			int first = layer;
//			int last = n - 1 - layer;
//			for (int i = first; i < last; ++i) {
//				int offset = i - first;
//				int top = matrix[first][i]; // save top
//
//				// left -> top
//				matrix[first][i] = matrix[last - offset][first];
//
//				// bottom -> left
//				matrix[last - offset][first] = matrix[last][last - offset];
//
//				// right -> bottom
//				matrix[last][last - offset] = matrix[i][last];
//
//				// top -> right
//				matrix[i][last] = top; // right <- saved top
//				
//				System.out.println();
//				AssortedMethods.printMatrix(matrix);
//			}
//		}
//	}

	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
		//AssortedMethods.printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		//AssortedMethods.printMatrix(matrix);
	
	}
	public static void rotate(int[][] matrix)
    {
		AssortedMethods.printMatrix(matrix);
		System.out.println();
	    int n = matrix.length;
	    for (int i = 0; i < Math.ceil(((double) n) / 2.0); i++)
	    {
		    for (int j = 0; j <  n / 2; j++)
		    {
			    int temp = matrix[i][j];
			    matrix[i][j] = matrix[n-1-j][i];
			    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
			    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
			    matrix[j][n-1-i] = temp;
		    }
		    
	   }
	     AssortedMethods.printMatrix(matrix);
    }

}