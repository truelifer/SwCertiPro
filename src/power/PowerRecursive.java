package power;

public class PowerRecursive {

	public static void main(String[] args) {
		int x = 3;
		int n = 3;
		int result = powerRecursive(x, n);
		System.out.println(result);
	}
	
	public static int powerRecursive(int x, int n) {
		if(n == 0) {
			return 1;
		} else if(n == 1) {
			return x;
		}
		
		return x * powerRecursive(x, n-1);
	}
}
