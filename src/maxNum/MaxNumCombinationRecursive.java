package maxNum;

import java.util.Scanner;

public class MaxNumCombinationRecursive {

	public static int N;
	public static int[] nums;
	
	public static void main(String[] args) {
		System.setIn(MaxNumCombinationRecursive.class.getResourceAsStream("input.txt"));
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
	
	public static int solve(int pos, int cnt, int val) {
		if(cnt == 2) {
			return val;
		}
		if(pos == N) {
			return -1;
		}
		
		int ret = 0;
		int tmp;
		tmp = solve(pos + 1, cnt + 1, val + nums[pos]);
		if(tmp >  ret) {
			ret = tmp;
		}

		// TODO : not fully understood
		tmp = solve(pos+1, cnt, val);
		if(tmp >  ret) {
			ret = tmp;
		}
		
		return ret;
	}
}
