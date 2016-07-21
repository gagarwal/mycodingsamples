package helper;

public class SumOfNFibonocciNumbers 
{
	private static int sumOfNFibonocciNumbersSum(int n)
	{
		int[] fibonocci = populateFibonocci(n);
		int[] fibonocciSum = new int[n];
		int sum = 0;

		for(int i=0; i<n; i++)
		{
			sum = sum + fibonocci[i];
			fibonocciSum[i] = sum;
		}	

		return fibonocciSum[n-1];
	}

	private static int[] populateFibonocci(int n)
	{
		int[] fibonocci = new int[n];
		fibonocci[0] = 0;
		fibonocci[1] = 1;

		for(int i = 2; i < n; i++)
			fibonocci[i] = fibonocci[i-1] + fibonocci[i-2];
		
		return fibonocci;
	}	
	
	public static void main(String[] args) 
	{
		System.out.println(sumOfNFibonocciNumbersSum(8));
	}
}
