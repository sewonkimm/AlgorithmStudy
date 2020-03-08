import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair31 {
	int x;
	int y;
	
	Pair31(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class ElectronicBoard_4060 {
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static void bfs(int[][] board, int x, int y, boolean[][] visit, int b, int m, int n) {
		Queue<Pair31> q = new LinkedList<>();
		q.add(new Pair31(x, y));
		visit[x][y] = true;

		while(!q.isEmpty()) {
			Pair31 position = q.remove();
			int nowX = position.x;
			int nowY = position.y;
			for(int i=0; i<4; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
				if(!visit[newX][newY] && board[newX][newY] == b) {
					q.add(new Pair31(newX, newY));
					visit[newX][newY] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] board = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		boolean[][] visit = new boolean[m][n];
		
		int on = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j] && board[i][j]==0) {
					bfs(board, i, j, visit, 0, m, n);
					on++;
				}
			}
		}
		
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				visit[i][j] = false;
			}
		}
		
		int off = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j] && board[i][j]==1) {
					bfs(board, i, j, visit, 1, m, n);
					off++;
				}
			}
		}
		
		System.out.println(on + " " + off);
	}
}
