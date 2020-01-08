
import java.util.Scanner;

public class RecolorChessboard_1018 {
	public static int checkChessboard(String[][] board, int n, int m) {
		int count = 0;
		
		for(int i=0; i<8; i++) {
			String start = board[n][m];
			for(int j=0; j<8; j++) {
				if(i%2==j%2) {
					if(!start.equals(board[n+i][m+j])) count++;
				}
				else {
					if(start.equals(board[n+i][m+j])) count++;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String[][] chessboard = new String[n][m];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<m; j++) {
				chessboard[i][j] = String.valueOf(str.charAt(j));
			}
		}
		
		int min = 65;
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				int countChange = checkChessboard(chessboard, i, j);
				if(countChange>32) countChange = 64-countChange;
				min = Math.min(min, countChange);
			}
		}
		
		System.out.println(min);
	}
}
