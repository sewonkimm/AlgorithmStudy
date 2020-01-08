import java.util.Scanner;

public class RGBDistance_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] cost = new int[n][3];
		int[][] dp = new int[n][3];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			if(i==0) {
				dp[i][0] = cost[i][0];
				dp[i][1] = cost[i][1];
				dp[i][2] = cost[i][2];
				continue;
			}
			
			dp[i][0] = Math.min(dp[i-1][1]+cost[i][0], dp[i-1][2]+cost[i][0]);
			dp[i][1] = Math.min(dp[i-1][0]+cost[i][1], dp[i-1][2]+cost[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+cost[i][2], dp[i-1][1]+cost[i][2]);
		}
		
		int answer=-1;
		answer = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		System.out.println(answer);
	}
}