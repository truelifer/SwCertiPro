package factorial;

public class Factorial {
	public static void main(String[] args) {
		int n = 14;
		int result = factorial(n);
		System.out.println("result : " + result);
	}
	
	public static int factorial(int n) {
		if(n == 1) {
			return 1;
		}
		
		return n * factorial(n-1);
	}

}
