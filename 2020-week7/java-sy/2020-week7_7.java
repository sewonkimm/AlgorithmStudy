import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair30 {
	int x;
	int y;
	
	Pair30(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Numbering_4421 {
	public static ArrayList<Integer> list = new ArrayList<>();
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static void bfs(int[][] map, int x, int y, boolean[][] visit) {
		Queue<Pair30> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new Pair30(x, y));
		
		int count = 0;
		while(!q.isEmpty()) {
			Pair30 position = q.remove();
			int nowX = position.x;
			int nowY = position.y;
			count++;
			
			for(int i=0; i<4; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= map.length || newY >= map.length) continue;
				if(!visit[newX][newY] && map[newX][newY] == 1) {
					q.add(new Pair30(newX, newY));
					visit[newX][newY] = true;
				}
			}
		}
		
		list.add(count);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		boolean[][] visit = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j] && map[i][j] == 1) bfs(map, i, j, visit);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
