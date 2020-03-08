import java.util.Scanner;

public class CandyPicking2_3515 {
	public static int answer = 0;
	public static void go(int[][] candy, int i, int j, int sum, boolean[] visit) {
		visit[j] = true;
		answer = Math.max(sum, answer);

		for(int a=0; a<candy.length; a++) {
			if(!visit[a]) {
				go(candy, i+1, a, sum+candy[i+1][a], visit);
			}
		}
		visit[j] = false;
	} 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] candy = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				candy[i][j] = sc.nextInt();
			}
		}
		
		boolean[] visit = new boolean[n];
		for(int i=0; i<n; i++) {
			go(candy, 0, i, candy[0][i], visit);
		}
		System.out.println(answer);
	}
}
