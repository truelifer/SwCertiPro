package babyGin;

import java.util.Scanner;

public class BabyGinBruteForceRecursive {
	public static int[] nums;
	
	public static void main(String[] args) {
		System.setIn(BabyGinBruteForceRecursive.class.getResourceAsStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=0; i < t; i++) {
			nums = new int[6];
			for(int j=0; j < 6; j++) {
				nums[j] = sc.nextInt();
			}
			
			int arr[] = new int[6];
			int ans = solve(arr, 0, 0);
			System.out.println("#" + i + " : " + ans);
		}
		
		sc.close();
	}
	
	public static int solve(int[] arr, int pos, int used) {
		if(pos == 6) {
			int run = 0;
			int tri = 0;
			for(int i=0; i < 2; i++) {
				if(((arr[i*3] + 1) == arr[i*3+1]) && ((arr[i*3+1] + 1) == arr[i*3+2])) {
					run++;
				} else if((arr[i*3] == arr[i*3+1]) && arr[i*3+1] == arr[i*3+2]) {
					tri++;
				}
			}
			
			if(run+tri == 2) {
				return 1;
			}
			
			return 0;
		}
		
		for(int i=0; i < 6; i++) {
			if((used & (1 << i)) != 0) {
				continue;
			}
			
			arr[pos] = nums[i];
			if(solve(arr, pos+1, used | (1 << i)) == 1) {
				return 1;
			}
		}
		
		return 0;
	}
}
