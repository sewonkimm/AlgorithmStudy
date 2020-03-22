import java.io.*;
import java.util.*;

class Position {
	int x;
	int y;
	int d;
	Position(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
public class RobotCleaner_14503 {
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static boolean[][] visit;
	public static void bfs(int[][] place, int r, int c, int d) {
		Queue<Position> q= new LinkedList<>();
		visit[r][c] = true;
		q.add(new Position(r, c, d));
		int count = 1;
		
		while(!q.isEmpty()) {
			Position p = q.remove();
			int xx = p.x;
			int yy = p.y;
			int dd = p.d;
			
			int cc = 0;

			for(int i=0; i<4; i++) {
				int nDD = dd-1 == -1 ? 3 : dd-1;
				int nXX = xx + dx[nDD];
				int nYY = yy + dy[nDD];
				
				if(nXX<0 || nXX>=place.length || nYY<0 || nYY>=place[0].length) {
					q.add(new Position(xx, yy, nDD));
					break;
				}
				
				if(!visit[nXX][nYY] && place[nXX][nYY] == 0) {
					q.add(new Position(nXX, nYY, nDD));
					visit[nXX][nYY] = true;
					count++;
					break;
				}else {
					cc++;
				}
				dd = nDD;
			}
			
			if(cc == 4) {
				int nDD = dd+2 < 4 ? dd + 2 : dd+2-4;
				int nXX = xx+dx[nDD];
				int nYY = yy+dy[nDD];
				if(place[nXX][nYY] == 0) q.add(new Position(nXX, nYY, dd));
			}
		}
		
		System.out.println(count);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st2.nextToken());
		int c = Integer.parseInt(st2.nextToken());
		int d = Integer.parseInt(st2.nextToken());
		
		int[][] place = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				place[i][j] = Integer.parseInt(st3.nextToken());
			}
		}
		
		bfs(place, r, c, d);
	}
}
