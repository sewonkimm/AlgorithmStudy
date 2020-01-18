import java.util.Scanner;

public class ClimbingStairs_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int[] stairs = new int[c];
		for(int i=0; i<c; i++) {
			stairs[i] = sc.nextInt();
		}
		
		int[][] dp = new int[c][2];
		dp[0][0] = stairs[0];
		dp[0][1] = 0;
		
		if(c>0) {
			dp[1][0] = stairs[0] + stairs[1];
			dp[1][1] = dp[0][0];
		}
		for(int i=2; i<c; i++) {
			dp[i][0] = Math.max(dp[i-2][1]+stairs[i-1]+stairs[i], dp[i-2][0]+stairs[i]);
			dp[i][1] = dp[i-1][0];
		}
		
		System.out.println(dp[c-1][0]);
	}
}
