package printBits;

public class PrintBits {

	public static void main(String[] args) {
		for(int i= -5; i < 6; i++) {
			System.out.printf("%3d = ", i);
			printBits(i);
			System.out.println();
		}

	}
	
	public static void printBits(int n) {
		for(int i=7; i >= 0; i--) {
			if((n & (1 << i)) == 0) {
				System.out.print("0");
			} else {
				System.out.print("1");
			}
		}
	}

}
