package maxNum;

import java.util.Scanner;

// TODO not fully understood
public class MaxNumCombinationIterative {

	public static int N;
	public static int[] nums;
	
	public static void main(String[] args) {
		System.setIn(MaxNumCombinationIterative.class.getResourceAsStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=0; i < t; i++) {
			N = sc.nextInt();
			nums = new int[N];
			for(int j=0; j < N; j++) {
				nums[j] = sc.nextInt();
			}
			
			int ans = solve();
			System.out.println("#" + i + " : " + ans);
		}
		
		sc.close();
	}
	
	public static int solve() {
		int ret = 0;
		for(int i=0; i < (1 << N); i++) {
			if(countBits(i) == 2) {
				int sum = 0;
				for(int j=0; j < N; j++) {
					if((i & (1 << j)) != 0) {
						sum += nums[j];
					}
				}
				if(sum > ret) {
					ret = sum;
				}
			}
		}
		
		return ret;
	}
	
	public static int countBits(int value) {
		int count = 0;
		while(value > 0) {
			if((value & 1) == 1) {
				count++;
			}
			value = value >> 1;
		}
		
		return count;
	}
}
