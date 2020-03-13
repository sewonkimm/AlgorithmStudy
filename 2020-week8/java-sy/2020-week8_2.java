import java.util.Scanner;

public class CandyPicking1_3703 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				 if(i==0 && j==0) {
					 dp[i][j] = map[i][j];
				 }
				 else if(i==0) {
					 dp[i][j] = dp[i][j-1] + map[i][j];
				 }
				 else if(j==0) {
					 dp[i][j] = dp[i-1][j] + map[i][j];
				 }
				 else {
					 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
				 }
			}
		}
		
		System.out.println(dp[n-1][m-1]);
	}
}
