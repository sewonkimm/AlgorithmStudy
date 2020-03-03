package codeup;

import java.util.Scanner;

public class ClubPresidentElection_2608 {
	public static char[] ans;
	public static void dfs(int now, int n) {
		if(now == n) {
			System.out.println(ans);
			return;
		}
		ans[now] = 'O';
		dfs(now+1, n);
		ans[now] = 'X';
		dfs(now+1, n);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ans = new char[n];
		dfs(0, n);
	}
}
