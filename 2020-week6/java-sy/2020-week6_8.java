import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int i;
	int j;
	Pair(int i, int j){
		this.i=i;
		this.j=j;
	}
}
public class RedGreen_10026 {
	public static boolean[][] visit;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static void bfs(String[][] color, int i, int j) {
		Queue<Pair> q = new LinkedList<>();
		visit[i][j] = true;
		q.add(new Pair(i, j));
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x=p.i;
			int y=p.j;
			
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx<0 || nx>=color.length || ny<0 || ny>=color.length) continue;
				if(!visit[nx][ny] && color[i][j].equals(color[nx][ny])) {
					visit[nx][ny] = true;
					q.add(new Pair(nx,ny));
				}
			}
		}
	}
	
	public static void colorWeekBfs(String[][] color, int i, int j) {
		Queue<Pair> q = new LinkedList<>();
		visit[i][j] = true;
		q.add(new Pair(i, j));
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x=p.i;
			int y=p.j;
			
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx<0 || nx>=color.length || ny<0 || ny>=color.length) continue;
				if(visit[nx][ny]) continue;
				if(color[i][j].equals("G") || color[i][j].equals("R")) {
					if(color[nx][ny].equals("G") || color[nx][ny].equals("R")) {
						visit[nx][ny] = true;
						q.add(new Pair(nx, ny));
					}
				}else {
					if(color[nx][ny].equals("B")) {
						visit[nx][ny] = true;
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[][] color = new String[n][n];
		visit = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String colors = sc.next();
			color[i] = colors.split("");
		}
		
		int count1 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j]) {
					bfs(color, i, j);
					count1++;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				visit[i][j] = false;
			}
		}
		
		int count2 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j]) {
					colorWeekBfs(color, i, j);
					count2++;
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
	}
}
