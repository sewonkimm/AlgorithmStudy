import java.util.Arrays;
import java.util.Scanner;

public class FindRoute_11403 {
	public static boolean[] visit;
	public static void dfs(int i, int n, int[][] arr, int cnt) {
		if(cnt!=0) visit[i] = true;
		
		for(int j=0; j<n; j++) {
			if(arr[i][j] == 1 && !visit[j]) {
				dfs(j, n, arr, cnt+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int[][] answer = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			Arrays.fill(visit, false);
			dfs(i, n, arr, 0);
			for(int j=0; j<n; j++) {
				if(visit[j]) {
					answer[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}
}
¤¤