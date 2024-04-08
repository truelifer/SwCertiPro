package maxNum;

import java.util.Scanner;

public class MaxNumRecursive {

	public static int N;
	public static int[] nums;
	
	public static void main(String[] args) {
		System.setIn(MaxNumRecursive.class.getResourceAsStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=0; i < t; i++) {
			N = sc.nextInt();
			nums = new int[N];
			for(int j=0; j < N; j++) {
				nums[j] = sc.nextInt();
			}
			
			int ans = solve(0,0,0);
			System.out.println("#" + i + " : " + ans);
		}
		
		sc.close();
	}
	
	public static int solve(int cnt, int used, int val) {
		if(cnt == 2) {
			return val;
		}
		
		int ret = 0;
		for(int i=0; i < N; i++) {
			if((used & (1 << i)) != 0) {
				continue;
			}
			int tmp = solve(cnt+1, used | (1 << i), val * 10 + nums[i]);
			if(tmp > ret) {
				ret = tmp;
			}
		}
		
		return ret;
	}
}
