
public class MinimumCostFromCornerToEndInAMatrix 
{
	public static int findMinimumCostDynamic(int[][] matrix)
	{
		int m = matrix[0].length; //# of columns
		int n = matrix.length; //# of rows

		for(int i = 1; i < m ; i++)
			matrix[0][i] += matrix[0][i-1];

		for(int j = 1; j < n ; j++)
			matrix[j][0] += matrix[j-1][0];

		for(int i = 1; i < n; i++)
		{
			for(int j = 1; j< m; j++)
			{
				matrix[i][j] += Math.min(matrix[i-1][j], matrix[i][j-1]);
			}
		}	
		return matrix[n-1][m-1];
	}
	
	public static void main(String args[])
	{
        int cost[][] = {{1,2,3},{4,8,2},{1,5,3},{6,2,9}};
        System.out.println(findMinimumCostDynamic(cost));
    }
}
