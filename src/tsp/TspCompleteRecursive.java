package tsp;

import java.util.Scanner;


import tsp.TspCompleteRecursive;

public class TspCompleteRecursive {

	public static int graph[][];
	public static int N;
	
	public static void main(String[] args) {
		System.setIn(TspCompleteRecursive.class.getResourceAsStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=0; i < t; i++) {
			N = sc.nextInt();
			graph = new int[N][N];
			for(int j=0; j < N; j++) {
				for(int k=0; k < N; k++) {
					graph[j][k] = sc.nextInt();	
				}
			}
			
			printInput(graph, N);
			
			int ans = Integer.MAX_VALUE;
			for(int j=0; j < N; j++) {
				int tmp = solve(j, 1 << j);
				if(tmp < ans) {
					ans = tmp;
				}
			}
			
			System.out.println("#" + N + " : " + ans);
		}
		
		sc.close();
	}
	
	public static void printInput(int[][] input, int N) {
		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) {
				System.out.print(input[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static int solve(int current, int visited) {
		if(visited == ((1 << N) - 1)) {
			return 0;
		}
		
		int ret = Integer.MAX_VALUE;
		for(int next=0; next < N; next++) {
			if((visited & (1 << next)) == 0 && graph[current][next] != 0) {
				int tmp = graph[current][next] + solve(next, visited | (1 << next));
				if(tmp < ret) {
					ret = tmp;
				}	
			}
		}
		
		return ret;
	}
}
