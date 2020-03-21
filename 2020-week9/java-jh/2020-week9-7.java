import java.io.*;
import java.util.*;

public class Main {
	static int[][] s;
	static int min = Integer.MAX_VALUE;
	static boolean[] isSelected;

	static void rec(int index, int depth) {
		isSelected[index] = true;
		if (depth == s.length / 2 - 1) {
			int teamStart = getTeamValue(true);
			int teamLink = getTeamValue(false);
			int difference = Math.abs(teamStart - teamLink);
			min = difference < min ? difference : min;
			isSelected[index] = false;
			return;
		}
		for (int i = index + 1; i < s.length; i++) {
			rec(i, depth + 1);
		}
		isSelected[index] = false;
	}

	static int getTeamValue(boolean team) {
		int teamValue = 0;
		for (int i = 0; i < s.length - 1; i++) {
			if (isSelected[i] != team)
				continue;
			for (int j = i + 1; j < s.length; j++) {
				if (isSelected[j] == isSelected[i])
					teamValue += (s[i][j] + s[j][i]);
			}
		}
		return teamValue;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		s = new int[n][n];
		isSelected = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			rec(i, 0);
		}
		System.out.print(min);
	}
}