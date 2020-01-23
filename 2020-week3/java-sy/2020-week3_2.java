import java.util.Scanner;

public class LCS2_9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		
		for(int i=1; i<=str1.length(); i++) {
			char c1 = str1.charAt(i);
			for(int j=0; j<=str2.length(); j++) {
				char c2 = str2.charAt(j);
				
				if(c1==c2) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[str1.length()][str2.length()]);
	}
}
