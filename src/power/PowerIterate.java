package power;

public class PowerIterate {
	public static void main(String[] args) {
		int x = 3;
		int n = 3;
		int result = powerIterate(x, n);
		System.out.println(result);
	}
	
	public static int powerIterate(int x, int n) {
		int result = 1;
		for(int i=n; i > 0; i--) {
			result = result * x;
		}
		
		return result;
	}
}
