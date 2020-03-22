import java.io.*;
import java.util.*;

public class Main {
	static int count = 0;
	static int[][] room;
	static int[][] coordinate = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static int[][] behindCoordinate = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, +1 } };

	static void clean(int x, int y, int direction) {
		if (room[x][y] == 0) {
			count++;
			room[x][y] = 2;
		}
		int nextDirection = direction;
		int nextX = x;
		int nextY = y;
		for (int i = 0; i < 4; i++) {
			nextX = x + coordinate[nextDirection][0];
			nextY = y + coordinate[nextDirection][1];
			nextDirection = (nextDirection + 3) % 4;
			if (room[nextX][nextY] == 0) {
				clean(nextX, nextY, nextDirection);
				break;
			}
			if (nextDirection == direction) {
				int behindX = x + behindCoordinate[nextDirection][0];
				int behindY = y + behindCoordinate[nextDirection][1];
				if (room[behindX][behindY] == 1)
					return;
				clean(behindX, behindY, nextDirection);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		room = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(x, y, direction);
		System.out.print(count);
	}
}