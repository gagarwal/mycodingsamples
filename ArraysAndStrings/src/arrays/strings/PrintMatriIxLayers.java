package arrays.strings;

import helper.AssortedMethods;

public class PrintMatriIxLayers 
{
	public static void main(String[] args) throws IllegalAccessException 
	{
		int[][] matrix = {{2,3}};
		//AssortedMethods.printMatrix(matrix);
		//printMatrixInLayers(matrix, matrix.length);
		System.out.println(parseLong("9223372036854775807"));
	}
	
	private static void printMatrixInLayers(int[][] a, int n)
	{
		if(n==0) return;
		int top = 0, bottom = n-1, left = 0, right = a[0].length-1;
		
		while( top <= bottom && left <= right)
		{
			for(int i = left; i <= right; i++)
				System.out.print(a[top][i]+" ");
			top++;
				
			for(int i = top; i <= bottom; i++)
				System.out.print(a[i][right]+" ");
			right--;
				
			for(int i = right; i >= left; i--)
				System.out.print(a[bottom][i]+" ");
			bottom--;
			
			for(int i = bottom; i >= top; i--)
				System.out.print(a[i][left]+" ");
		    left++;
		}
	}
	
	public static void stairCase(int n)
	{
		if(n<1 || n> 100)
			throw new IllegalArgumentException("given input is out of range");
		
		for(int i=1;i<=n;i++)
		{
			int j=1;
			while(j<=n-i)
			{
				System.out.print(" ");
				j++;
			}
			for(int k=1; k<=i; k++)
			{
				System.out.print("#");
			}
			System.out.println();
		}
	}
	
	public static long parseLong(String input) throws IllegalAccessException
	{
		if(input.length()==0 || input.trim().length()==0)
			throw new IllegalArgumentException("string with just white s"); 
		
		int i = 0;
		if(input.charAt(i)=='+'|| input.charAt(i)=='-')
		{
			i++;
		}
//		while(i<input.length())
//		{
//			if(charInput[i] >= '0' &&charInput[i] <='9' )
//				continue;
//			else throw new IllegalArgumentException();
//		}
//		System.out.println(getchar('1'));
	
		long output = 0;
		for(int index =0 ; index < input.length(); index++)
		{
			long value =  input.charAt(index) - '0';
			if (output*10 > Long.MAX_VALUE - value)
				throw new IllegalAccessException();
			output = (output*10L) + input.charAt(index) - '0';
		}
		
		return output;
	}
	
	//rectangular matrix, printing extra elements
//	private static void printMatrixInLayers(int[][] a)
//	{
//		int n=a.length; int width = a[0].length;
//		int top = 0, bottom = n-1, left = 0, right = width-1;
//		
//		while( top <= bottom && left <= right)
//		{
//			for(int i = left; i <= right; i++)
//				System.out.print(a[top][i]+ " ");
//			top++;
//				
//			for(int i = top; i <= bottom; i++)
//				System.out.print(a[i][right]+ " ");
//			right--;
//			//printing extra elements	
//			for(int i = right; i >= left; i--)
//				System.out.print(a[bottom][i]+ " ");
//			bottom--;
//			
//			for(int i = bottom; i >= top; i--)
//				System.out.print(a[i][left]+ " ");
//			left++;
//		}
//	}
}
