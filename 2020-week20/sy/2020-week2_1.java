import java.util.Scanner;

public class Path {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i==0 || j==0) map[i][j] = 1;
				else map[i][j] = map[i][j-1] + map[i-1][j]; 
			}
		}
		
		if(k==0) {
			System.out.println(map[n-1][m-1]); 
			return;
		}
		
		int a = k%m == 0 ? k/m-1 : k/m;
		int b = k%m == 0 ? m-1 : k%m-1;
		
		int answer = map[a][b];
		
		for(int i=a; i<n; i++) {
			for(int j=b; j<m; j++) {
				if(i==a || j==b) map[i][j] = 1;
				else map[i][j] = map[i][j-1] + map[i-1][j]; 
			}
		}
		
		System.out.println(answer * map[n-1][m-1]);
	}
}
