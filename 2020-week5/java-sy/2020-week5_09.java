import java.util.Scanner;

public class FillTile_2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+2];
		dp[1] = 0;
		dp[2] = 3;
		
		for(int i=4; i<n+1; i+=2) {
			dp[i] = dp[i-2] * 3;
			for(int j=i-4; j>=2; j-=2) {
				dp[i] += dp[j]*2;
			}
			dp[i]+=2;
		}
		
		System.out.println(dp[n]);
	}
}
