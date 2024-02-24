package fileIo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class SampleInput {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(SampleInput.class.getResourceAsStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		char input[][] = new char[r][c];
		
		for(int i=0; i < r; i++) {
			String str = sc.next();
			for(int j=0; j < c; j++) {
				input[i][j] = str.charAt(j);
			}
		}
		
		printInput(input, r, c);
	}
	
	public static void printInput(char[][] input, int r, int c) {
		for(int i=0; i < r; i++) {
			for(int j=0; j < c; j++) {
				System.out.print(input[i][j]);
			}
			System.out.println();
		}
	}
}
