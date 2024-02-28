package tsp;

import java.util.Scanner;


import tsp.TspCompleteRecursive;

public class TspCompleteRecursive {

	public static int input[][];
	public static void main(String[] args) {
		System.setIn(TspCompleteRecursive.class.getResourceAsStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=0; i < t; i++) {
			int r = sc.nextInt();
			input = new int[r][r];
			for(int j=0; j < r; j++) {
				for(int k=0; k < r; k++) {
					input[j][k] = sc.nextInt();	
				}
			}
			printInput(input, r);
			for(int j=0; j < r; j++) {
				solve(j, (1 << j));
			}
		}
	}
	
	public static void printInput(int[][] input, int r) {
		for(int i=0; i < r; i++) {
			for(int j=0; j < r; j++) {
				System.out.print(input[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static int solve(int current, int visited) {
		if(visited == (1 << current+1)-1) {
			return 0;
		}
	}
}
