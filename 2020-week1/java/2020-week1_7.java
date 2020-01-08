import java.util.Scanner;

public class IntegerTriangle_1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] number = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				number[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(i==0) {
					dp[i][j] = number[i][j];
					continue;
				}
				
				if(j==0) {
					dp[i][j] = dp[i-1][j]+number[i][j];
					continue;
				}
				
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + number[i][j];
			}
		}
		
		int max = -1;
		for(int i=0; i<n; i++) {
			max = Math.max(max, dp[n-1][i]);
		}
		
		System.out.println(max);
	}
}