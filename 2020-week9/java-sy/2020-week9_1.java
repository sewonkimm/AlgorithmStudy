import java.util.Scanner;

public class Chess_1018 {
	public static char[][] boardW = {
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'}
	};
	public static char[][] boardB = {
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] board = new char[n][m];
		
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<m; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		int answer = n*m;
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				int count = 0;
				for(int a=0; a<8; a++) {
					for(int b=0; b<8; b++) {
						if(board[i+a][j+b]!=boardW[a][b]) count++;
					}
				}
				if(count<answer) answer = count;
			}
		}
		
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				int count = 0;
				for(int a=0; a<8; a++) {
					for(int b=0; b<8; b++) {
						if(board[i+a][j+b]!=boardB[a][b]) count++;
					}
				}
				if(count<answer) answer = count;
			}
		}
		
		System.out.println(answer);
	}
}
