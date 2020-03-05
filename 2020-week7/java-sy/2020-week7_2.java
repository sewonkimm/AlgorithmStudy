package codeup;

import java.util.*;

public class CandyPang_2605 {
	public static boolean[][] visit = new boolean[7][7];
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int answer = 0;
	public static void bfs(int x, int y, int[][] map) {
		Queue<int[]> q = new LinkedList<>();
		int[] position = {x, y};
		q.add(position);
		visit[x][y] = true;
		
		int count = 0;
		while(!q.isEmpty()) {
			int[] now = q.remove();
			count++;
			for(int i=0; i<4; i++) {
				int X = now[0] + dx[i];
				int Y = now[1] + dy[i];
				
				if(X<0 || Y<0 || X>6 || Y>6) continue;
				if(!visit[X][Y] && map[X][Y] == map[x][y]) {
					int[] next = {X, Y};
					q.add(next);
					visit[X][Y] = true;
				}
			}
		}
		
		if(count>=3) answer++;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[7][7];
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				if(!visit[i][j]) {
					bfs(i, j, map);
				}
			}
		}
		
		System.out.println(answer);
	}
}
