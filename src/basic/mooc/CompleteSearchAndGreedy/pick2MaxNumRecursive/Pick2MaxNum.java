package basic.mooc.CompleteSearchAndGreedy.pick2MaxNumRecursive;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pick2MaxNum {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(Pick2MaxNum.class.getResourceAsStream("sample_input.txt"));

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int testcase=1; testcase <= TC; ++testcase) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println();
		}
	}
}