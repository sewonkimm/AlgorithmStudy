import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// init
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		boolean[][] isSlope = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// check
		for (int i = 0; i < n; i++) {
			int j;
			for (j = 0; j < n - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					continue;
				} else if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
					break;
				} else if (map[i][j] - 1 == map[i][j + 1]) {
					boolean flag = false;
					for (int k = 1; k < l; k++) {
						if (j + 1 + k >= n || map[i][j + 1] != map[i][j + 1 + k]) {
							flag = true;
							break;
						}
					}
					if (flag) {
						break;
					} else {
						for (int k = 0; k < l; k++) {
							isSlope[i][j + 1 + k] = true;
						}
					}
				} else if (map[i][j] + 1 == map[i][j + 1]) {
					// 오르막
					// 뒤로 같은 높이인지 확인하면서 이미 경사아닌지 확
					boolean flag = false;
					for (int k = 0; k < l; k++) {
						if (j - k < 0 || isSlope[i][j - k] || map[i][j] != map[i][j - k]) {
							flag = true;
							break;
						}
					}
					if (flag) {
						break;
					} else {
						for (int k = 0; k < l; k++) {
							isSlope[i][j - k] = true;
						}
					}
				}
			}
			if (j == n - 1)
				answer++;
		}

		for (int i = 0; i < n; i++) {
			Arrays.fill(isSlope[i], false);
		}

		for (int i = 0; i < n; i++) {
			int j;
			for (j = 0; j < n - 1; j++) {
				if (map[j][i] == map[j + 1][i]) {
					continue;
				} else if (Math.abs(map[j][i] - map[j + 1][i]) > 1) {
					break;
				} else if (map[j][i] - 1 == map[j + 1][i]) {
					boolean flag = false;
					for (int k = 1; k < l; k++) {
						if (j + 1 + k >= n || map[j + 1][i] != map[j + 1 + k][i]) {
							flag = true;
							break;
						}
					}
					if (flag) {
						break;
					} else {
						for (int k = 0; k < l; k++) {
							isSlope[j + 1 + k][i] = true;
						}
					}
				} else if (map[j][i] + 1 == map[j + 1][i]) {
					// 오르막
					// 뒤로 같은 높이인지 확인하면서 이미 경사아닌지 확
					boolean flag = false;
					for (int k = 0; k < l; k++) {
						if (j - k < 0 || isSlope[j - k][i] || map[j][i] != map[j - k][i]) {
							flag = true;
							break;
						}
					}
					if (flag) {
						break;
					} else {
						for (int k = 0; k < l; k++) {
							isSlope[j - k][i] = true;
						}
					}
				}
			}
			if (j == n - 1)
				answer++;
		}
		// print
		System.out.print(answer);
	}
}