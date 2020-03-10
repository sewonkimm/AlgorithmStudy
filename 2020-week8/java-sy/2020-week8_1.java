import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair33 {
	int x;
	int y;
	Pair33(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class PaintFill_2610 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[10][10];
		boolean[][] visit = new boolean[10][10];
		
		for(int i=0; i<10; i++){
			String str = sc.next();
			for(int j=0; j<10; j++){
				board[i][j] = str.charAt(j);
			}
		}

		int y = sc.nextInt();
		int x = sc.nextInt();
		
		if(board[x][y]=='*') {
			for(int i=0; i<10; i++){
				System.out.println(board[i]);
			}
			return;
		}
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		Queue<Pair33> q = new LinkedList<>();
		q.add(new Pair33(x,y));
		visit[x][y] = true;
		board[x][y] = '*';

		while(!q.isEmpty()) {
			Pair33 pair = q.remove();
			int nx = pair.x;
			int ny = pair.y;
			
			for(int i=0; i<4; i++) {
				int nX = nx + dx[i];
				int nY = ny + dy[i];
				
				if(nX<0 || nX>=10 || nY<0 || nY>=10) continue;
				if(board[nX][nY]=='_' && !visit[nX][nY]) {
					q.add(new Pair33(nX, nY));
					visit[nX][nY] = true;
					board[nX][nY] = '*';
				}
			}
		}
		
		for(int i=0; i<10; i++){
			System.out.println(board[i]);
		}
	}
}
