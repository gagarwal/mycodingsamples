public class VariableVisible {
	public static void TestVisiblity(String args[]) {

		int n,m;
		for ( m = 1; m < 100; m++) {
			System.out.println("value of variable m is " + m);
		}
		
		n=m+10;
		System.out.println("m is "+m); //99
		System.out.println("n is "+n); //109 
	}
}
