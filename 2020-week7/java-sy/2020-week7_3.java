package codeup;

import java.util.Scanner;

public class MemoryTest7_3007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] number = new int[n];
		for(int i=0; i<n; i++) {
			number[i] = sc.nextInt();
		}
		
		int[] dp = new int[n];
		
		dp[0] = number[0];
		for(int i=1; i<n; i++) {
			dp[i] = dp[i-1] + number[i];
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(b==1) System.out.println(dp[a-1]);
			else if(a==1) System.out.println(dp[b-1]);
			else System.out.println(dp[b-1]-dp[a-2]);
		}
	}
}
